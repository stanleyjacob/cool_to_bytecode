
import java.util.Scanner;

public class IO extends Object {

	public IO out_string(String x) {
		System.out.print(x);
		return this;
	}

	public IO out_int(int x) {
		System.out.print(x);
		return this;
	}

	public String in_string() {
		Scanner myObj = new Scanner(System.in);
		String usr_string = myObj.nextLine();
		return usr_string;
	}

	public int in_int() {
		Scanner myObj = new Scanner(System.in);
		int usr_int = myObj.nextInt();
		return usr_int;
	}

}
