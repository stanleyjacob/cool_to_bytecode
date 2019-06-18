
public class Main extends IO {
	Int i;

	Main init() {
		i = new Int();
		i.putVal(1);
		return this;
	}

	public Main main() {
		init();
		if (i.getVal() < 0) {
			i.putVal(5);
		}
		else {
			i.putVal(3);
		}
		return (Main) out_int(i.getVal());
	}

	public static void main(String[] args) {
		(new Main()).main();
	}

}