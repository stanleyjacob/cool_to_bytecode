package cs143.ast;

public class DivideExpr extends BinaryExpr {
    public DivideExpr(int line_num, String op, Expr e1, Expr e2, String type_name) {
        super(line_num, op, e1, e2, type_name);
    }

    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitDivideExpr(this);
    }
}
