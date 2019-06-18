(*
Exercises attribute initialization.

1. x set to 0 (Int default value)
2. y set to 0 (Int default value)
3. y set to 1 (x + 1)
4. outputs 1 (y + x = 1 + 0 = 1)
*)

class A {
  x : Int;
};

class B inherits A {
  y : Int <- x + 1;
};

class Main inherits B {
  io : IO <- new IO;

  main() : IO {
    io.out_int(y + x)
  };
};
