package cs143.ir;

import cs143.environment.Lvalue;
import cs143.environment.MethodSymbol;
import cs143.environment.Rvalue;

import java.util.List;

public class DispatchInst extends Inst {
    Lvalue e0;
    List<Rvalue> args;
    MethodSymbol method;
    Lvalue tmp;

    public DispatchInst(Lvalue tmp, MethodSymbol method,
        Lvalue e0, List<Rvalue> args) {
        this.tmp = tmp;
        this.method = method;
        this.e0 = e0;
        this.args = args;
    }

    // This should boil down to invokevirtual in JVM

    public Lvalue tmp() { return tmp; }

    public MethodSymbol method() { return method; }

    public Lvalue e0() { return e0; }

    public List<Rvalue> args() { return args; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitDispatchInst(this);
    }
}
