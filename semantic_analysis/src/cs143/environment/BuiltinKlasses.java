package cs143.environment;

import cs143.ast.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuiltinKlasses {
    Environment env;

    public BuiltinKlasses(Environment e) {
        env = e;
    }

    private Klass object_klass() {
        List<Feature> objectFeatures = new ArrayList<>();
        objectFeatures.add(
                new MethodFeature(0,"abort", new ArrayList<>(), Singletons.OBJECT, Singletons.NOEXPR)
        );
        objectFeatures.add(
                new MethodFeature(0, "type_name", new ArrayList<>(), Singletons.STRING, Singletons.NOEXPR)
        );
        objectFeatures.add(
                new MethodFeature(0, "copy", new ArrayList<>(), Singletons.SELF_TYPE, Singletons.NOEXPR)
        );
        return new Klass(0, Singletons.OBJECT, Singletons.BOTTOM, "builtin.cl", objectFeatures);
    }

    private Klass io_klass() {
        List<Feature> ioFeatures = new ArrayList<>();
        List<Formal> out_string_formals = new ArrayList<>();
        out_string_formals.add(new Formal(0, "x", Singletons.STRING));
        ioFeatures.add(
                new MethodFeature(0, "out_string",
                        out_string_formals,
                        Singletons.SELF_TYPE, Singletons.NOEXPR)
        );

        List<Formal> out_int_formals = new ArrayList<>();
        out_int_formals.add(new Formal(0, "x", Singletons.INT));
        ioFeatures.add(
                new MethodFeature(0, "out_int",
                        out_int_formals,
                        Singletons.SELF_TYPE, Singletons.NOEXPR)
        );

        List<Formal> in_int_formals = new ArrayList<>();
        ioFeatures.add(
                new MethodFeature(0, "in_int",
                        in_int_formals,
                        Singletons.INT, Singletons.NOEXPR)
        );

        List<Formal> in_string_formals = new ArrayList<>();
        ioFeatures.add(
                new MethodFeature(0, "in_string",
                        in_string_formals,
                        Singletons.STRING, Singletons.NOEXPR)
        );

        // TODO in_int and in_string
        return new Klass(0,"IO", Singletons.OBJECT, "builtin.cl", ioFeatures);
    }

    private Klass string_klass() {
        List<Feature> stringFeatures = new ArrayList<>();

        List<Formal> length_formals = new ArrayList<>();
        stringFeatures.add(
                new MethodFeature(0, "length",
                        length_formals, Singletons.INT, Singletons.NOEXPR)
        );

        List<Formal> concat_formals = new ArrayList<>();
        concat_formals.add(new Formal(0, "s", Singletons.STRING));
        stringFeatures.add(
                new MethodFeature(0, "concat",
                        concat_formals,
                        Singletons.STRING, Singletons.NOEXPR)
        );

        List<Formal> substr_formals = new ArrayList<>();
        substr_formals.add(new Formal(0, "i", Singletons.INT));
        substr_formals.add(new Formal(0, "l", Singletons.INT));
        stringFeatures.add(
                new MethodFeature(0, "substr",
                        substr_formals,
                        Singletons.STRING, Singletons.NOEXPR)
        );

        List<Formal> putval_formals = new ArrayList<>();
        putval_formals.add(new Formal(0, "s", Singletons.STRING));
        stringFeatures.add(
                new MethodFeature(0, "putval",
                        putval_formals,
                        Singletons.STRING, Singletons.NOEXPR) // TODO should return VOID?
        );

        return new Klass(0, Singletons.STRING, Singletons.OBJECT, "builtin.cl", stringFeatures);
    }

    private Klass int_klass() {
        List<Feature> intFeatures = new ArrayList<>();
        return new Klass(0, Singletons.INT, Singletons.OBJECT, "builtin.cl", intFeatures);
    }

    private Klass bool_klass() {
        List<Feature> boolFeatures = new ArrayList<>();
        return new Klass(0, Singletons.BOOLEAN, Singletons.OBJECT, "builtin.cl", boolFeatures);
    }

    public Klass objectKlass = object_klass();

    public Klass ioKlass = io_klass();

    public Klass stringKlass = string_klass();

    public Klass intKlass = int_klass();

    public Klass boolKlass = bool_klass();

}
