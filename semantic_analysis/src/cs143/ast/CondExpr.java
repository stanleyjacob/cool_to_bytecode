package cs143.ast;

import java.io.PrintStream;

public class CondExpr extends Expr {

    Expr cond, then, els;
    public CondExpr(int line_num, Expr e0, Expr e1, Expr e2, String type_name) {
        super(line_num, type_name);
        this.cond = e0;
        this.then = e1;
        this.els = e2;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_cond");
        cond.dump(ps, pad+2);
        then.dump(ps, pad+2);
        els.dump(ps, pad+2);
        super.dumpType(ps, pad);
    }

    public Expr cond() { return cond; }

    public Expr then() { return then; }

    public Expr els() { return els; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitCondExpr(this);
    }
}
