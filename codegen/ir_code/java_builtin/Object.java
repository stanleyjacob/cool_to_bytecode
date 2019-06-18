
public class Object {

	public Object abort() {
		// System.err.println("Abort called"); // Diff check
		System.exit(-1);
		return this;
	}

	public String type_name() {
		String type_str = new String();
		type_str.putval(this.getClass().getSimpleName());
		return type_str;
	}

	public Object copy() {
		Object x = new Object();
		x = this;
		return x;
	}

	public static void main(java.lang.String[] args) {
		Object y = new Object();
		System.out.println(y.type_name().getval());
		y.copy();
		y.abort();
		System.out.println("here");
	}

}
