

class Main inherits IO {
	x : Int <- 0;
	main() : Int {
		{
		x = x + 1;
		x;
		}
	};
};