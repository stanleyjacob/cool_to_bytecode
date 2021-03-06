package cs143.environment;

public class Rvalue {

    public enum KIND {
        IMMEDIATE, SYMBOL
    }

    public KIND kind;
    public int iimm;
    public String simm;
    public String immTy;
    public VarSymbol symbol;

    public Rvalue(VarSymbol symbol) {
        this.symbol = symbol;
        this.kind = KIND.SYMBOL;
    }

    public Rvalue(int value) {
        this.kind = KIND.IMMEDIATE;
        this.iimm = value;
        this.immTy = Singletons.INT;
    }

    public Rvalue(boolean value) {
        this.kind = KIND.IMMEDIATE;
        if (value) {
            this.iimm = 1;
        }
        else {
            this.iimm = 0;
        }
        this.immTy = "Bool";

    }

    public Rvalue(String value) {
        this.kind = KIND.IMMEDIATE;
        this.simm = value;
        this.immTy = Singletons.STRING;
    }

    public String toString() {
        if (kind == KIND.IMMEDIATE) {
            if (immTy == Singletons.INT)
                return "imm#" + iimm;
            else
                return "imm#" + simm;
        } else {
            return symbol.kind + "#" + symbol.id;
        }
    }

    public boolean isAttr() {
        return symbol.kind == VarSymbol.SymbolKind.attr;
    }

    public boolean isRef() {
        if (kind == KIND.IMMEDIATE) {
            return ! (immTy.equals(Singletons.INT) ||
                symbol.type.equals(Singletons.BOOLEAN));
        } else {
            return ! (symbol.type.equals(Singletons.INT) ||
                symbol.type.equals(Singletons.BOOLEAN));
        }
    }
}
