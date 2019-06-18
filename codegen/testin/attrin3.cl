(*
Exercises attribute initialization.

1. x set to 0 (Int default value)
2. y set to "" (String default value)
3. x set to foo() (B's foo, so "".length() which is zero)
4. y set to "he"
5. outputs 0 (x's value)
*)

class A {
 x : Int <- foo();
 foo() : Int { 3 };
 getX() : Int { x };
};

class B inherits A {
 y : String <- "he";
 foo() : Int { y.length() };
};

class Main inherits IO {
  main() : SELF_TYPE {
   let b : B <- new B in
    out_int( b.getX() )
  };
};
