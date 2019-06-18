package cs143.ir;

// The purpose of this instruction is to mark
// the end of a tmp's use, so it can be popped
// from stack.  This can be actually computed
// by examining the instruction sequence.

// Consider v = (w = expr)
// at (w = expr) we want to leave the temp carrying
// expr on the stack, to mov to v.  But we don't know
// if there is a further use of tmp or not.

import cs143.environment.Rvalue;

public class DiscardInst extends Inst {

    Rvalue rvalue;

    public DiscardInst(Rvalue rvalue) {
        this.rvalue = rvalue;
    }

    public Rvalue rvalue() { return rvalue; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitDiscardInst(this);
    }
}
