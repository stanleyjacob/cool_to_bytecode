package cs143.ir;

import cs143.environment.Rvalue;

public class ReturnInst extends Inst {
    Rvalue rvalue;

    public ReturnInst(Rvalue rvalue) {
        this.rvalue = rvalue;
    }

    public Rvalue rvalue() { return rvalue; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitReturnInst(this);
    }
}
