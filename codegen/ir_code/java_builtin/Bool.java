
public class Bool extends Object {
	public boolean val;

	public Bool() {
		this.val = false;
	}

	public Bool putval(int x) {
		Bool new_bool = new Bool();
		if (x == 0) {
			new_bool.putval(false);
		}
		else {
			new_bool.putval(true);
		}
		return new_bool;
	}

	public Bool putval(boolean x) {
		Bool new_bool = new Bool();
		new_bool.val = x;
		this.val = x;
		return new_bool;
	}

	public Bool putval(Bool var1) 
	{
		this.val = var1.val;
		return var1;
	}

	public int eq(Bool var1) {
		if (this.val == var1.val) {
			return 1;
		}
		return 0;
	}

	public Bool true_eq(Bool var1) {
		if (this.val == var1.val) {
			Bool new_bool = new Bool();
			new_bool.putval(true);
			return new_bool;
		}
		else {
			Bool new_bool = new Bool();
			new_bool.putval(false);
			return new_bool;
		}
	}

	public boolean getval() {
		return val;
	}

	public Bool not() {
		Bool retval = new Bool();
		retval.val = !this.val;
		return retval;
	}

	public int eq(Int val) {
		int curr_val = 0;
		if (this.val) {
			curr_val = 1;
		}
		if (curr_val == val.getval()) {
			return 1;
		}
		else {
			return 0;
		}
	}

	// public Bool boolFromInt(Int val) {
	// 	Bool new_bool = new Bool();
	// 	int curr_val = val.getval();
	// 	return new_bool.putval(curr_val);
	// }

	// public int leq(Int val) {
	// 	int curr_val = 0;
	// 	if (this.val) {
	// 		curr_val = 1;
	// 	}
	// 	if (curr_val <= val.getval()) {
	// 		return 1;
	// 	}
	// 	else {
	// 		return 0;
	// 	}
	// }

	// public int lt(Int val) {
	// 	int curr_val = 0;
	// 	if (this.val) {
	// 		curr_val = 1;
	// 	}
	// 	if (curr_val < val.getval()) {
	// 		return 1;
	// 	}
	// 	else {
	// 		return 0;
	// 	}
	// }

	public static void main(java.lang.String[] args) {
		Bool y = new Bool();
		System.out.println(y.getval());
		y.putval(true);
		System.out.println(y.getval());
		System.out.println(y.not().getval());

		Int x = new Int();
		x.putval(0);
		Int z = new Int();
		z.putval(1);

		System.out.println(y.eq(x));
		// System.out.println(y.leq(x));
		// System.out.println(y.lt(x));

		System.out.println(y.eq(z));
		// System.out.println(y.leq(z));
		// System.out.println(y.lt(z));

		// Bool q = new Bool();
		// q.boolFromInt(x);
		// System.out.println("hi");
		y.putval(1);
	}
	
}