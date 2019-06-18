package cs143.ast;

public class NegExpr extends UnaryExpr {
    public NegExpr(int line_num, String op, Expr e, String type_name) {
        super(line_num, op, e, type_name);
    }


    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitNegExpr(this);
    }
}
