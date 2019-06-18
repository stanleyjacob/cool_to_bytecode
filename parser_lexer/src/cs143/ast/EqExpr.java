package cs143.ast;

public class EqExpr extends BinaryExpr {
    public EqExpr(int line_num, String op, Expr e1, Expr e2, String type_name) {
        super(line_num, op, e1, e2, type_name);
    }


    public <T> T accept(AstVisitor<? extends T> visitor) {
        return visitor.visitEqExpr(this);
    }
}
