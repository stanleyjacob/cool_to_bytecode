package cs143.ir;

import cs143.environment.Lvalue;
import cs143.environment.Rvalue;

public class MoveInst extends Inst {
    Lvalue dest;
    Rvalue src;

    public MoveInst(Lvalue dest, Rvalue src) {
        this.dest = dest;
        this.src = src;
    }

    public Rvalue src() { return src; }

    public Lvalue dest() { return dest; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitMoveInst(this);
    }
}
