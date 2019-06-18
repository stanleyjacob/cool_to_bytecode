package cs143.environment;

import cs143.ast.*;

import java.util.LinkedList;
import java.util.List;

public class PopulateGlobalEnvironment {

    Environment env;
    BuiltinKlasses biks;

    public PopulateGlobalEnvironment(Environment env, BuiltinKlasses biks) {
        this.env = env;
        this.biks = biks;
    }

    private void collectLocalMethods(Klass k) {
        for (Feature f : k.features()) {
            if (f instanceof MethodFeature) {
                MethodFeature mf = (MethodFeature) f;
                String mname = mf.attr_name();
                String retTy = mf.ty_name();
                List<String> argTy = new LinkedList<>();
                for (Formal fr : mf.formals()) {
                    argTy.add(fr.ty_name());
                }
                env.addMethod(k.class_name(), mname, argTy, retTy);
            }
        }
        return;
    }

    private void collectLocalAttributes(Klass k) {
        for (Feature f : k.features()) {
            if (f instanceof AttrFeature) {
                AttrFeature af = (AttrFeature) f;
                env.addAttr(k.class_name(), af.attr_name(), af.ty_name());
            }
        }
        return;
    }

    private void installKlass(Klass k) {
        env.addKlass(k.class_name(), k.base_class_name());
        // env.asts.put(k.class_name(), k);
        collectLocalAttributes(k);
        collectLocalMethods(k);
    }

    public void installBuiltinKlasses() {
        installKlass(biks.objectKlass);
        installKlass(biks.ioKlass);
        installKlass(biks.stringKlass);
        installKlass(biks.intKlass);
        installKlass(biks.boolKlass);
    }

    public void installKlasses(Program p) {
        installBuiltinKlasses();
        for (Klass k : p.klasses()) {
            installKlass(k);
        }
    }

}
