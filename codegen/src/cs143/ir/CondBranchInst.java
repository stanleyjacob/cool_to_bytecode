package cs143.ir;

import cs143.environment.Rvalue;

public class CondBranchInst extends Inst {
    String op;  // LT, EQ, LEQ
    Rvalue left, right;
    int label;

    public CondBranchInst(String op, Rvalue left, Rvalue right, int label) {
        this.op = op; this.left = left; this.right = right; this.label = label;
    }

    public String op() { return op; }
    public Rvalue left() { return left; }
    public Rvalue right() { return right; }

    public int label() { return label; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitCondBranchInst(this);
    }
}
