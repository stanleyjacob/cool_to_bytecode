
public class Int extends Object {
	private int val;

	public Int() {
		this.val = 0;
	}

	public Bool convertToBool() {
		Bool ret_val = new Bool();
		ret_val.putval(val);
		return ret_val;
	}

	public Int putval(int x) {
		Int new_int = new Int();
		new_int.val = x;
		this.val = x;
		return new_int;
	}

	public Int putval(Int x) {
		this.val = x.val;
		return x;
	}

	public int getval() {
		return val;
	}

	public Int neg() {
		Int retval = new Int();
		retval.val = -this.val;
		return retval;
	}

	public Int add(Int rhs) {
		Int retval = new Int();
		retval.val = this.val + rhs.val;
		return retval;
	}

	public Int minus(Int rhs) {
		Int retval = new Int();
		retval.val = this.val - rhs.val;
		return retval;
	}

	public Int multiply(Int rhs) {
		Int retval = new Int();
		retval.val = this.val * rhs.val;
		return retval;
	}

	public Int divide(Int rhs) {
		if (rhs.val == 0) {
			this.abort(); // no division by zero
		}
		Int retval = new Int();
		retval.val = this.val / rhs.val;
		return retval;
	}

	public Bool eq(Int rhs) {
		Bool ret_val = new Bool();
		ret_val.putval(this.val == rhs.val);
		return ret_val;
	}

	public Bool leq(Int rhs) {
		Bool ret_val = new Bool();
		ret_val.putval(this.val <= rhs.val);
		return ret_val;
	}

	public Bool lt(Int rhs) {
		Bool ret_val = new Bool();
		ret_val.putval(this.val < rhs.val);
		return ret_val;
	}

	public static void main(java.lang.String[] args) {
		IO new_io = new IO();
		Int y = new Int();
		y.putval(12);
		System.out.println(y.getval());

		Int final_int2 = y.add((new Int()).putval(6));
		new_io.out_int(final_int2);
		System.out.println();

		new_io.out_int(y.minus((new Int()).putval(6)));
		System.out.println();

		new_io.out_int(y.multiply((new Int()).putval(6)));
		System.out.println();

		new_io.out_int(y.divide((new Int()).putval(6)));
		System.out.println();

		System.out.println(y.eq((new Int()).putval(12)).getval());

		System.out.println(y.leq((new Int()).putval(12)).getval());

		System.out.println(y.lt((new Int()).putval(12)).getval());

		new_io.out_int(y.neg());
		System.out.println();

		Bool val = y.convertToBool();
	}

}