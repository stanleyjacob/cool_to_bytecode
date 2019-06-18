package cs143.ast;

import java.io.PrintStream;
import java.util.List;

public class BlockExpr extends Expr {

    List<Expr> exprs;

    public BlockExpr(int line_num, List<Expr> exprs, String type_name) {
        super(line_num, type_name);
        this.exprs = exprs;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_block");
        for (Expr e : exprs) e.dump(ps, pad + 2);
        super.dumpType(ps, pad);
    }

    public List<Expr> exprs () { return exprs; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitBlockExpr(this);
    }
}

