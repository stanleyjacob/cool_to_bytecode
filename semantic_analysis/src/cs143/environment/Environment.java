package cs143.environment;

import cs143.ast.*;

import java.util.*;

public class Environment extends BaseEnvironment {

    public String currentKlass = null;

    public void enterClass(String kname) {
        addAttributesToSymbolTable(kname, varsymtab);
        addMethodsToSymbolTable(kname, methsymtab);
    }

    public void exitClass() {
        varsymtab.popScope();
        methsymtab.popScope();
    }

    public void enterMethod() {
        varsymtab.pushScope();
    }

    public void exitMethod() {
        varsymtab.popScope();
    }

    public void enterLet() {
        varsymtab.pushScope();
    }

    public void exitLet() {
        varsymtab.popScope();
    }
}
