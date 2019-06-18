
public class Int extends Object {
	public int val;

	public Int() {
		this.val = 0;
	}

	public Int(int x) {
		this.val = x;
	}

	public Int add(Int x) {
		return new Int(this.val + x.val);
	}

	public Int add(int x) {
		Int tmp = new Int(x);
		return this.add(tmp);
	}

	public static Int add(Int x, Int y) {
		Int lval = new Int();
		lval.val = x.val + y.val;
		return lval;
	}

	public static Int add(Int x, int y) {
		Int lval = new Int();
		lval.val = x.val + y;
		return lval;
	}

	public static Int add(int x, Int y) {
		Int lval = new Int();
		lval.val = x + y.val;
		return lval;
	}

	public static Int add(int x, int y) {
		Int lval = new Int();
		lval.val = x + y;
		return lval;
	}

	public static void main(String args[]) {
		int x = 5;
		int x2 = 8;
		int z = x + x2;
		System.out.println(z);

		Int y = new Int();
		y = y.add(6);
		y = y.add(y);
		System.out.println(y.val);

		Int final_int = add(y, y);
		System.out.println(final_int.val);

		Int final_int2 = add(y, y.val);
		System.out.println(final_int2.val);

		Int final_int3 = add(y.val, y.val);
		System.out.println(final_int3.val);

		Int final_int4 = add(y.val, y);
		System.out.println(final_int4.val);
	}

}