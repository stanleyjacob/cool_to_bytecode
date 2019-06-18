package cs143.ir;

import cs143.environment.KlassSymbol;
import cs143.environment.Lvalue;

public class AllocInst extends Inst {
    KlassSymbol klass;
    Lvalue lval;

    public AllocInst(Lvalue l, KlassSymbol klass) {
        this.lval = l;
        this.klass = klass;
    }

    public Lvalue lval() { return lval; }

    public KlassSymbol klass() { return klass; }

    public <T> T accept(InstVisitor<? extends T> visitor) {
        return visitor.visitAllocInst(this);
    }
}
