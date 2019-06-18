package cs143.ast;

public abstract class AstVisitor<T> {

    final public T visit(Ast a) {
        return a.accept(this);
    }

    abstract public T visitProgram(Program p);
    abstract public T visitKlass(Klass k);
    abstract public T visitMethodFeature(MethodFeature m);
    abstract public T visitAttrFeature(AttrFeature a);
    abstract public T visitFormal(Formal f);
    abstract public T visitAssignExpr(AssignExpr a);
    abstract public T visitStaticDispatchExpr(StaticDispatchExpr a);
    abstract public T visitDispatchExpr(DispatchExpr d);
    abstract public T visitCondExpr(CondExpr c);
    abstract public T visitLoopExpr(LoopExpr l);
    abstract public T visitBlockExpr(BlockExpr b);
    abstract public T visitLetExpr(LetExpr l);
    abstract public T visitTypCaseExpr(TypCaseExpr t);
    abstract public T visitNewExpr(NewExpr n);
    abstract public T visitIsVoidExpr(IsVoidExpr i);
    abstract public T visitPlusExpr(PlusExpr p);
    abstract public T visitSubExpr(SubExpr s);
    abstract public T visitMulExpr(MulExpr m);
    abstract public T visitDivideExpr(DivideExpr d);
    abstract public T visitNegExpr(NegExpr n);
    abstract public T visitLtExpr(LtExpr l);
    abstract public T visitEqExpr(EqExpr e);
    abstract public T visitLeqExpr(LeqExpr l);
    abstract public T visitCompExpr(CompExpr c);
    abstract public T visitIntExpr(IntExpr i);
    abstract public T visitStringExpr(StringExpr s);
    abstract public T visitBoolExpr(BoolExpr b);
    abstract public T visitObjectExpr(ObjectExpr o);
    abstract public T visitNoExprExpr(NoExprExpr n);
    abstract public T visitKase(Kase k);
}
