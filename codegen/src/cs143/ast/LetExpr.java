package cs143.ast;

import java.io.PrintStream;

public class LetExpr extends Expr {
    String id;
    String ty;
    Expr init;
    Expr body;

    public LetExpr(int line_num, String id, String ty, Expr init, Expr body, String type_name) {
        super(line_num, type_name);
        this.id = id;
        this.ty = ty;
        this.init = init;
        this.body = body;
    }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
        ps.println(padding(pad) + "_let");
        ps.println(padding(pad+2) + id);
        ps.println(padding(pad+2) + ty);
        init.dump(ps, pad+2);
        body.dump(ps,pad+2);
        super.dumpType(ps, pad);
    }

    public String id() { return id; }

    public String ty() { return ty; }

    public Expr init() { return init; }

    public Expr body() { return body; }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitLetExpr(this);
    }
}
