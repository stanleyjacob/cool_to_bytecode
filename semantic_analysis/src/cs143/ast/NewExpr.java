package cs143.ast;

import java.io.PrintStream;

public class NewExpr extends Expr {
    String id;

    public NewExpr(int line_num, String id, String type_name) {
        super(line_num, type_name);
        this.id = id;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_new");
        ps.println(padding(pad+2) + id);
        super.dumpType(ps, pad);
    }

    public String id() { return id; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitNewExpr(this);
    }
}
