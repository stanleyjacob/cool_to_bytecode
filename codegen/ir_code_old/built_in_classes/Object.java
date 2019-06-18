
public class Object {

	Object abort() {
		System.out.println("Abort called");
		System.exit(-1);
		return this;
	}

	String type_name() {
		return this.getClass().getSimpleName();
	}

	Object copy() {
		Object x = new Object();
		x = this;
		return x;
	}

}
