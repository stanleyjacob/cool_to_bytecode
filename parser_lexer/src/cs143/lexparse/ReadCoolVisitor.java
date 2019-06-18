package cs143.lexparse;

import cs143.ast.*;
// import cs143.ast.Feature;
// import cs143.ast.Klass;
// import cs143.ast.Program;

import java.util.ArrayList;
import java.util.List;

public class ReadCoolVisitor extends CoolBaseVisitor<Ast> {

    String fname;
    boolean debug_mode = false;

    public ReadCoolVisitor(String fname) {
        String[] arrStr = fname.split("/");
        this.fname = arrStr[arrStr.length-1];
    }

    @Override
    public Ast visitProgram( CoolParser.ProgramContext ctx ) {
        if (debug_mode) {
            System.out.println("Visit program");
        }
        // klass SEMI program

        List<Klass> klasses = new ArrayList<>();

        for (CoolParser.KlassContext k : ctx.klass()) {
            Klass c = (Klass) visitKlass(k);
            klasses.add(c);
        }

        return new Program(ctx.getStart().getLine(), klasses);
    }

    @Override
    public Ast visitKlass( CoolParser.KlassContext ctx) {
        if (debug_mode) {
            System.out.println("Visit klass");
        }

        // CLASS ID (INHERITS ID)? LBRACE (feature SEMI )* RBRACE

        String name = ctx.TYPE(0).getText();

        String base = "Object";

        if (ctx.TYPE().size() == 2) { // because it was optional
            base = ctx.TYPE(1).getText();
        }

        List<Feature> features = new ArrayList<>();
        for (CoolParser.FeatureContext f : ctx.feature()) {
            // TODO
            if (f instanceof CoolParser.MethodContext) {
                features.add((Feature) visitMethod((CoolParser.MethodContext) f));
            }
            if (f instanceof CoolParser.AttrContext) {
                features.add((Feature) visitAttr((CoolParser.AttrContext) f));
            }
        }

        return new Klass(ctx.getStart().getLine(), name, base, fname, features);
    }

    @Override
    public Ast visitMethod( CoolParser.MethodContext ctx) {

        if (debug_mode) {
            System.out.println("Visit method: " + ctx.ID().getText());
        }

        // ID LPAREN (formal (COMMA formal)*)? RPAREN COLON ID LBRACE expr RBRACE
        String name = ctx.ID().getText();

        // by default, type of method is 4
        String ty_name = ctx.TYPE().getText();

        // if there are formals, add to list
        // keep track of index to set ty_name
        List<Formal> formals_lst = new ArrayList<>();
        for (CoolParser.FormalContext x : ctx.formal()) {
            int line_num = x.getStart().getLine();

            String formal_name = x.ID().getText();
            String formal_ty_name = x.TYPE().getText();

            Formal curr_formal = new Formal(line_num, formal_name, formal_ty_name);

            // Formal curr_formal = (Formal) visitFormal(ctx.formal(i));
            formals_lst.add(curr_formal);
        }

        // visit expression context
        Expr e = null;
        if (ctx.expr() != null) {
            e = (Expr) visit(ctx.expr());
        }

        return new MethodFeature(ctx.getStart().getLine(), name, formals_lst, ty_name, e);
    }

    @Override
    public Ast visitAttr(CoolParser.AttrContext ctx) {

        if (debug_mode) {
            System.out.println("Visit attribute");
        }

        // ID COLON ID (ASSIGN expr)? # attr
        String attr_name = ctx.ID().getText();
        String ty_name = ctx.TYPE().getText();

        int line_num = ctx.getStart().getLine();
        Expr expr = new NoExprExpr(0, "_no_type"); // line_num?
        if (ctx.expr() != null) {
            expr = (Expr) visit(ctx.expr());
        }

        if (debug_mode) {
            System.out.println("Done visiting attribute");
        }
        return new AttrFeature(ctx.getStart().getLine(), attr_name, ty_name, expr);
    }

    @Override
    public Ast visitDiv(CoolParser.DivContext ctx) {

        if (debug_mode) {
            System.out.println("Visit div");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_divide";

        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new DivideExpr(line_num, op, e1, e2, type_name);
    }

    @Override
    public Ast visitAdd(CoolParser.AddContext ctx) {

        if (debug_mode) {
            System.out.println("Visit add");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_plus";

        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new PlusExpr(line_num, op, e1, e2, type_name);
    }

    @Override
    public Ast visitMinus(CoolParser.MinusContext ctx) {

        if (debug_mode) {
            System.out.println("Visit minus");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_sub";

        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new SubExpr(line_num, op, e1, e2, type_name);
    }

    @Override
    public Ast visitMul(CoolParser.MulContext ctx) {

        if (debug_mode) {
            System.out.println("Visit mul");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_mul";

        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new MulExpr(line_num, op, e1, e2, type_name);
    }

    // Also known as "visitComp"
    @Override
    public Ast visitNot(CoolParser.NotContext ctx) {

        if (debug_mode) {
            System.out.println("Visit not");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_comp";
        Expr e = (Expr) visit(ctx.expr());
        String type_name = "_no_type";
        return new CompExpr(line_num, op, e, type_name);
    }

    @Override
    public Ast visitNeg(CoolParser.NegContext ctx) {

        if (debug_mode) {
            System.out.println("Visit neg");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_neg";
        Expr e = (Expr) visit(ctx.expr());
        String type_name = "_no_type";
        return new NegExpr(line_num, op, e, type_name);
    }


    @Override
    public Ast visitIsvoid(CoolParser.IsvoidContext ctx) {

        if (debug_mode) {
            System.out.println("Visit isvoid");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_isvoid";
        Expr e = (Expr) visit(ctx.expr());
        String type_name = "_no_type";
        return new IsVoidExpr(line_num, op, e, type_name);
    }


    @Override
    public Ast visitCase(CoolParser.CaseContext ctx) {

        if (debug_mode) {
            System.out.println("Visit case");
        }

        int line_num = ctx.getStart().getLine();
        Expr e = (Expr) visit(ctx.expr(0));
        String type_name = "_no_type";

        List<Kase> kases = new ArrayList<>();
        for (int i = 1; i < ctx.expr().size(); ++i) {
            CoolParser.ExprContext x = ctx.expr().get(i);

            String id = ctx.ID(i - 1).getText();
            String case_ty = ctx.TYPE(i - 1).getText();
            if (debug_mode) {
                System.out.println("Case type: " + case_ty);
            }

            Expr curr_case_e = (Expr) visit(x);

            Kase newKase = new Kase(line_num, id, case_ty, curr_case_e);

            kases.add(newKase);
        }

        if (debug_mode) {
            System.out.println("End of case");
        }
        return new TypCaseExpr(line_num, e, kases, type_name);
    }


    // Is it unary?
    @Override
    public Ast visitParen(CoolParser.ParenContext ctx) {

        if (debug_mode) {
            System.out.println("Visit paren");
        }

        Expr e = (Expr) visit(ctx.expr());

        return e;
    }



    @Override
    public Ast visitNew(CoolParser.NewContext ctx) {

        if (debug_mode) {
            System.out.println("Visit new: " + ctx.TYPE().getText());
        }

        int line_num = ctx.getStart().getLine();
        String id = ctx.TYPE().getText();
        String type_name = "_no_type";
        return new NewExpr(line_num, id, type_name);
    }


    @Override
    public Ast visitSelfdispatch(CoolParser.SelfdispatchContext ctx) {

        if (debug_mode) {
            System.out.println("Visit self dispatch");
        }

        int line_num = ctx.getStart().getLine();
        Expr e = new ObjectExpr(line_num, "self", "_no_type"); // set for self type?
        String mname = ctx.ID().getText();

        List<Expr> actuals = new ArrayList<>();
        for (CoolParser.ExprContext x : ctx.expr()) {
            Expr curr_expr = (Expr) visit(x);
            actuals.add(curr_expr);
        }

        String type_name = "_no_type";

        return new DispatchExpr(line_num, e, mname, actuals, type_name);

    }

    @Override
    public Ast visitDispatch(CoolParser.DispatchContext ctx) {

        if (debug_mode) {
            System.out.println("Visit dispatch: " + ctx.ID().getText());
        }

        int line_num = ctx.getStart().getLine();
        Expr e = (Expr) visit(ctx.expr(0));
        String mname = ctx.ID().getText();

        List<Expr> actuals = new ArrayList<>();

        List<CoolParser.ExprContext> grabbedContext = ctx.expr();
        for (int i = 1; i < grabbedContext.size(); ++i) {
            CoolParser.ExprContext x = grabbedContext.get(i);
            Expr curr_expr = (Expr) visit(x);
            actuals.add(curr_expr);
        }

        String type_name = "_no_type";

        if (ctx.AT() != null) {
            String at = ctx.TYPE().getText();
            return new StaticDispatchExpr(line_num, e, at, mname, actuals, type_name);
        }

        return new DispatchExpr(line_num, e, mname, actuals, type_name);
    }

    @Override
    public Ast visitLessThan(CoolParser.LessThanContext ctx) {

        if (debug_mode) {
            System.out.println("Visit less than");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_lt";
        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new LtExpr(line_num, op, e1, e2, type_name);
    }

    @Override
    public Ast visitLessThanOrEqualTo(CoolParser.LessThanOrEqualToContext ctx) {

        if (debug_mode) {
            System.out.println("Visit less than or equal to");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_leq";
        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new LeqExpr(line_num, op, e1, e2, type_name);
    }

    @Override
    public Ast visitEq(CoolParser.EqContext ctx) {

        if (debug_mode) {
            System.out.println("Visit eq");
        }

        int line_num = ctx.getStart().getLine();
        String op = "_eq";
        Expr e1 = (Expr) visit(ctx.expr(0));
        Expr e2 = (Expr) visit(ctx.expr(1));
        String type_name = "_no_type";

        return new EqExpr(line_num, op, e1, e2, type_name);
    }


    @Override
    public Ast visitBlock(CoolParser.BlockContext ctx) {

      if (debug_mode) {
          System.out.println("Visit block");
      }

        int line_num = ctx.getStart().getLine();
        List<Expr> exprs = new ArrayList<>();
        String type_name = "_no_type";

        List<CoolParser.ExprContext> curr_contexts = ctx.expr();
        for (CoolParser.ExprContext x : curr_contexts) {
            Expr curr_expr = (Expr) visit(x);
            exprs.add(curr_expr);
        }

        return new BlockExpr(line_num, exprs, type_name);
    }

    @Override
    public Ast visitInt_const(CoolParser.Int_constContext ctx) {
      if (debug_mode) {
          System.out.println("Visit int");
      }

        int line_num = ctx.getStart().getLine();
        int value = Integer.valueOf(ctx.INT_CONST().getText());
        String type_name = "_no_type";

        return new IntExpr(line_num, value, type_name);
    }


    @Override
    public Ast visitStr_const(CoolParser.Str_constContext ctx) {

        int line_num = 0;
        String value = null;
        String type_name = null;
        try {
            if (debug_mode) {
                System.out.println("Visit str const");
            }
            line_num = ctx.getStart().getLine();
            value = ctx.STR_CONST().getText();

            if (value == null) {
                throw new CoolException("Bad string syntax. EOF detected.");
            }

            if (value.length() > 1024) {
                throw new CoolException("Bad string syntax. Too many characters detected.");
            }

            char prev_char = '\0';
            boolean back_slash = false;
            String new_str = new String();
            for (int i = 0; i < value.length(); i++) {
                char c = value.charAt(i);
                if (c == Character.MIN_VALUE) {
                    throw new CoolException("Bad string syntax. Null char detected.");
                }
                if (c == '\n' && prev_char != '\\') {
                    throw new CoolException("Bad string syntax. Unterminated string constant detected.");
                }
                if (c == '\"' && prev_char != '\\' && i != 0 && i != (value.length() - 1)) {
                    throw new CoolException("Bad string syntax.2");
                }

                if (back_slash) {

                    if (c == 'b' || c == 't' || c == 'n' || c == 'f' ||
                        !(Character.isLetter(c) || Character.isDigit(c))) {
                        if (c == '\\' || c == '\"' || (Character.isLetter(c) || Character.isDigit(c))) {
                            new_str += '\\';
                        }
                        else {
                        }
                    }

                    new_str += c;
                    back_slash = false;
                }
                else {
                    if (c == '\\') {
                        back_slash = true;
                    }
                    else {
                        new_str += c;
                    }
                }

                prev_char = c;

            }
            value = new_str;

            type_name = "_no_type";
        }
        catch (CoolException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return new StringExpr(line_num, value, type_name);
    }


    @Override
    public Ast visitBool_true(CoolParser.Bool_trueContext ctx) {
        if (debug_mode) {
            System.out.println("Visit bool true");
        }
        int line_num = ctx.getStart().getLine();
        return new BoolExpr(line_num, 1, "_no_type");
    }


    @Override
    public Ast visitBool_false(CoolParser.Bool_falseContext ctx) {
        if (debug_mode) {
            System.out.println("Visit bool false");
        }

        int line_num = ctx.getStart().getLine();
        return new BoolExpr(line_num, 0, "_no_type");
    }


    @Override
    public Ast visitId(CoolParser.IdContext ctx) {

        int line_num = 0;
        String id = null;
        String type_name = null;

        try {
            if (debug_mode) {
                System.out.println("Visit id");
            }

            if (ctx.ID() == null) {
                throw new CoolException("Bad id syntax");
            }

            line_num = ctx.getStart().getLine();
            id = ctx.ID().getText();
            type_name = "_no_type";
        }
        catch (CoolException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return new ObjectExpr(line_num, id, type_name);
    }


    @Override
    public Ast visitIf(CoolParser.IfContext ctx) {

        int line_num = 0;
        Expr e0 = null;
        Expr e1 = null;
        Expr e2 = null;
        String type_name = null;

        try {
            if (debug_mode) {
                System.out.println("Visit if");
            }

            if (ctx.IF() == null ||
                ctx.ELSE() == null ||
                ctx.FI() == null ||
                ctx.THEN() == null ||
                ctx.expr(0) == null ||
                ctx.expr(1) == null ||
                ctx.expr(2) == null) {
                throw new CoolException("Bad let syntax");
            }

            // IF expr THEN expr ELSE expr FI
            line_num = ctx.getStart().getLine();

            e0 = (Expr) visit(ctx.expr(0));
            e1 = (Expr) visit(ctx.expr(1));
            e2 = (Expr) visit(ctx.expr(2));

            type_name = "_no_type";
        }
        catch (CoolException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return new CondExpr(line_num, e0, e1, e2, type_name);
    }


    public LetExpr visitLetHelper(CoolParser.LetContext ctx, int recurse_count) {

        if (debug_mode) {
            System.out.println("Visit let formal");
        }

        int line_num = ctx.getStart().getLine();
        String id = ctx.let_formal(recurse_count).ID().getText();
        String ty = ctx.let_formal(recurse_count).TYPE().getText();
        Expr e0 = new NoExprExpr(0, "_no_type");
        String type_name = "_no_type";

        if (ctx.let_formal(recurse_count).expr() != null) {
            e0 = (Expr) visit(ctx.let_formal(recurse_count).expr());
        }

        if (recurse_count == ctx.let_formal().size() - 1) {

            Expr body = (Expr) visit(ctx.expr());
            return new LetExpr(line_num, id, ty, e0, body, type_name);
        }

        return new LetExpr(line_num, id, ty, e0, visitLetHelper(ctx, recurse_count + 1), type_name);

    }


    @Override
    public Ast visitLet(CoolParser.LetContext ctx) {

        try {
            // LET ID COLON TYPE (ASSIGN expr)? (IN expr)? # let
            if (debug_mode) {
                System.out.println("Visit let");
            }

            if (ctx.LET() == null || ctx.IN() == null) {
                throw new CoolException("Bad let syntax");
            }

            return visitLetHelper(ctx, 0);
        }
        catch (CoolException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return null;
    }


    @Override
    public Ast visitWhile(CoolParser.WhileContext ctx) {

        int line_num = 0;
        Expr cond = null;
        Expr body = null;
        String type_name = null;

        try {
            if (debug_mode) {
                System.out.println("Visit while");
            }

            if (ctx.WHILE() == null ||
                ctx.LOOP() == null ||
                ctx.POOL() == null) {
                throw new CoolException("Bad while syntax");
            }

            // IF expr THEN expr ELSE expr FI
            line_num = ctx.getStart().getLine();

            cond = (Expr) visit(ctx.expr(0));
            body = (Expr) visit(ctx.expr(1));

            type_name = "_no_type";
        }
        catch (CoolException e) {
            System.out.println(e);
            System.exit(-1);
        }

        return new LoopExpr(line_num, cond, body, type_name);
    }


    @Override
    public Ast visitAssign(CoolParser.AssignContext ctx) {

        int line_num = 0;
        String id = null;
        Expr e = null;
        String type_name = null;

        try {
            if (debug_mode) {
                System.out.println("Visit assign");
            }

            if (ctx.ASSIGN() == null || ctx.ID() == null) {
                throw new CoolException("Bad assign syntax");
            }

            // ID <- expr
            line_num = ctx.getStart().getLine();
            id = ctx.ID().getText();

            e = (Expr) visit(ctx.expr());

            if (e != null) {
                type_name = e.type_name();
            }
            else {
                type_name = "_no_type";
            }

        }
        catch (CoolException expt) {
            System.out.println(expt);
            System.exit(-1);
        }

        return new AssignExpr(line_num, id, e, type_name);
    }


}
