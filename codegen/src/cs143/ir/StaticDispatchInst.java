package cs143.ir;

import cs143.environment.Lvalue;
import cs143.environment.MethodSymbol;
import cs143.environment.Rvalue;

import java.util.List;

public class StaticDispatchInst extends Inst {
    Lvalue e0;
    List<Rvalue> args;
    MethodSymbol method;
    Lvalue tmp;
    // String type;

    public StaticDispatchInst(Lvalue tmp, MethodSymbol method, Lvalue e0, List<Rvalue> args) {
        this.tmp = tmp;
        this.method = method;
        this.e0 = e0;
        this.args = args;
    }

    public Lvalue tmp() { return tmp; }

    public MethodSymbol method() { return method; }

    public Lvalue e0() { return e0; }

    public List<Rvalue> args() { return args; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitStaticDispatchInst(this);
    }
}
