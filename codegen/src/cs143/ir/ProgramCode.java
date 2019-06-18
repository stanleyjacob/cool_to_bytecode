package cs143.ir;

import java.util.List;

public class ProgramCode extends Code {
    // This class will hold the global environment of classes and methods

    List<KlassCode> klasses;

    public ProgramCode(List<KlassCode> klasses) {
        this.klasses = klasses;
    }

    public <T> T accept(CodeVisitor<? extends T> visitor) {
        return visitor.visitProgramCode(this);
    }

    public List<KlassCode> klasses() { return klasses; }

}
