package cs143.ast;

import java.io.PrintStream;
import java.util.List;

public class TypCaseExpr extends Expr {
    Expr expr;
    List<Kase> kases;

    public TypCaseExpr(int line_num, Expr e, List<Kase> kases, String type_name) {
        super(line_num, type_name);
        this.expr = e;
        this.kases = kases;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_typcase");
        expr.dump(ps, pad+2);
        for (Kase k : kases) {
            k.dump(ps, pad+2);
        }
        super.dumpType(ps, pad);
    }

    public Expr expr() { return expr; }
    public List<Kase> kases() { return kases; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitTypCaseExpr(this);
    }
}
