package cs143.ir;

import cs143.ir.Code;
import cs143.environment.VarSymbol;
import java.util.List;

public class AttrCode extends Code {

		VarSymbol attribute;
    ExprCode expr;


    public AttrCode(VarSymbol attr, ExprCode expr) {
        this.attribute = attr;
        this.expr = expr;
    }

    public VarSymbol attribute() { return attribute; }

    public ExprCode expr() { return expr; }



    public <T> T accept(CodeVisitor<? extends T> visitor) {
        return visitor.visitAttrCode(this);
    }

}
