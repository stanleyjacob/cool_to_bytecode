package cs143.environment;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SymbolTable<T extends Symbol> {

    LinkedList<Map<String, T>> scopes;

    Map<String, T> top;

    public SymbolTable() {
        scopes = new LinkedList<>();
        top = null;
    }

    public void pushScope() { // fresh scope
        Map<String, T> m = new LinkedHashMap<>();
        scopes.addLast(m);
        top = m;
    }

    public void pushScope(Map<String, T> map) {
        scopes.addLast(map);
        top = map;
    }

    public void popScope() {
        scopes.removeLast();
        if (scopes.size() > 0)
            top = scopes.getLast();
        else
            top = null;
    }

    public void put(String id, T s) {
        top.put(id, s);
    }

    public T find(String id) {
        int size = scopes.size();
        while (size > 0) {
            Map<String, T> scope = scopes.get(size-1);
            T s = scope.get(id);
            if (s != null)
                return s;
            size--;
        }
        throw new Error("ID not found: " + id);
    }

    public boolean isfind(String id) {
        int size = scopes.size();
        while (size > 0) {
            Map<String, T> scope = scopes.get(size-1);
            T s = scope.get(id);
            if (s != null)
                return true;
            size--;
        }
        return false;
    }

    public T find(String id, Map<String, T> start) {
        int size = scopes.size();
        boolean found_start = false;
        while (size > 0) {
            Map<String, T> scope = scopes.get(size-1);
            if (scope == start)
                found_start = true;
            if (found_start) {
                T s = scope.get(id);
                if (s != null)
                    return s;
            }
            size--;
        }
        throw new Error("ID not found: " + id);
    }
}
