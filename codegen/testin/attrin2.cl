(*
Exercises attribute initialization.

1. x set to 0 (Int default value)
2. x set to foo() (B's foo, so x <- 0 + 5
                   which evaluates to 5)
3. outputs 5
*)

class A {
 x : Int <- foo();
 foo() : Int { x <- x + 3 };
 getX() : Int { x };
};

class B inherits A {
 foo() : Int { x <- x + 5 };
};

class Main inherits IO {
  main() : SELF_TYPE {
   let b : B <- new B in
    out_int( b.getX() )
  };
};

