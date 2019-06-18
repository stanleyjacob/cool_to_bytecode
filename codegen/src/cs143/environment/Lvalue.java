package cs143.environment;

public class Lvalue {

    public VarSymbol symbol;

    public Lvalue(VarSymbol symbol) {
        this.symbol = symbol;
    }

    public String toString() {
        return symbol.kind + "#" + symbol.id;
    }

    public boolean isAttr() {
        return symbol.kind == VarSymbol.SymbolKind.attr;
    }

    public boolean isRef() {
        return ! (symbol.type.equals(Singletons.INT) || symbol.type.equals(Singletons.BOOLEAN));
    }
}
