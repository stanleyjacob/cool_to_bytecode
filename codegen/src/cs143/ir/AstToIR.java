package cs143.ir;

import cs143.ast.*;
import cs143.environment.*;
import java.io.PrintStream;

import java.util.*;

public class AstToIR extends AstVisitor<Code> {

    Environment env = new Environment();

    BuiltinKlasses biks = new BuiltinKlasses(env);

    String curr_class_name;
    boolean converged;
    boolean new_visited;

    @Override
    public Code visitProgram(Program p) {

        // env = new Environment();
        // biks = new BuiltinKlasses(env);

        new PopulateGlobalEnvironment(env, biks).installKlasses(p);

        // Now we visit all the AST klasses, creating KlassCode's
        List<KlassCode> klasses = new ArrayList<>();

        // Builtins do not appear in Program AST syntactically, so we kick them off here
        // using a different way that does not actually visit the attributes or methods.
        klasses.add(visitBuiltinKlass(biks.objectKlass));

        List<String> arg_types = new ArrayList<String>();
        env.addMethod("Object", "abort", arg_types, "Object");

        List<String> arg_types2 = new ArrayList<String>();
        env.addMethod("Object", "type_name", arg_types2, "String");

        List<String> arg_types3 = new ArrayList<String>();
        env.addMethod("Object", "copy", arg_types3, "Object");

        env.addMethodsToSymbolTable("Object", env.methsymtab);



        klasses.add(visitBuiltinKlass(biks.ioKlass));


        List<String> arg_types4 = Arrays.asList("String");
        env.addMethod("IO", "out_string", arg_types4, "IO");

        List<String> arg_types5 = Arrays.asList("Int");
        env.addMethod("IO", "out_int", arg_types5, "IO");

        List<String> arg_types6 = new ArrayList<String>();
        env.addMethod("IO", "in_string", arg_types6, "String");

        List<String> arg_types7 = new ArrayList<String>();
        env.addMethod("IO", "in_int", arg_types7, "Int");

        env.addMethodsToSymbolTable("IO", env.methsymtab);



        klasses.add(visitBuiltinKlass(biks.stringKlass));

        List<String> arg_types8 = new ArrayList<String>();
        env.addMethod("String", "length", arg_types8, "Int");

        List<String> arg_types9 = Arrays.asList("String");
        env.addMethod("String", "concat", arg_types9, "String");

        List<String> arg_types10 = Arrays.asList("Int", "Int");
        env.addMethod("String", "substr", arg_types10, "String");

        env.addMethodsToSymbolTable("String", env.methsymtab);



        klasses.add(visitBuiltinKlass(biks.intKlass));
        klasses.add(visitBuiltinKlass(biks.boolKlass));


        for (Klass k : p.klasses()) {
             visitKlassMethodSignatures(k);
             env.addKlass(k.class_name(), k.base_class_name());
             env.parent.put(k.class_name(), k.base_class_name());
        }

        // env.methsymtab

        boolean started = true;
        converged = true;
        while (!converged || started) {
            converged = true;
            started = false;
            for (Klass k : p.klasses()) {

                 KlassCode c = (KlassCode) visitKlass(k);
                 visitAttributes(k);
                 klasses.add(c);
            }
            System.out.println("Converging...");
        }

        ProgramCode pc = new ProgramCode(klasses);
        return pc;
    }

    public KlassCode visitBuiltinKlass(Klass k) {
        KlassSymbol s = env.klassTable.get(k.class_name());

        // System.out.println(k.class_name());

        return new KlassCode(s,
                env.klassTable.get(env.parent.get(k.class_name())),
                env.klassAttrTable.get(k.class_name()).values(),
                env.klassMethodTable.get(k.class_name()).values(),
                new ArrayList<>());
    }

    public void visitAttributes(Klass k) {
        env.enterClass(k.class_name());
        env.addParam(k.class_name(),"self", "SELF_TYPE", 0);

        env.seq_no = 1;
        curr_class_name = k.class_name();
        Map<String, VarSymbol> attributes = env.klassAttrTable.get(k.class_name());

        List<AttrFeature> attr_feat_list = new ArrayList<AttrFeature>();

        // Now we visit all the features of the class, creating the code
        for (Feature f : k.features()) {
            /* if we have a method feature */
            if(f instanceof AttrFeature) {
                AttrFeature curr_attr_feature = (AttrFeature) f;

                attr_feat_list.add(curr_attr_feature); // for dealing with attributes codegen

                System.out.println("Detecting attribute: " +
                     curr_attr_feature.attr_name());
                env.addAttr(curr_class_name,
                    curr_attr_feature.attr_name(),
                    curr_attr_feature.ty_name());

                AttrCode ac = (AttrCode) visitAttrFeature(curr_attr_feature);


                Map<String, AttrCode> klassAttrCodeTable =
                    env.klassAttrCodeTable.get(curr_class_name);

                klassAttrCodeTable.put(curr_attr_feature.attr_name(), ac);

                // System.out.println(ac.expr().insts().size());
                // need to add implicit assign of the return value
                // to some temp var

                VarSymbol curr_attr_symbol = ac.attribute();
                curr_attr_symbol.kind = VarSymbol.SymbolKind.attr;
                System.out.println("Putting this attribute: " + f.attr_name());
                attributes.put(f.attr_name(), ac.attribute());
            }
        }
        env.klassAttrFeatureTable.put(curr_class_name, attr_feat_list);

        env.exitClass();
    }

    public KlassCode visitKlass(Klass k) {

        env.enterClass(k.class_name());
        // env.addAttr(k.class_name(),"self", "SELF_TYPE");
        env.addParam(k.class_name(),"self", "SELF_TYPE", 0);

        curr_class_name = k.class_name();
        System.out.println("I'm in class: " + curr_class_name);

        /*get method table and attribute table */
        Map<String, MethodSymbol> methods = env.klassMethodTable.get(k.class_name());
        Map<String, VarSymbol> attributes = env.klassAttrTable.get(k.class_name());

        /*list of meathod codes */
        List<MethodCode> methodcodes = new ArrayList<>();

        // Now we visit all the features of the class, creating the code
        for (Feature f : k.features()) {
            /* if we have a method feature */
            if(f instanceof MethodFeature) {
                MethodFeature curr_method_feature = (MethodFeature) f;
                List<String> argTy = visitMethodSignature(curr_method_feature);

                if (env.findMethod(curr_method_feature.attr_name()) == null) {
                    System.out.println("Method name is null");
                    converged = false;
                    continue;
                }
                else {
                    System.out.println("Method name is: " +
                        curr_method_feature.attr_name());
                }

                env.addMethod(curr_class_name,
                    curr_method_feature.attr_name(),
                    argTy,
                    curr_method_feature.ty_name()
                    );

                MethodCode mc = (MethodCode) visitMethodFeature((MethodFeature)f);
                methods.put(f.attr_name(), mc.method());
                methodcodes.add(mc);
            /* if we have an attribute feature */
            }
        }

        System.out.println("Curr attributes for " + k.class_name());
        for (String x : attributes.keySet()) {
            System.out.println(x);
        }
        for (VarSymbol curr_sym : attributes.values()) {
            System.out.println(curr_sym.kind);
        }
        // env.addAttributesToSymbolTable(k.class_name(), env.varsymtab);

        KlassSymbol s = env.klassTable.get(k.class_name());
        KlassCode retcode = new KlassCode(s,
                            env.klassTable.get(env.parent.get(k.class_name())),
                            env.klassAttrTable.get(k.class_name()).values(),
                            env.klassMethodTable.get(k.class_name()).values(),
                            methodcodes);

        env.exitClass();
        return retcode;

    }

    public List<String> visitMethodSignature(MethodFeature m) {

        List<String> argTy = new ArrayList<String>();

        // System.out.println("Vising method signature: ");
        // System.out.println(m.attr_name());

        for(Formal f : m.formals()) {
            argTy.add(f.ty_name());
        }

        return argTy;

    }

    public void visitKlassMethodSignatures(Klass k) {

        curr_class_name = k.class_name();

        /*get method table and attribute table */
        Map<String, MethodSymbol> methods = env.klassMethodTable.get(k.class_name());
        Map<String, VarSymbol> attributes = env.klassAttrTable.get(k.class_name());

        for(Feature f : k.features()){

            if(f instanceof MethodFeature) {

                MethodFeature curr_method_feature = (MethodFeature) f;
                List<String> argTy = visitMethodSignature(curr_method_feature);

                env.addMethod(curr_class_name,
                    curr_method_feature.attr_name(),
                    argTy,
                    curr_method_feature.ty_name()
                    );

                MethodSymbol curr_method_sym = new MethodSymbol();
                curr_method_sym.argTy = argTy;
                curr_method_sym.defKlass = curr_class_name;
                curr_method_sym.type = curr_method_feature.ty_name();
                curr_method_sym.id = curr_method_feature.attr_name();

                methods.put(f.attr_name(), curr_method_sym);
            }

            // else {
            //     AttrFeature curr_attr_feature = (AttrFeature) f;
            //     env.addAttr(curr_class_name,
            //         curr_attr_feature.attr_name(),
            //         curr_attr_feature.ty_name());
            //
            //     attributes.put(f.attr_name(), new VarSymbol());
            // }

        }
        // env.addAttributesToSymbolTable(k.class_name(), env.varsymtab);
        env.addMethodsToSymbolTable(curr_class_name, env.methsymtab);
    }

    public MethodCode visitMethodFeature(MethodFeature m) {

        System.out.println("Visiting method feature");
        env.enterMethod();
        env.seq_no = 1;

        List<VarSymbol> formals = new ArrayList<VarSymbol>();

        MethodSymbol s = env.findMethod(m.attr_name());

        /* visit all formals */
        for(Formal f : m.formals()){
            AttrCode formal_expr = (AttrCode) visitFormal(f);
            VarSymbol formal_symbol = formal_expr.attribute();

            formal_expr.attribute().seq = env.seq_no;
            formals.add(formal_expr.attribute());

            env.seq_no += 1;
        }

        System.out.println("Visiting method body");
        // visit method body
        ExprCode expr = (ExprCode)visit(m.expr());

        //add return instruction
        expr.addInst(new ReturnInst(expr.dest));

        //collect local variables
        List<VarSymbol> locals = env.locals;

        MethodCode retcode = new MethodCode(s, expr, formals, locals);

        // exit scope
        env.exitMethod();
        return retcode;

    }



    /* <id> : <type> [ <- <expr> ]; */
    public AttrCode visitAttrFeature(AttrFeature a) {

        // VarSymbol self_var_sym = env.findVar("self");
        // VarSymbol tmp = env.freshLocal(object_expr.type_name());
        // tmp.not_void = true;

        ExprCode expr_code = (ExprCode)visit(a.expr());
        System.out.println("Attribute assign code size for " +
            a.attr_name() + ": " + expr_code.insts().size());

        VarSymbol s = env.findVar(a.attr_name());
        s.kind = VarSymbol.SymbolKind.attr;

        AttrCode retcode = new AttrCode(s, expr_code);

        return retcode;

    }

    // Add formals here
    public Code visitFormal(Formal f) {


        ExprCode expr_code = new ExprCode();

        env.addParam(curr_class_name, f.formal_name(),
            f.ty_name(), env.seq_no);

        VarSymbol s = env.findVar(f.formal_name());

        AttrCode attr = new AttrCode(s, expr_code);

        return attr;

    }


    public Code visitAssignExpr(AssignExpr assign_expr) {
        System.out.println("Visiting assignment");

        ExprCode expr_code = (ExprCode) visit(assign_expr.expr());

        // find variable
        VarSymbol variable = env.findVar(assign_expr.id());

        // temp L value
        Lvalue lvalue = new Lvalue(variable);

        if (lvalue.symbol.kind == VarSymbol.SymbolKind.attr ||
            expr_code.dest.symbol.kind == VarSymbol.SymbolKind.attr) {

            if (lvalue.symbol.kind == VarSymbol.SymbolKind.attr &&
                expr_code.dest.symbol.kind == VarSymbol.SymbolKind.attr) {

                System.out.println("Possibly a problem here");
                System.out.println("Loading attribute and storing in another");

                VarSymbol vs = env.findVar(expr_code.dest.symbol.id);
                Lvalue object = new Lvalue(vs);

                VarSymbol current_attribute = expr_code.dest.symbol;

                VarSymbol load_tmp = env.freshLocal(assign_expr.type_name());
                Lvalue load_lvalue = new Lvalue(load_tmp);

                // load_lvalue.symbol.id = current_attribute.id;
                Inst load_attr_inst = new LoadAttrInst(load_lvalue,
                    object, current_attribute);

                expr_code.addInst(load_attr_inst);


                VarSymbol lvalue_vs = env.findVar(lvalue.symbol.id);
                Rvalue curr_rval = new Rvalue(load_lvalue.symbol);
                Lvalue store_lvalue = new Lvalue(lvalue_vs);
                Inst store_attr_inst = new StoreAttrInst(store_lvalue,
                    curr_rval, lvalue_vs);

                expr_code.addInst(store_attr_inst);

            }

            else if (lvalue.symbol.kind == VarSymbol.SymbolKind.attr) {

                VarSymbol lvalue_vs = env.findVar(lvalue.symbol.id);
                Rvalue curr_rval = new Rvalue(expr_code.dest.symbol);

                Lvalue store_lvalue = new Lvalue(lvalue_vs);
                // store_lvalue.symbol.id = lvalue_vs.id;
                Inst store_attr_inst = new StoreAttrInst(store_lvalue,
                    curr_rval, lvalue_vs);

                expr_code.addInst(store_attr_inst);

            }

            else if (expr_code.dest.symbol.kind == VarSymbol.SymbolKind.attr) {

                VarSymbol vs = env.findVar(expr_code.dest.symbol.id);
                Lvalue object = new Lvalue(vs);

                VarSymbol current_attribute = expr_code.dest.symbol;

                VarSymbol load_tmp = env.freshLocal(assign_expr.type_name());
                Lvalue load_lvalue = new Lvalue(load_tmp);

                // load_lvalue.symbol.id = current_attribute.id;
                Inst load_attr_inst = new LoadAttrInst(load_lvalue,
                    object, current_attribute);

                expr_code.addInst(load_attr_inst);

                Rvalue load_rvalue = new Rvalue(load_tmp);

                // lvalue.symbol.id = load_rvalue.symbol.id;
                Inst move_instr = new MoveInst(lvalue, load_rvalue);


                expr_code.addInst(move_instr);

            }

        }

        else {
            // move

            // lvalue.symbol.id = expr_code.dest.symbol. ;
            Inst move_instr = new MoveInst(lvalue, expr_code.dest);

            expr_code.addInst(move_instr);

        }

        expr_code.dest = new Rvalue(lvalue.symbol);

        return expr_code;

    }

    public ExprCode visitStaticDispatchExpr(StaticDispatchExpr static_dispatch_expr) {

        System.out.println("Visiting static dispatch");

        System.out.println(static_dispatch_expr.mname());
        System.out.println(static_dispatch_expr.at());

        ExprCode expr_code = (ExprCode) visit(static_dispatch_expr.expr());

        Lvalue e0 = new Lvalue(expr_code.dest.symbol);

        List<Rvalue> args = new ArrayList<Rvalue>();

        // process actual parameters
        for(Expr actual: static_dispatch_expr.actuals()){

            ExprCode actual_code = (ExprCode) visit(actual);

            expr_code.insts.addAll(actual_code.insts);

            args.add(actual_code.dest);
        }

        // get the method
        MethodSymbol method = env.findMethod(static_dispatch_expr.mname(),
            static_dispatch_expr.at());

        VarSymbol tmp = env.freshLocal(static_dispatch_expr.type_name());
        Lvalue temp_lvalue = new Lvalue(tmp);


        // need new instruction to allocate object
        // based on type of at()
        // assign
        // call static dispatch using


        Inst curr_inst = new StaticDispatchInst(temp_lvalue,
            method, e0, args);

        expr_code.addInst(curr_inst);

        expr_code.dest = new Rvalue(tmp);

        return expr_code;
    }


    public Code visitDispatchExpr(DispatchExpr dispath_expr) {
        System.out.println("Visiting dispatch: " + dispath_expr.mname());
        // System.out.println("Visiting dispatch");

        ExprCode expr_code = (ExprCode) visit(dispath_expr.expr());

        // add instructions for abort() or runtime error
        // if (expr_code.dest.symbol.not_void == false) {
        //     System.out.print("Calling abort...");
        //
        //     MethodSymbol method = env.findMethod("abort");
        //     VarSymbol var_sym = env.findVar("self");
        //     Lvalue e0 = new Lvalue(var_sym);
        //     List<Rvalue> args = new ArrayList<Rvalue>();
        //
        //     VarSymbol tmp = env.freshLocal("Object");
        //     Lvalue temp_lvalue = new Lvalue(tmp);
        //
        //     Inst curr_inst = new DispatchInst(temp_lvalue, method, e0, args);
        //     expr_code.addInst(curr_inst);
        //
        //     return expr_code;
        // }

        Lvalue e0 = new Lvalue(expr_code.dest.symbol);

        List<Rvalue> args = new ArrayList<Rvalue>();

        // process actual parameters
        for(Expr actual: dispath_expr.actuals()){
            // System.out.println("Visiting virtual dispatch actuals");

            ExprCode actual_code = (ExprCode) visit(actual);
            // System.out.println("Recursion");

            expr_code.insts.addAll(actual_code.insts);

            args.add(actual_code.dest);
        }

        // get the method
        MethodSymbol method = env.findMethod(dispath_expr.mname());

        VarSymbol tmp = env.freshLocal(dispath_expr.type_name());
        Lvalue temp_lvalue = new Lvalue(tmp);



        Inst curr_inst = new DispatchInst(temp_lvalue, method, e0, args);
        expr_code.addInst(curr_inst);

        expr_code.dest = new Rvalue(tmp);

        return expr_code;
    }

    /* works */
    public ExprCode visitCondExpr(CondExpr cond_expr) {

        System.out.println("Visiting conditionals");

        // ExprCode visitCompExpr(CompExpr comp_expr)
        // cond_expr.cond();
        ExprCode cond_e = (ExprCode) visit(cond_expr.cond());

        System.out.println("Back from comp");

        ExprCode then_e = (ExprCode) visit(cond_expr.then());

        System.out.println("Back from then");

        ExprCode else_e = (ExprCode) visit(cond_expr.els());

        System.out.println("Back from else");

        System.out.println("Visiting conditional parts done");

        int elseLabel = env.newLabel();

        // make local var of what cond expr evaluates to
        VarSymbol tmp = env.freshLocal(cond_expr.type_name());

        // System.out.println("Type name of COND EXPR: " + cond_e.type_name());

        tmp.not_void = true;

        Lvalue tmp_Lval = new Lvalue(tmp);

        VarSymbol tmp_0 = env.freshLocal("Bool"); // should actually store boolean

        ExprCode expr_code = new ExprCode(cond_e);

        Inst move_0 = new MoveInst(new Lvalue(tmp_0), new Rvalue(false));
        expr_code.addInst(move_0);

        Inst if_inst = new CondBranchInst(Singletons.EQ, cond_e.dest,
            new Rvalue(tmp_0), elseLabel);
        expr_code.addInst(if_inst);

        expr_code.insts.addAll(then_e.insts);

        // then_e.dest.symbol.id = tmp_Lval.symbol.id;
        Inst mov1 = new MoveInst(tmp_Lval, then_e.dest);
        expr_code.addInst(mov1);

        int endLabel = env.newLabel();
        Inst gotoend_inst = new GotoInst(endLabel);
        expr_code.addInst(gotoend_inst);

        Inst else_label_inst = new LabelInst(elseLabel);
        expr_code.addInst(else_label_inst);
        expr_code.insts.addAll(else_e.insts);

        // else_e.dest.symbol.id = tmp_Lval.symbol.id;
        Inst mov2 = new MoveInst(tmp_Lval, else_e.dest);
        expr_code.addInst(mov2);

        Inst end_label_inst =  new LabelInst(endLabel);
        expr_code.addInst(end_label_inst);


        expr_code.dest = new Rvalue(tmp_Lval.symbol);

        return expr_code;

    }

    /* works */
    public ExprCode visitLoopExpr(LoopExpr loop_expr) {

        ExprCode cond_code = (ExprCode) visit(loop_expr.cond());
        ExprCode body_code = (ExprCode) visit(loop_expr.body());

        int condLabel = env.newLabel();
        int endLabel = env.newLabel();

        Inst cond_label_inst = new LabelInst(condLabel);
        Inst end_label_inst = new LabelInst(endLabel);

        VarSymbol tmp_0 = env.freshLocal("Int");
        Inst move_0 = new MoveInst(new Lvalue(tmp_0), new Rvalue(0));

        Inst while_inst = new CondBranchInst(Singletons.EQ, cond_code.dest,
            new Rvalue(tmp_0), endLabel);

        Inst gotostart_inst = new GotoInst(condLabel);

        ExprCode expr_code = new ExprCode();
        expr_code.addInst(move_0);
        expr_code.addInst(cond_label_inst);

        expr_code.insts.addAll(cond_code.insts);
        expr_code.addInst(while_inst);
        expr_code.insts.addAll(body_code.insts);

        expr_code.dest = body_code.dest;

        expr_code.addInst(gotostart_inst);
        expr_code.addInst(end_label_inst);


        return expr_code;

    }

    /* works */
    public ExprCode visitBlockExpr(BlockExpr block_expr) {

        ExprCode expr_code = new ExprCode();
        ExprCode new_code = new ExprCode();
        List<Expr> exprs = block_expr.exprs();

        for(Expr expr: exprs){
            new_code = (ExprCode) visit(expr);

            expr_code.insts.addAll(new_code.insts);

            expr_code.dest  = new_code.dest;
        }

        return expr_code;

    }


    public ExprCode visitLetExpr(LetExpr let_expr) {

        System.out.println("Let expressions visiting");

        env.enterLet();

        ExprCode init = (ExprCode) visit(let_expr.init());
        VarSymbol s = new VarSymbol();
        // s.not_void = true;

        s.id = let_expr.id();
        s.type = let_expr.ty();
        s.kind = s.kind.letvar;
        s.seq = env.seq_no;
        env.seq_no += 1;

        env.varsymtab.put(s.id, s);

        Lvalue let_lvalue = new Lvalue(s);

        // let_lvalue.symbol.id = init.dest.symbol.id;
        Inst move_inst = new MoveInst(let_lvalue, init.dest);

        init.addInst(move_inst);

        ExprCode body = (ExprCode) visit(let_expr.body());
        VarSymbol tmp = env.freshLocal(let_expr.body().type_name());
        // tmp.not_void = ;

        ExprCode expr_code = new ExprCode(init, body);
        expr_code.dest = new Rvalue(tmp);

        Lvalue res = new Lvalue(tmp);

        // body.dest.symbol.id = res.symbol.id;
        Inst move_inst2 = new MoveInst(res, new Rvalue(body.dest.symbol));

        expr_code.addInst(move_inst2);

        env.exitLet();

        return expr_code;

    }


    public ExprCode visitTypCaseExpr(TypCaseExpr typecase_expr) {

        ExprCode expr_code = (ExprCode) visit(typecase_expr.expr());

        Kase k = typecase_expr.kases().get(0);
        int height = 100; // some large number
        String match = "Object";
        //k.case_ty();

        for(Kase kase: typecase_expr.kases()){
            int newheight = env.lca(typecase_expr.type_name(),kase.case_ty(),0);

            if(newheight != -1 && newheight < height){
                match = kase.case_ty();
                height = newheight;
            }

            //match = env.lca(match, kase.case_ty());
        }

        for(Kase kase: typecase_expr.kases()){
            ExprCode new_code = (ExprCode) visitKase(kase);
            if(match == kase.case_ty()){
                expr_code.insts.addAll(new_code.insts);
                break;
            }
        }

        VarSymbol tmp = env.freshLocal(match);
        expr_code.dest = new Rvalue(tmp);

        return expr_code;

    }


    /*temp*/
    public ExprCode visitNewExpr(NewExpr new_expr) {
        System.out.println("New");
        new_visited = true;

        ExprCode expr_code = new ExprCode();

        VarSymbol tmp = env.freshLocal(new_expr.type_name());
        tmp.not_void = true;

        Lvalue new_lvalue = new Lvalue(tmp);

        KlassSymbol new_klass_symbol = new KlassSymbol();
        new_klass_symbol.id = new_expr.id();
        new_klass_symbol.base = env.parent.get(new_klass_symbol.id);

        Inst curr_inst = new AllocInst(new_lvalue, new_klass_symbol);
        expr_code.addInst(curr_inst);
        expr_code.dest = new Rvalue(tmp);

        return expr_code;

    }

    /*temp*/
    public Code visitIsVoidExpr(IsVoidExpr isvoid_expr) {

        ExprCode unary_expr = (ExprCode) visit(isvoid_expr.expr());

        VarSymbol tmp = env.freshLocal(isvoid_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr =  new UnopInst(Singletons.ISVOID,
            curr_lvalue, unary_expr.dest);

        ExprCode expr_code = new ExprCode(unary_expr);

        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;

    }

    /*temp*/
    public ExprCode visitPlusExpr(PlusExpr plus_expr) {

        ExprCode left_expr = (ExprCode) visit(plus_expr.left());
        ExprCode right_expr = (ExprCode) visit(plus_expr.right());

        VarSymbol tmp = env.freshLocal(plus_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_inst = new BinopInst(Singletons.PLUS, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_inst);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);
        return expr_code;
    }

    /*temp*/
    public ExprCode visitSubExpr(SubExpr subtract_expr) {

        ExprCode left_expr = (ExprCode) visit(subtract_expr.left());
        ExprCode right_expr = (ExprCode) visit(subtract_expr.right());

        VarSymbol tmp = env.freshLocal(subtract_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_inst = new BinopInst(Singletons.SUB, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_inst);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitMulExpr(MulExpr mult_expr) {

        ExprCode left_expr = (ExprCode) visit(mult_expr.left());
        ExprCode right_expr = (ExprCode) visit(mult_expr.right());

        VarSymbol tmp = env.freshLocal(mult_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_inst = new BinopInst(Singletons.MUL, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_inst);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }


    /*temp*/
    public ExprCode visitDivideExpr(DivideExpr div_expr) {

        ExprCode left_expr = (ExprCode) visit(div_expr.left());
        ExprCode right_expr = (ExprCode) visit(div_expr.right());

        VarSymbol tmp = env.freshLocal(div_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr = new BinopInst(Singletons.DIVIDE, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitNegExpr(NegExpr neg_expr){
        ExprCode expr = (ExprCode) visit(neg_expr.expr());

        VarSymbol tmp = env.freshLocal(neg_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr =  new UnopInst(Singletons.NEG, curr_lvalue,
            expr.dest);

        ExprCode expr_code = new ExprCode(expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitLtExpr(LtExpr lt_expr){

        ExprCode left_expr = (ExprCode) visit(lt_expr.left());
        ExprCode right_expr = (ExprCode) visit(lt_expr.right());

        VarSymbol tmp = env.freshLocal(lt_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr = new BinopInst(Singletons.LT, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/

    public ExprCode visitEqExpr(EqExpr eq_expr){

        System.out.println("Visiting eq instruction");

        ExprCode left_expr = (ExprCode) visit(eq_expr.left());
        ExprCode right_expr = (ExprCode) visit(eq_expr.right());

        VarSymbol tmp = env.freshLocal(eq_expr.type_name());
        tmp.not_void = true;

        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr = new BinopInst(Singletons.EQ, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitLeqExpr(LeqExpr leq_expr){

        ExprCode left_expr = (ExprCode) visit(leq_expr.left());
        ExprCode right_expr = (ExprCode) visit(leq_expr.right());


        VarSymbol tmp = env.freshLocal(leq_expr.type_name());
        tmp.not_void = true;

        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr = new BinopInst(Singletons.LEQ, curr_lvalue,
            left_expr.dest, right_expr.dest);

        ExprCode expr_code = new ExprCode(left_expr, right_expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitCompExpr(CompExpr comp_expr) {
        System.out.println("Visiting comp expression");

        ExprCode expr = (ExprCode) visit(comp_expr.expr());

        VarSymbol tmp = env.freshLocal(comp_expr.type_name());
        tmp.not_void = true;
        Lvalue curr_lvalue = new Lvalue(tmp);

        Inst curr_instr =  new UnopInst(Singletons.COMP, curr_lvalue,
            expr.dest);

        ExprCode expr_code = new ExprCode(expr);
        expr_code.addInst(curr_instr);
        expr_code.dest = new Rvalue(curr_lvalue.symbol);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitIntExpr(IntExpr int_expr){
        System.out.println("Int");

        ExprCode expr_code = new ExprCode();
        VarSymbol tmp = env.freshLocal(int_expr.type_name());
        tmp.not_void = true;

        Inst move_inst = new MoveInst(new Lvalue(tmp),
            new Rvalue(int_expr.value()));

        expr_code.addInst(move_inst);

        expr_code.dest = new Rvalue(tmp);


        return expr_code;

    }

    /*temp*/
    public ExprCode visitStringExpr(StringExpr string_expr) {
        System.out.println("Visiting String");

        ExprCode expr_code = new ExprCode();
        VarSymbol tmp = env.freshLocal(string_expr.type_name());
        tmp.not_void = true;

        Inst move_inst = new MoveInst(new Lvalue(tmp),
            new Rvalue(string_expr.value()));
        expr_code.addInst(move_inst);

        expr_code.dest = new Rvalue(tmp);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitBoolExpr(BoolExpr bool_expr) {

        ExprCode expr_code = new ExprCode();
        VarSymbol tmp = env.freshLocal(bool_expr.type_name());

        tmp.not_void = true;

        Inst move_inst = new MoveInst(new Lvalue(tmp),
            new Rvalue(bool_expr.value()));

        expr_code.addInst(move_inst);

        expr_code.dest = new Rvalue(tmp);

        return expr_code;
    }

    /*temp*/
    public ExprCode visitObjectExpr(ObjectExpr object_expr){
        System.out.println("Visiting Object: " + object_expr.id());

        ExprCode expr_code = new ExprCode();

        VarSymbol var_sym = env.findVar(object_expr.id());
        if (object_expr.id() == "self" ||
            var_sym.type == "Bool" ||
            var_sym.type == "String" ||
            var_sym.type == "Int" ) {
            var_sym.not_void = true;
        }

        VarSymbol tmp = env.freshLocal(object_expr.type_name());
        tmp.id = object_expr.id();
        tmp.not_void = var_sym.not_void;

        // System.out.println(tmp.type + " " + tmp.not_void);

        if (var_sym.kind != VarSymbol.SymbolKind.attr) {

            // tmp.id = var_sym.id;
            Inst move_inst = new MoveInst(new Lvalue(tmp),
                new Rvalue(var_sym)); // load?????


            expr_code.addInst(move_inst);
        }
        else {
            Lvalue object = new Lvalue(var_sym);
            Lvalue load_lvalue = new Lvalue(tmp);

            // load_lvalue.symbol.id = var_sym.id;
            Inst load_attr_inst = new LoadAttrInst(load_lvalue,
                object, var_sym);

            expr_code.addInst(load_attr_inst);
        }

        expr_code.dest = new Rvalue(tmp);

        return expr_code;
    }


    public ExprCode visitNoExprExpr(NoExprExpr noexpr_expr){

        return new ExprCode();

    }

    public ExprCode visitKase(Kase case_expr){

        ExprCode expr_code = (ExprCode) visit(case_expr.expr());

        //VarSymbol tmp = env.freshLocal(case_expr.case_ty());

        // Inst move_inst = new MoveInst(new Lvalue(tmp),
        //     expr_code.dest);

        // expr_code.addInst(move_inst);

        // expr_code.dest = new Rvalue(tmp);

        return expr_code;

    }


}
