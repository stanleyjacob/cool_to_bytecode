package cs143.ir;

import cs143.environment.MethodSymbol;
import cs143.environment.VarSymbol;

import java.util.List;

public class MethodCode extends Code {

    MethodSymbol method;

    ExprCode expr;

    List<VarSymbol> formals; // params

    List<VarSymbol> locals; // vars/tmps

    public int num_locals;

    public MethodCode(MethodSymbol method, ExprCode expr, List<VarSymbol> formals, List<VarSymbol> locals) {
        this.method = method;
        this.expr = expr;
        this.formals = formals;
        this.locals = locals;
        this.num_locals = 1;
    }

    public <T> T accept(CodeVisitor<? extends T> visitor) {
        return visitor.visitMethodCode(this);
    }

    public MethodSymbol method() { return method; }

    public ExprCode expr() { return expr; }

    public List<VarSymbol> formals() { return formals; }

    public List<VarSymbol> locals() { return locals; }

}
