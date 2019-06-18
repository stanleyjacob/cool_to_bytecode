
import java.util.Scanner;

public class IO extends Object {
    int val;

    public IO() {
    }

    public Object out_int(int v) {
        System.out.println(v);
        return this;
    }

    public Object out_string(String s) {
        System.out.println(s);
        return this;
    }

    public String in_string() {
        Scanner myObj = new Scanner(System.in);
        String x = myObj.nextLine();
        return x;
    }

    public int in_int() {
        Scanner myObj = new Scanner(System.in);
        int x = myObj.nextInt();
        return x;
    }

    public String type_name() {
        return "IO";
    }

    public static String type_name(IO io) {
        return io.type_name();
    }
}
