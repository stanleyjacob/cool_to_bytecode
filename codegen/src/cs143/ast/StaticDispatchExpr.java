package cs143.ast;

import java.io.PrintStream;
import java.util.List;

public class StaticDispatchExpr extends Expr {

    Expr expr;
    String at;
    String mname;
    List<Expr> actuals;

    public StaticDispatchExpr(int line_num, Expr e, String at, String mname, List<Expr> actuals, String type_name) {
        super(line_num, type_name);
        this.expr = e;
        this.at = at;
        this.mname = mname;
        this.actuals = actuals;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_static_dispatch" );
        expr.dump(ps, pad + 2);
        ps.println(padding(pad+2) +  at );
        ps.println(padding(pad + 2) + mname);
        ps.println(padding(pad + 2) + "(");
        for (Expr a : actuals)
            a.dump(ps, pad+2);
        ps.println(padding(pad + 2) + ")");
        super.dumpType(ps, pad);
    }

    public Expr expr() { return expr; }
    public String at() { return at; }
    public String mname() { return mname; }
    public List<Expr> actuals() { return actuals; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitStaticDispatchExpr(this);
    }
}
