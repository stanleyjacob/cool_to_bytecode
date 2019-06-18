
public class Int extends Object {
	public int val;

	public Int() {
		this.val = 0;
	}

	public Int putVal(int x) {
		this.val = x;
		return this;
	}

	public int getVal() {
		return val;
	}

	public static Int add(Int x, Int y) {
		Int lval = new Int();
		lval.val = x.val + y.val;
		return lval;
	}

	public static void main(String args[]) {
		Int y = new Int();
		y.putVal(12);
		Int final_int2 = add(y, (new Int()).putVal(6));
		System.out.println(final_int2.getVal());
	}

}