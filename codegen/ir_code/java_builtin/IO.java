
import java.util.Scanner;

public class IO extends Object {

	public IO out_string(String x) {
		java.lang.String extracted_str = x.getval();
		System.out.print(extracted_str);
		return this;
	}

	public IO out_int(Int x) {
		int extracted_int = x.getval();
		System.out.print(extracted_int);
		return this;
	}

	public String in_string() {
		Scanner myObj = new Scanner(System.in);
		java.lang.String usr_string = myObj.nextLine();

		String ret_string = new String();
		ret_string.putval(usr_string);

		return ret_string;
	}

	public Int in_int() {
		Scanner myObj = new Scanner(System.in);
		int usr_int = myObj.nextInt();

		Int ret_int = new Int();
		ret_int.putval(usr_int);

		return ret_int;
	}

	public static void main(java.lang.String[] args) {
		IO new_io = new IO();
		new_io.out_string((new String()).putval("hi\n"));
		new_io.out_int((new Int()).putval(5));
		new_io.out_string((new String()).putval("hi\n"));
		
		String x = new_io.in_string();
		Int y = new_io.in_int();

		new_io.out_string(x);
		new_io.out_string((new String()).putval("\n"));
		new_io.out_int(y);
		new_io.out_string((new String()).putval("\n"));
	}

}
