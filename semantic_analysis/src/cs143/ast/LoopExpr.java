package cs143.ast;

import java.io.PrintStream;

public class LoopExpr extends Expr {
    Expr cond;
    Expr body;

    public LoopExpr(int line_num, Expr cond, Expr body, String type_name) {
        super(line_num, type_name);
        this.cond = cond;
        this.body = body;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_loop");
        cond.dump(ps, pad+2);
        body.dump(ps, pad+2);
        super.dumpType(ps, pad);
    }

    public Expr cond() { return cond; }

    public Expr body() { return body; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitLoopExpr(this);
    }
}
