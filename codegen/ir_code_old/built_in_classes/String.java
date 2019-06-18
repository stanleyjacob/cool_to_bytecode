
public class String extends Object {
	public java.lang.String val;

	public String() 
	{
		val = new java.lang.String("");
	}

	public java.lang.String putval(java.lang.String var1) 
	{ 
		this.val = var1;
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
		substr_str.putval(this.val.substring(i.getval(), i.getval() + l.getval()));
		return substr_str;
	}

	public static void main(java.lang.String[] args) {
		String new_str = new String();
		System.out.println(new_str.getval());
		new_str.putval("cs143");
		System.out.println(new_str.concat(new_str).getval());
		System.out.println(new_str.getval());
	}

}
