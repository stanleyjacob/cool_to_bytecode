package cs143.ir;

import cs143.environment.Lvalue;
import cs143.environment.Rvalue;

public class BinopInst extends Inst {
    Lvalue dest;
    Rvalue left, right;
    String op;  // ADD / SUB / MUL / DIV


    public BinopInst(String op, Lvalue dest, Rvalue left, Rvalue right) {
        this.left = left;
        this.right = right;
        this.dest = dest;
        this.op = op;
    }

    public Lvalue dest() { return dest; }

    public Rvalue left() { return left; }

    public Rvalue right() { return right; }

    public String op() { return op; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitBinopInst(this);
    }
}
