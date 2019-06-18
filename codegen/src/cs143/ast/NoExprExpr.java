package cs143.ast;

import java.io.PrintStream;

public class NoExprExpr extends Expr {
    public NoExprExpr(int line_num, String type_name) {
        super(line_num, type_name);
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_no_expr");
        super.dumpType(ps, pad);
    }


    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitNoExprExpr(this);
    }
}
