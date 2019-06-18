package cs143.ast;

import java.io.PrintStream;

public abstract class Feature extends Ast {
    String attr_name;
    String ty_name;
    Expr expr;

    public Feature(int line_num, String attr_name, String ty_name, Expr expr) {
        super(line_num);
        this.attr_name = attr_name;
        this.ty_name = ty_name;
        this.expr = expr;
    }

    public String attr_name() { return attr_name; }
    public String ty_name() { return ty_name; }
    public Expr expr() { return expr; }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
    }
}
