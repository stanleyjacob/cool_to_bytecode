package cs143.semant;
import cs143.ast.*;
import cs143.environment.*;

import java.util.*;
/*
 * Given an AST, visit it, filling in the type_names wherever appropriate.
 */

public class SemantVisitor extends AstVisitor<Ast> {
    Environment env = new Environment();
    BuiltinKlasses biks = new BuiltinKlasses(env);
    String curr_class_name;
    boolean debug_mode = false;

    String classOfType(String name) {
        if (debug_mode)
            System.out.println("Class of type");
        if (name.equals(Singletons.SELF_TYPE)) return curr_class_name;
        return name;
    }

    boolean klassExists(String name) {
        if (debug_mode)
            System.out.println("Klass exists");
        return env.klassTable.containsKey(name);
    }

    boolean klassConforms(String subclass, String superclass) {
        if (debug_mode) {
            System.out.println("Conform check");

            System.out.println(subclass + " : " + superclass + "?");
        }
        if (subclass.equals(Singletons.NOTYPE)) return false;
        if (superclass.equals(Singletons.NOTYPE)) return false;

        if (subclass.equals(Singletons.SELF_TYPE)) {
            return klassConforms(curr_class_name, superclass);
        }
        if (superclass.equals(Singletons.SELF_TYPE)) {
            return klassConforms(subclass, curr_class_name);
        }
        if (subclass.equals(superclass)) return true;
        if (subclass.equals(Singletons.OBJECT)) return false;
        return klassConforms(env.parent.get(subclass), superclass);
    }

    String klassJoin(String t, String u) {
        if (debug_mode) {
            System.out.println("Klass join");
        }
        if (t.equals(Singletons.SELF_TYPE) && u.equals(Singletons.SELF_TYPE))
            return Singletons.SELF_TYPE;
        if (klassConforms(t, u)) return u;
        if (klassConforms(u, t)) return t;
        return klassJoin(env.parent.get(u), t);
    }

    @Override
    public Ast visitProgram(Program p) {
        if (debug_mode) {
            System.out.println("Visiting program");
        }

        new PopulateGlobalEnvironment(env, biks).installKlasses(p);

        for (Klass k : p.klasses()) {
            visitKlass(k);
        }

        return p;
    }

    @Override
    public Ast visitKlass(Klass k) {

      try{
        if (!klassExists(k.class_name())) {
            throw new SemanticException("Line " + k.line_num() +
              ": class used with undefined class " + k.class_name() );
        }
        if (! klassExists(k.base_class_name())) {
            throw new SemanticException("Line " + k.line_num() +
              ": class used with undefined base class " + k.base_class_name() );
        }

        if (debug_mode) {
            System.out.println("Checking class: " + k.class_name());
        }

        curr_class_name = k.class_name();

        env.enterClass(k.class_name());

        for (Feature f : k.features()) {
            if (f instanceof MethodFeature) {
                visitMethodFeature((MethodFeature) f);
            }
            if (f instanceof AttrFeature) {
                visitAttrFeature((AttrFeature) f);
            }
        }

        env.exitClass();
      }
      catch (SemanticException e) {
          System.out.println(e);
          System.exit(-1);
      }

        return k;
    }

    @Override public Ast visitMethodFeature(MethodFeature m) {

        if (debug_mode) {
            System.out.println("Visiting Method feature...");
        }

        env.enterMethod();

        try {
            /* visit all formals */

            List<String> formal_names = new ArrayList<>();
            for(Formal f : m.formals()) {
                visitFormal(f);
                if (!klassExists ( f.ty_name() )) {
                    throw new SemanticException("Line " + m.line_num() +
                      ": formal used with undefined class " + f.ty_name() );
                }

                if (f.formal_name() == "self") {
                    throw new SemanticException("Line " + m.line_num() +
                      ": 'self' cannot be the name of a formal parameter. ");
                }

                if ( formal_names.contains(f.formal_name()) ) {
                    throw new SemanticException("Line " + m.line_num() +
                      ": Formal parameter " + f.formal_name() + " is multiply defined." );
                }

                formal_names.add(f.formal_name());
            }

            if (debug_mode) {
                System.out.println("Visiting method body");
            }

            // visit method body
            visit(m.expr());

            String method_body_type = m.expr().type_name();
            String other_type = m.ty_name();
            // if (other_type == "SELF_TYPE") {
            //     other_type = curr_class_name;
            // }

            boolean conform_res =
                klassConforms(method_body_type, other_type);

            boolean conform_res2 = true;
            if (other_type == "SELF_TYPE" && method_body_type != "SELF_TYPE") {
                conform_res2 = false;
            }

            if (!conform_res || !conform_res2) {
                throw new SemanticException("Line " + m.line_num() + ": Method conformance problem between "
                    + method_body_type + " and declared type " + other_type );
            }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        // exit scope
        env.exitMethod();

        return m;
    }

    @Override public Ast visitAttrFeature(AttrFeature a) {

        if (debug_mode) {
            System.out.println("Visiting Attribute feature...");
        }

        try {

            if (a.attr_name() == "self") {
                throw new SemanticException("Line " + a.line_num() + ": 'self' cannot be the name of an attribute.");
            }
            if (a.expr() != null) {
                visit(a.expr());
            }

            // Make sure a.expr().type_name() conforms to right type
            if ( !env.isVar(a.attr_name()) ) {
                throw new SemanticException("Line " + a.line_num() + ": Undeclared attribute: "
                    + a.attr_name() );
            }
            String left_attr_type = env.findVar(a.attr_name()).type;

            if (! klassExists(left_attr_type) && left_attr_type != "SELF_TYPE" ) {
                throw new SemanticException("Line " + a.line_num() +
                  ": attr used with undefined class " + left_attr_type );
            }


            if (a.expr() != null) {

                String right_attr_type = a.expr().type_name();

                if (right_attr_type == "_no_type") {

                    if (debug_mode) {
                        System.out.println("No expr detected");
                    }
                }

                else {

                  if (! klassExists(right_attr_type) && right_attr_type != "SELF_TYPE" ) {
                      throw new SemanticException("Line " + a.line_num() +
                        ": attr used with undefined class " + right_attr_type );
                  }

                  // make sure you conform:
                  boolean conform_res =
                      klassConforms(right_attr_type, left_attr_type);
                  if (!conform_res) {

                      if (debug_mode) {
                          System.out.println("Attribute conformance problem");
                      }

                      throw new SemanticException("Line " + a.line_num() + ": Attribute conformance problem between "
                          + right_attr_type + " and declared type " + left_attr_type);

                  }
                }
            }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return a;
    }

    @Override public Ast visitFormal(Formal f) {

        if (debug_mode) {
            System.out.println("Visiting Formal...");
        }

        try {

            if (f.ty_name() == "SELF_TYPE") {
                throw new SemanticException("Line " + f.line_num() +
                  ": Formal parameter " + f.formal_name() + " cannot have type SELF_TYPE."
                    );
            }
            // Need to add formals to current scope
            // Add to var sym tab
            VarSymbol s = new VarSymbol();
            s.id = f.formal_name();
            s.kind = VarSymbol.SymbolKind.param;
            s.defKlass = curr_class_name;
            s.type = f.ty_name();

            env.varsymtab.put(s.id, s);

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return f;
    }

    @Override public Ast visitAssignExpr(AssignExpr a) {

        if (debug_mode) {
            System.out.println("Visiting Assign expr...");
        }
        // System.out.println(a.id());

        try {

            // figure out the assign type
            // of the lefthand side by
            // looking up in the varsymbol table
            if (a.id() == "self") {
                throw new SemanticException("Line " + a.line_num() + ": Cant assign "
                    + a.id() );
            }
            if (!env.isVar(a.id()) ) {
                throw new SemanticException("Line " + a.line_num() + ": Undeclared identifier: "
                    + a.id() );
            }
            String lefthand_assign_type = env.findVar(a.id()).type;

            // a.set_type_name(lefthand_assign_type);

            visit(a.expr());

            // Have to check if a.expr() type is <= left side
            boolean conform_res =
                klassConforms(a.expr().type_name(), lefthand_assign_type);
            if (!conform_res) {
                throw new SemanticException("Line " + a.line_num() + ": Type " + a.expr().type_name() +
                  " of assigned expression does not conform to declared type " +
                  lefthand_assign_type + " of identifier " + a.id());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        a.set_type_name(a.expr().type_name());

        return a;
    }

    @Override public Ast visitStaticDispatchExpr(StaticDispatchExpr a) {

        if (debug_mode) {
            System.out.println("Visiting Static Dispatch expr...");
        }

        try {
            // visit e0
            visit(a.expr());

            // visit e1 to en
            List <String> actual_types = new ArrayList<>();
            for(Expr actual: a.actuals()) {
                visit(actual);
                actual_types.add(actual.type_name());
            }

            // determine e0 type
            String e0_type = a.expr().type_name();
            String static_at_type = a.at();

            boolean conf_check =
                klassConforms(e0_type, static_at_type);

            if (!conf_check) {
                if (debug_mode) {
                    System.out.println("Confrmance Problem in Static");
                }

                throw new SemanticException("Line " + a.line_num() + ": Expression type " + e0_type
                    + " does not conform to declared static dispatch type " + static_at_type
                     );
            }


            // look up method
            // methsymtab works
            if (! env.isMethod(a.mname(), a.at()) ) {
                throw new SemanticException("Line " + a.line_num() + ": Static dispatch to undefined method: "
                    + a.mname() + "in class " + a.at());
            }
            MethodSymbol curr_meth = env.findMethod(a.mname(), a.at());

            // make sure actual types inherit from formal types
            List<String> formal_types = curr_meth.argTy;
            for (int i = 0; i < formal_types.size(); ++i) {
                boolean conform_check =
                    klassConforms(actual_types.get(i),
                        formal_types.get(i));
                if (!conform_check) {

                    if (debug_mode) {
                        System.out.println("Doesn't conform");
                    }

                    throw new SemanticException("Line " + a.line_num() + ": Expression type " + actual_types.get(i)
                        + "does not conform to declared static dispatch type " + formal_types.get(i)
                         );
                }
            }

            String ret_type = curr_meth.type;
            if (ret_type == "SELF_TYPE") {
                ret_type = a.expr().type_name();
            }

            // set the return type of function call
            a.set_type_name(ret_type);
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return a;
    }

    @Override public Ast visitDispatchExpr(DispatchExpr d) {

        if (debug_mode) {
            System.out.println("Visiting Dispatch expr...");
        }

        try {
            // visit e0
            visit(d.expr());

            // visit e1 to en
            List <String> actual_types = new ArrayList<>();
            for(Expr actual: d.actuals()) {
                visit(actual);
                actual_types.add(actual.type_name());
            }

            // determine e0 type
            String e0_type = d.expr().type_name();
            if (e0_type == "SELF_TYPE") {
                e0_type = curr_class_name;
            }

            // look up method
            // methsymtab works
            if (! env.isMethod(d.mname(), e0_type) ) {
                throw new SemanticException("Line " + d.line_num() + ": Dispatch to undefined method: "
                    + d.mname() );
            }
            MethodSymbol curr_meth = env.findMethod(d.mname(), e0_type);

            // make sure actual types inherit from formal types
            List<String> formal_types = curr_meth.argTy;
            for (int i = 0; i < formal_types.size(); ++i) {
                boolean conform_check =
                    klassConforms(actual_types.get(i),
                        formal_types.get(i));
                if (!conform_check) {

                    if (debug_mode) {
                        System.out.println("Doesn't conform");
                    }

                    throw new SemanticException("Line " + d.line_num() + ": Expression type " + actual_types.get(i)
                        + " of parameter " + i + " does not conform to declared dispatch type " + formal_types.get(i)
                         );

                }
            }

            String ret_type = curr_meth.type;
            if (ret_type == "SELF_TYPE") {
                ret_type = d.expr().type_name();
            }

            // set the return type of function call
            d.set_type_name(ret_type);
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return d;
    }

    @Override public Ast visitCondExpr(CondExpr c) {

        if (debug_mode) {
            System.out.println("Visiting Cond expr...");
        }

        visit(c.cond());
        visit(c.then());
        visit(c.els());

        try {
            if (c.cond().type_name() != "Bool") {
                if (debug_mode) {
                    System.out.println("Conditional problem in if part");
                }
                throw new SemanticException("Line " + c.line_num() + ": Predicate of 'if' does not have type Bool.");
            }


          String type_then = c.then().type_name();
          String type_els = c.els().type_name();

          if (type_then != "SELF_TYPE" && !klassExists( type_then )) {
            throw new SemanticException("Line " + c.line_num() +
              ": cond used with undefined class " + type_then );
          }
          if (type_els != "SELF_TYPE" && !klassExists( type_els )) {
            throw new SemanticException("Line " + c.line_num() +
              ": cond used with undefined class " + type_els );
          }

          if (type_then == type_els) {
              // idempotent
              c.set_type_name(type_then);
          }
          else {
              // have to find common ancestor
              // between types type_then, type_els
              String common_ancestor = klassJoin(type_then, type_els);
              c.set_type_name(common_ancestor);
          }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return c;
    }

    @Override public Ast visitLoopExpr(LoopExpr l) {

        if (debug_mode) {
            System.out.println("Visiting Loop expr...");
        }

        visit(l.cond());
        visit(l.body());

        try {
            if (l.cond().type_name() != "Bool") {

                if (debug_mode) {
                    System.out.println("Loop conditional problem");
                }

                throw new SemanticException("Line " + l.line_num() + ": Bad types in loop expression. cond type: "
                    + l.cond().type_name() + ", body type: " + l.body().type_name());

            }
            else {
                if (! klassExists( l.body().type_name() ) &&  l.body().type_name() != "SELF_TYPE") {
                  throw new SemanticException("Line " + l.line_num() +
                    ": loop used with undefined class " + l.body().type_name() );
                }
            }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        l.set_type_name("Object");

        return l;
    }

    @Override public Ast visitBlockExpr(BlockExpr b) {

        if (debug_mode) {
            System.out.println("Visiting Block expr...");
        }

        try {
          List<Expr> exprs = b.exprs();

          for(Expr expr: exprs) {
              visit(expr);

              if (! klassExists( expr.type_name() ) && expr.type_name() != "SELF_TYPE") {
                throw new SemanticException("Line " + b.line_num() +
                  ": block used with undefined class " + expr.type_name() );
              }

              // block has type of last expression
              b.set_type_name(expr.type_name());
          }

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return b;
    }

    @Override public Ast visitLetExpr(LetExpr l) {

        if (debug_mode) {
            System.out.println("Visiting Let expr...");
        }

        env.enterLet();

        try {

            if (l.id() == "self") {
                  throw new SemanticException("Line " + l.line_num() +
                    ": 'self' cannot be bound in a 'let' expression.");
            }

            // add new symbol to varsymtab
            VarSymbol s = new VarSymbol();
            s.id = l.id();
            s.kind = VarSymbol.SymbolKind.letvar;
            s.defKlass = curr_class_name;
            s.type = l.ty();

            if (l.ty() == "SELF_TYPE") {
                s.type = curr_class_name;
            }

            env.varsymtab.put(s.id, s);


            String new_letvar_type = l.ty();
            if (l.ty() == "SELF_TYPE") {
                new_letvar_type = curr_class_name;
            }

            if (l.init() != null) {

                // System.out.println(l.init().type_name());
                visit(l.init());

                if (! klassExists( l.init().type_name() ) && l.init().type_name() != "SELF_TYPE"
                    && l.init().type_name() != "_no_type") {
                    throw new SemanticException("Line " + l.line_num() +
                      ": let init used with undefined class " + l.init().type_name() );
                }

                // assuming no type means no initialization
                if (l.init().type_name() != "_no_type") {
                    boolean conf_res =
                        klassConforms(l.init().type_name(), new_letvar_type);

                    if (!conf_res) {

                        if (debug_mode) {
                            System.out.println("Conf problem in let init");
                        }

                        throw new SemanticException("Line " + l.line_num() + ": Type " + l.init().type_name() +
                          " of let expression does not conform to type " +
                          new_letvar_type);
                    }
                }

            }

            if (l.body() != null) {
                visit(l.body());

                if (! klassExists( l.body().type_name() ) &&  l.body().type_name() != "SELF_TYPE") {
                  throw new SemanticException("Line " + l.line_num() +
                    ": let body used with undefined class " + l.body().type_name() );
                }

                l.set_type_name(l.body().type_name());
            }
            else {

                if (debug_mode) {
                    System.out.println("Let has no body");
                }
                throw new SemanticException("Line " + l.line_num() + ": Let body type undefined");

            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }


        env.exitLet();

        return l;
    }

    @Override public Ast visitTypCaseExpr(TypCaseExpr t) {

        if (debug_mode) {
            System.out.println("Visiting typcase expr...");
        }

        try {
            visit(t.expr());

            if (!klassExists( t.expr().type_name() ) && t.expr().type_name() != "SELF_TYPE" ) {
                throw new SemanticException("Line " + t.line_num() +
                  ": typecase used with undefined class " + t.expr().type_name() );
            }

            List<String> kase_types = new ArrayList<>();
            List<String> kase_types2 = new ArrayList<>();
            for (Kase kase : t.kases()) {
                visitKase(kase);

                if ( kase_types2.contains(kase.case_ty() ) ) {
                    throw new SemanticException("Line " + t.line_num() + ": Duplicate branch " +
                    kase.case_ty() + " in case statement");
                }
                kase_types.add(kase.expr().type_name());
                kase_types2.add(kase.case_ty());

                // boolean conf_res =
                //     klassConforms(kase.expr().type_name(), t.expr().type_name());
                //
                // if (!conf_res) {
                //     throw new SemanticException("In case expression, Inferred type " +
                //         kase.expr().type_name() + " of initialization of attribute " +
                //         kase.id() + " does not conform to declared type " +
                //         kase.case_ty());
                // }

                if (! klassExists( kase.expr().type_name() ) && kase.expr().type_name() != "SELF_TYPE" ) {
                    throw new SemanticException("Line " + t.line_num() +
                      ": a case used with undefined class " + kase.expr().type_name() );
                }
            }


            String res_case_type = kase_types.get(0);
            for (String curr_type : kase_types) {
                res_case_type = klassJoin(res_case_type, curr_type);
            }

            t.set_type_name(res_case_type);
        // }
        // catch (SemanticException e) {
        //     System.out.println(e);
        //     System.exit(-1);
        // }
      }
      catch (SemanticException e) {
          System.out.println(e);
          System.exit(-1);
      }

        return t;
    }

    @Override public Ast visitNewExpr(NewExpr n) {
        if (debug_mode) {
            System.out.println("Visiting new expr...");
        }

        try {
          if (n.id() == "SELF_TYPE") {
              n.set_type_name(curr_class_name);
          }
          else {

              if (!klassExists( n.id() ) && n.id() != "SELF_TYPE") {
                  throw new SemanticException("Line " + n.line_num() +
                  ": 'new' used with undefined class " + n.id() );
              }
              n.set_type_name(n.id());

          }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return n;
    }

    @Override public Ast visitIsVoidExpr(IsVoidExpr i) {

        if (debug_mode) {
          System.out.println("Visiting isvoid expr...");
        }

        try {
        // Need to make sure class exists ?
        visit(i.expr());
        if (! klassExists( i.expr().type_name() ) &&
          i.expr().type_name() != "SELF_TYPE" ) {
            throw new SemanticException("Line " + i.line_num() +
              ": 'isvoid' used with undefined class " + i.expr().type_name() );
        }

        i.set_type_name("Bool");

        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return i;
    }

    @Override public Ast visitPlusExpr(PlusExpr p) {

        if (debug_mode) {
          System.out.println("Visiting plus expr...");
        }

        visit(p.left());
        visit(p.right());

        try {
            if (p.left().type_name() == "Int" &&
                p.right().type_name() == "Int") {
                p.set_type_name("Int");
            }
            else {
                if (debug_mode) {
                  System.out.print("Plus expr problem");
                }
                throw new SemanticException("Line " + p.line_num() + ": non_Int arguments: "
                    + p.left().type_name() + " + " + p.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return p;
    }

    @Override public Ast visitSubExpr(SubExpr s){

        if (debug_mode) {
          System.out.println("Visiting sub expr...");
        }

        visit(s.left());
        visit(s.right());

        try {
            if (s.left().type_name() == "Int" &&
                s.right().type_name() == "Int") {
                s.set_type_name("Int");
            }
            else {
                if (debug_mode) {
                  System.out.print("Sub expr problem");
                }
                throw new SemanticException("Line " + s.line_num() + ": non_Int arguments: "
                    + s.left().type_name() + " - " + s.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return s;
    }

    @Override public Ast visitMulExpr(MulExpr m){

        if (debug_mode) {
          System.out.println("Visiting MulExpr...");
        }

        visit(m.left());
        visit(m.right());

        try {
            if (m.left().type_name() == "Int" &&
                m.right().type_name() == "Int") {
                m.set_type_name("Int");
            }
            else {
                if (debug_mode) {
                  System.out.print("Mul expr problem");
                }
                throw new SemanticException("Line " + m.line_num() + ": non_Int arguments: "
                    + m.left().type_name() + " * " + m.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return m;
    }

    @Override public Ast visitDivideExpr(DivideExpr d) {

        if (debug_mode) {
          System.out.println("Visiting DivideExpr...");
        }

        visit(d.left());
        visit(d.right());

        try {
            if (d.left().type_name() == "Int" &&
                d.right().type_name() == "Int") {
                d.set_type_name("Int");
            }
            else {
                if (debug_mode) {
                  System.out.print("Div expr problem");
                }
                throw new SemanticException("Line " + d.line_num() + ": non_Int arguments: "
                    + d.left().type_name() + " / " + d.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return d;
    }

    @Override public Ast visitNegExpr(NegExpr n) {

        if (debug_mode) {
          System.out.println("Visiting NegExpr...");
        }

        visit(n.expr());

        try {
            if (n.expr().type_name() == "Int") {

                if (debug_mode) {
                    System.out.println("Int negation");
                }
                n.set_type_name("Int");
            }
            else {
                if (debug_mode) {
                    System.out.println("Negation problem");
                }
                throw new SemanticException("Line " + n.line_num() + ": non_Int arguments: "
                    + " ~ " + n.expr().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return n;
    }

    @Override public Ast visitLtExpr(LtExpr l) {

        if (debug_mode) {
            System.out.println("Visiting LtExpr...");
        }

        visit(l.left());
        visit(l.right());

        try {
            if (l.left().type_name() == "Int" &&
                l.right().type_name() == "Int") {
                l.set_type_name("Bool");
            }
            else {

                if (debug_mode) {
                    System.out.println("Lt has problem");
                }
                throw new SemanticException("Line " + l.line_num() + ": non_Int arguments: "
                    + l.left().type_name() + " < " + l.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return l;
    }

    @Override public Ast visitEqExpr(EqExpr e) {

        if (debug_mode) {
            System.out.println("Visiting EqExpr...");
        }

        visit(e.left());
        visit(e.right());

        try {
            String left_type = e.left().type_name();
            if (left_type == "String" ||
                left_type == "Int" ||
                left_type == "Bool") {

                if (e.left().type_name() == e.right().type_name()) {

                    e.set_type_name("Bool");
                }
                else {

                    if (debug_mode) {
                        System.out.println("Problem in eq");
                    }
                    throw new SemanticException("Line " + e.line_num() + ": Illegal comparison with a basic type");
                }
            }
            else {

                if (!klassExists(e.left().type_name()) && e.left().type_name() != "SELF_TYPE") {
                    throw new SemanticException("Line " + e.line_num() +
                      ": eq used with undefined class " + e.left().type_name() );
                }


                if (!klassExists(e.right().type_name()) && e.right().type_name() != "SELF_TYPE") {
                    throw new SemanticException("Line " + e.line_num() +
                      ": eq used with undefined class " + e.right().type_name() );
                }

                e.set_type_name("Bool");
            }
        }
        catch (SemanticException sem_except) {
            System.out.println(sem_except);
            System.exit(-1);
        }

        return e;
    }

    @Override public Ast visitLeqExpr(LeqExpr l) {

        if (debug_mode) {
            System.out.println("Visiting LeqExpr...");
        }

        visit(l.left());
        visit(l.right());

        try {
            if (l.left().type_name() == "Int" &&
                l.right().type_name() == "Int") {
                l.set_type_name("Bool");
            }
            else {
                if (debug_mode) {
                    System.out.println("Leq has problem");
                }
                throw new SemanticException("Line " + l.line_num() + ": non_Int arguments: "
                    + l.left().type_name() + " <= " + l.right().type_name());
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return l;
    }

    @Override public Ast visitCompExpr(CompExpr c) {

        if (debug_mode) {
            System.out.println("Visiting CompExpr...");
        }

        visit(c.expr());

        try {
            if (c.expr().type_name() == "Bool") {

                if (debug_mode) {
                    System.out.println("Bool negation");
                }
                c.set_type_name("Bool");
            }
            else {
                if (debug_mode) {
                    System.out.println("Comp problem");
                }
                throw new SemanticException("Line " + c.line_num() + ": Argument of 'not' has type " +
                    c.expr().type_name() + " instead of Bool");
            }
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return c;
    }

    /* Common types start */
    @Override public Ast visitIntExpr(IntExpr i) {

        if (debug_mode) {
            System.out.println("Visiting int...");
        }

        i.set_type_name("Int");

        return i;
    }

    @Override public Ast visitStringExpr(StringExpr s) {

        if (debug_mode) {
            System.out.println("Visiting StringExpr...");
        }

        s.set_type_name("String");

        return s;
    }

    @Override public Ast visitBoolExpr(BoolExpr b) {

        if (debug_mode) {
            System.out.println("Visiting BoolExpr...");
        }

        b.set_type_name("Bool");

        return b;
    }
    /* Common types done */

    /* For Object, need to be careful about SELF_TYPE */
    @Override public Ast visitObjectExpr(ObjectExpr o) {

        if (debug_mode) {
            System.out.println("Visiting ObjectExpr...");
        }

        try {
            // need to look up the object / variable
            // using the varsymbol table
            String var_type;
            if (o.id() == "self") {
                var_type = "SELF_TYPE";
            }
            else {

                if (!env.isVar(o.id()) ) {
                    throw new SemanticException("Line " + o.line_num() + ": Undeclared identifier: "
                        + o.id() );
                }
                var_type = env.findVar(o.id()).type;
            }

            // end gracefully if variable not found
            if (var_type == null) {
                throw new SemanticException("Line " + o.line_num() + ": Undeclared identifier: "
                    + o.id() );
            }

            o.set_type_name(var_type);
        }
        catch (SemanticException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return o;
    }

    @Override public Ast visitNoExprExpr(NoExprExpr n) {

        if (debug_mode) {
            System.out.println("Visiting NoExprExpr...");
        }

        // Leaving as default
        return n;
    }

    @Override public Ast visitKase(Kase k) {

        if (debug_mode) {
            System.out.println("Visiting Kase...");
        }

        // scoping with Kase ??
        env.varsymtab.pushScope();

        VarSymbol s = new VarSymbol();
        s.id = k.id();
        s.kind = VarSymbol.SymbolKind.letvar;
        s.defKlass = curr_class_name;
        s.type = k.case_ty();

        env.varsymtab.put(s.id, s);

        visit(k.expr());

        env.varsymtab.popScope();
        return k;
    }

}
