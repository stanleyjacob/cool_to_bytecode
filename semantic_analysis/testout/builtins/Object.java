public class Object {
    public Object() {
    }

    public String type_name() {
        return "Object";
    }

    public static String type_name(Object v) {
        return v.type_name();
    }
}
