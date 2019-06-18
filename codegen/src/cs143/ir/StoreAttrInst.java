package cs143.ir;

import cs143.environment.VarSymbol;
import cs143.environment.Lvalue;
import cs143.environment.Rvalue;

public class StoreAttrInst extends Inst {
    Lvalue receiver;
    VarSymbol attr;
    Rvalue value;

    public StoreAttrInst(Lvalue recv, Rvalue rval, VarSymbol attr) {
        this.receiver = recv; this.value = rval; this.attr = attr;
    }

    public Lvalue receiver() { return receiver; }

    public VarSymbol attr() { return attr; }

    public Rvalue value() { return value; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitStoreAttrInst(this);
    }
}
