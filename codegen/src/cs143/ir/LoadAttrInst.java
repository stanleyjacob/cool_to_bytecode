package cs143.ir;

import cs143.environment.VarSymbol;
import cs143.environment.Lvalue;

public class LoadAttrInst extends Inst {
    Lvalue dest;
    Lvalue receiver;
    VarSymbol attr;

    public LoadAttrInst(Lvalue l, Lvalue o, VarSymbol attr) {
        this.dest = l; this.receiver = o; this.attr = attr;
    }

    public Lvalue dest() { return dest; }

    public Lvalue receiver() { return receiver; }

    public VarSymbol attr() { return attr; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitLoadAttrInst(this);
    }
}
