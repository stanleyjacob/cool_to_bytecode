package cs143.ir;

import cs143.environment.Lvalue;
import cs143.environment.Rvalue;

public class UnopInst extends Inst {
    String op; // COMP
    Lvalue left;
    Rvalue right;

    public UnopInst(String op, Lvalue left, Rvalue right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public Lvalue left() { return left; }

    public Rvalue right() { return right; }

    public String op() { return op; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitUnopInst(this);
    }
}
