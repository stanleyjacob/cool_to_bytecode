package cs143.ast;

import java.io.PrintStream;

public abstract class Feature extends Ast {
    String attr_name; // addtribute name (variable)
    String ty_name; // type name ?
    Expr expr; // expression

    public Feature(int line_num, String attr_name, String ty_name, Expr expr) {
        super(line_num); // this.line_num = line_num;
        this.attr_name = attr_name;
        this.ty_name = ty_name;
        this.expr = expr;
    }

    /* getter functions */
    public String attr_name() { return attr_name; }
    public String ty_name() { return ty_name; }
    public Expr expr() { return expr; }

    @Override
    public void dump(PrintStream ps, int pad) {
        super.dump(ps, pad);
    }
}
