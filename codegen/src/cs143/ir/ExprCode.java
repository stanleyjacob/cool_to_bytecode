package cs143.ir;

import cs143.environment.Rvalue;

import java.util.ArrayList;
import java.util.List;

public class ExprCode extends Code {
    public Rvalue dest;

    List<Inst> insts;

    int maxStack;

    int label;

    public ExprCode() {
        this.insts = new ArrayList<>();
    }

    public ExprCode(ExprCode ec) {
        this.insts = ec.insts;
        this.dest = ec.dest;
    }

    public ExprCode(ExprCode ec1, ExprCode ec2) {
        this.insts = ec1.insts;
        this.insts.addAll(ec2.insts);
        this.dest = ec2.dest;
    }

    public void addInst(Inst i) {
        this.insts.add(i);
    }

    public void setLabel(int l) { this.label = l; }

    public List<Inst> insts() {
        return insts;
    }

    public int label() { return label; }

    public <T> T accept(CodeVisitor<? extends T> visitor) {
        return visitor.visitExprCode(this);
    }

}
