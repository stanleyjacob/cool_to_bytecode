(*
Exercises let var of SELF_TYPE.

outputs 5
*)

class A inherits IO {
  x : Int <- 5;
  getX() : Int { x };
  bar() : SELF_TYPE {
   let a : SELF_TYPE <- new SELF_TYPE in
    out_int ( a.getX() )
  };
};

class Main inherits A {
  main() : SELF_TYPE {
   let a : A <- new A in {
     a.bar();
     self;
   }
  };

};
