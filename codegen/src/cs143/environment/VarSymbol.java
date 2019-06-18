package cs143.environment;

public class VarSymbol extends Symbol {
    public String defKlass; // for attr and method

    public String type; // in method, interpreted as ret ty. Unused in klass.

    public int seq; // for params, letvar and tmps

    public enum SymbolKind {attr, param, letvar, tmp}

    public SymbolKind kind;

    public boolean not_void;

    public boolean isRef() {
        return ! ( type.equals(Singletons.INT) ||
            type.equals(Singletons.BOOLEAN) );
    }

}
