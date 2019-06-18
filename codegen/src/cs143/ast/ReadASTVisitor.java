package cs143.ast;

import cs143.reader.*;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ReadASTVisitor extends ASTBaseVisitor<Ast> {

    int num(TerminalNode t) { return Integer.parseInt(t.getText().substring(1)); } // skip the '#'

    String symbol(TerminalNode t) { return t.getText().intern(); }
    /* visits all classes in program */
    @Override
    public Ast visitProgram(ASTParser.ProgramContext ctx) {
        List<Klass> klasses = new ArrayList<>();
        for (ASTParser.KlassContext k : ctx.klass()) {
            Klass c = (Klass) visitKlass(k);
            klasses.add(c);
        }
        return new Program(num(ctx.LINENO()), klasses);
    }

    /* visits all features in a class */
    @Override
    public Ast visitKlass(ASTParser.KlassContext ctx) {
        List<Feature> features = new ArrayList<>();
        for (ASTParser.FeatureContext f : ctx.feature()) {
            Feature fe = (Feature) visit(f); // visit the feature. Calls  accept --> visits the correct feature.  
            features.add(fe);
        }
        return new Klass(num(ctx.LINENO()), symbol(ctx.ID(0)), symbol(ctx.ID(1)), symbol(ctx.STR_CONST()), features);
    }

    @Override
    public Ast visitAttrFeature(ASTParser.AttrFeatureContext ctx) {
        Expr e = (Expr) visit(ctx.expr());
        return new AttrFeature(num(ctx.LINENO()), symbol(ctx.ID(0)), symbol(ctx.ID(1)), e);
    }

    @Override
    public Ast visitMethodFeature(ASTParser.MethodFeatureContext ctx) {
        List<Formal> formals = new ArrayList<>();
        for (ASTParser.FormalContext f : ctx.formal()) {
            Formal ff = (Formal) visitFormal(f);
            formals.add(ff);
        }
        Expr e = (Expr) visit(ctx.expr());
        return new MethodFeature(num(ctx.LINENO()), symbol(ctx.ID(0)), formals, symbol(ctx.ID(1)), e);
    }

    @Override
    public Ast visitFormal(ASTParser.FormalContext ctx) {
        return new Formal(num(ctx.LINENO()), symbol(ctx.ID(0)), symbol(ctx.ID(1)));
    }

    @Override
    public Ast visitAssignExpr(ASTParser.AssignExprContext ctx) {
        return new AssignExpr(num(ctx.LINENO()), symbol(ctx.ID()), (Expr) visit(ctx.expr()), semType(ctx.type()));
    }

    @Override
    public Ast visitStaticDispatchExpr(ASTParser.StaticDispatchExprContext ctx) {
        List<Expr> actuals = new ArrayList<>();
        for (ASTParser.ExprContext e  : ctx.actuals().expr()) {
            actuals.add( (Expr) visit(e) );
        }
        return new StaticDispatchExpr(num(ctx.LINENO()), (Expr) visit(ctx.expr()), symbol(ctx.ID(0)),
                    symbol(ctx.ID(1)), actuals, semType(ctx.type()));
    }

    @Override
    public Ast visitDispatchExpr(ASTParser.DispatchExprContext ctx) {
        List<Expr> actuals = new ArrayList<>();
        for (ASTParser.ExprContext e  : ctx.actuals().expr()) {
            actuals.add( (Expr) visit(e) );
        }
        return new DispatchExpr(num(ctx.LINENO()), (Expr) visit(ctx.expr()), symbol(ctx.ID()),
                actuals, semType(ctx.type()));
    }

    @Override
    public Ast visitCondExpr(ASTParser.CondExprContext ctx) {
        return new CondExpr(num(ctx.LINENO()), (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)),
                (Expr) visit(ctx.expr(2)), semType(ctx.type()));
    }

    @Override
    public Ast visitLoopExpr(ASTParser.LoopExprContext ctx) {
        return new LoopExpr(num(ctx.LINENO()), (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)),
                semType(ctx.type()));
    }

    @Override
    public Ast visitBlockExpr(ASTParser.BlockExprContext ctx) {
        List<Expr> exprs = new ArrayList<>();
        for (ASTParser.ExprContext e  : ctx.expr()) {
            exprs.add( (Expr) visit(e) );
        }
        return new BlockExpr(num(ctx.LINENO()), exprs, semType(ctx.type()));
    }

    @Override
    public Ast visitLetExpr(ASTParser.LetExprContext ctx) {
        return new LetExpr(num(ctx.LINENO()), symbol(ctx.ID(0)), symbol(ctx.ID(1)),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitTypCaseExpr(ASTParser.TypCaseExprContext ctx) {
        List<Kase> kases = new ArrayList<>();
        for (ASTParser.KaseContext kc : ctx.kase()) {
            kases.add( (Kase) visitKase(kc) );
        }
        return new TypCaseExpr(num(ctx.LINENO()), (Expr) visit(ctx.expr()), kases, semType(ctx.type()));
    }

    @Override
    public Ast visitKase(ASTParser.KaseContext ctx) {
        return new Kase(num(ctx.LINENO()), symbol(ctx.ID(0)), symbol(ctx.ID(1)),
                (Expr) visit(ctx.expr()));
    }

    @Override
    public Ast visitNewExpr(ASTParser.NewExprContext ctx) {
        return new NewExpr(num(ctx.LINENO()), symbol(ctx.ID()), semType(ctx.type()));
    }

    @Override
    public Ast visitIsVoidExpr(ASTParser.IsVoidExprContext ctx) {
        return new IsVoidExpr(num(ctx.LINENO()), ctx.ISVOID().getText().intern(),
                (Expr) visit(ctx.expr()), semType(ctx.type()));
    }

    @Override
    public Ast visitPlusExpr(ASTParser.PlusExprContext ctx) {
        return new PlusExpr(num(ctx.LINENO()), ctx.PLUS().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitSubExpr(ASTParser.SubExprContext ctx) {
        return new SubExpr(num(ctx.LINENO()), ctx.SUB().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }


    @Override
    public Ast visitMulExpr(ASTParser.MulExprContext ctx) {
        return new MulExpr(num(ctx.LINENO()), ctx.MUL().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }


    @Override
    public Ast visitDivideExpr(ASTParser.DivideExprContext ctx) {
        return new DivideExpr(num(ctx.LINENO()), ctx.DIVIDE().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitNegExpr(ASTParser.NegExprContext ctx) {
        return new NegExpr(num(ctx.LINENO()), ctx.NEG().getText().intern(),
                (Expr) visit(ctx.expr()), semType(ctx.type()));
    }

    @Override
    public Ast visitLtExpr(ASTParser.LtExprContext ctx) {
        return new LtExpr(num(ctx.LINENO()), ctx.LT().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitEqExpr(ASTParser.EqExprContext ctx) {
        return new EqExpr(num(ctx.LINENO()), ctx.EQ().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitLeqExpr(ASTParser.LeqExprContext ctx) {
        return new LeqExpr(num(ctx.LINENO()), ctx.LEQ().getText().intern(),
                (Expr) visit(ctx.expr(0)), (Expr) visit(ctx.expr(1)), semType(ctx.type()));
    }

    @Override
    public Ast visitCompExpr(ASTParser.CompExprContext ctx) {
        return new CompExpr(num(ctx.LINENO()), ctx.COMP().getText().intern(),
                (Expr) visit(ctx.expr()), semType(ctx.type()));
    }

    @Override
    public Ast visitIntExpr(ASTParser.IntExprContext ctx) {
        return new IntExpr(num(ctx.LINENO()), Integer.parseInt(ctx.INT_CONST().getText()), semType(ctx.type()));
    }

    @Override
    public Ast visitBoolExpr(ASTParser.BoolExprContext ctx) {
        return new BoolExpr(num(ctx.LINENO()), Integer.parseInt(ctx.INT_CONST().getText()), semType(ctx.type()));
    }

    @Override
    public Ast visitStrExpr(ASTParser.StrExprContext ctx) {
        return new StringExpr(num(ctx.LINENO()), ctx.STR_CONST().getText(), semType(ctx.type()));
    }

    @Override
    public Ast visitObjectExpr(ASTParser.ObjectExprContext ctx) {
        return new ObjectExpr(num(ctx.LINENO()), symbol(ctx.ID()), semType(ctx.type()));
    }

    @Override
    public Ast visitNoExprExpr(ASTParser.NoExprExprContext ctx) {
        return new NoExprExpr(num(ctx.LINENO()), semType(ctx.type()));
    }

    @Override
    public Ast visitThrowExpr(ASTParser.ThrowExprContext ctx) {
        throw new Error("Throw not implemented");
    }

    @Override
    public Ast visitTryCatchExpr(ASTParser.TryCatchExprContext ctx) {
        throw new Error("TryCatch not implemented");
    }

    @Override
    public Ast visitTryFinallyExpr(ASTParser.TryFinallyExprContext ctx) {
        throw new Error("TryFinally not implemented");
    }

    // visitType would return an Ast here, but don't need that!
    public String semType(ASTParser.TypeContext ctx) {
        if (ctx instanceof ASTParser.TypeTypeContext)
            return ((ASTParser.TypeTypeContext) ctx).ID().getText().intern();
        else if (ctx instanceof ASTParser.TypeNoTypeContext)
            return ((ASTParser.TypeNoTypeContext) ctx).NO_TYPE().getText().intern();
        else if (ctx instanceof ASTParser.TypeBottomContext)
            return ((ASTParser.TypeBottomContext) ctx).BOTTOM().getText().intern();
        throw new Error("Case not matched in semType");
    }
}
