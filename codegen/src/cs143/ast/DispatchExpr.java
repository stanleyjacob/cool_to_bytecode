package cs143.ast;

import java.io.PrintStream;
import java.util.List;

public class DispatchExpr extends Expr {
    Expr expr;
    String mname;
    List<Expr> actuals;

    public DispatchExpr(int line_num, Expr e, String mname,
        List<Expr> actuals, String type_name) {
        super(line_num, type_name);
        this.expr = e;
        this.mname = mname;
        this.actuals = actuals;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_dispatch" );
        expr.dump(ps, pad + 2);
        ps.println(padding(pad+2) + mname);
        ps.println(padding(pad+2) + "(");
        for (Expr a : actuals)
            a.dump(ps, pad+2);
        ps.println(padding(pad+2) + ")");
        super.dumpType(ps, pad);
    }

    public Expr expr() { return expr; }

    public String mname() { return mname; }

    public List<Expr> actuals() { return actuals; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitDispatchExpr(this);
    }
}
