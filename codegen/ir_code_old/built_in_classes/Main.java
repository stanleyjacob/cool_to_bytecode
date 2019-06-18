
public class Bool extends Object {
	public boolean val;

	public Bool() {
		this.val = false;
	}

	public Bool putVal(boolean x) {
		this.val = x;
		return this;
	}

	public boolean getVal() {
		return val;
	}

	public static void main(String args[]) {
		Bool y = new Bool();
		System.out.println(y.getVal());
		y.putVal(true);
		System.out.println(y.getVal());
	}
}