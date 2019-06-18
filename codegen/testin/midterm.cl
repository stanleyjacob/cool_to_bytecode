(*
Exercises attribute initialization.

outputs 5
*)

class B {
  bar() : Int { 5 };
};

class A {
   foo() : Int {  x + y.length() };

   x : Int <- foo();
   y : String <- "Hello";
};

class Main inherits IO {
 main() : SELF_TYPE {
    let a : A <- new A in
       out_int ( a.foo() )
 };
};
