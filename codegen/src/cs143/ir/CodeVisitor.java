package cs143.ir;

public abstract class CodeVisitor<T> {

    final public T visit(Code a) { return a.accept(this); }

    abstract public T visitProgramCode(ProgramCode p);
    abstract public T visitKlassCode(KlassCode p);
    abstract public T visitMethodCode(MethodCode p);
    abstract public T visitAttrCode(AttrCode p);
    abstract public T visitExprCode(ExprCode p);
}
