package cs143.ast;

public class LtExpr extends BinaryExpr {
    public LtExpr(int line_num, String op, Expr e1, Expr e2, String type_name) {
        super(line_num, op, e1, e2, type_name);
    }


    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitLtExpr(this);
    }
}
