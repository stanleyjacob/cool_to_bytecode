
public class String extends Object {
	public java.lang.String val;

	public String() 
	{
		val = new java.lang.String("");
	}

	public String putval(java.lang.String var1) 
	{
		String x = new String();
		x.val = var1;
		this.val = var1;
		return x;
	}

	public String putval(String var1) 
	{
		this.val = var1.val;
		return var1;
	}

	public java.lang.String getval() 
	{ 
		return val;
	}

	public Int length()
	{
		return length(this.val);
	}

	public Bool eq(String var1) {

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

	public static Int length(java.lang.String var0) 
	{
		Int curr_len = new Int();
		return curr_len.putval(var0.length());
	}

	public String concat(String s) {
		String concat_str = new String();
		concat_str.putval(this.val.concat(s.val));
		return concat_str; // shouldn't modify this param, right?
	}

	public String substr(Int i, Int l) {
		String substr_str = new String();
		substr_str.putval(this.val.substring(i.getval(), i.getval() + l.getval() ));
		return substr_str;
	}

	public static void main(java.lang.String[] args) {
		String new_str = new String();
		IO curr_io = new IO();

		curr_io.out_string(new_str);
		new_str.putval("cs143");
		curr_io.out_string((new String()).putval("\n"));

		curr_io.out_string(new_str.concat(new_str));
		curr_io.out_string((new String()).putval("\n"));

		curr_io.out_string(new_str);
		curr_io.out_string((new String()).putval("\n"));

		curr_io.out_int(new_str.length());
		curr_io.out_string((new String()).putval("\n"));

		curr_io.out_string(new_str.substr( (new Int()).putval(0), (new Int()).putval(3) ) );
		curr_io.out_string((new String()).putval("\n"));
	}

}
