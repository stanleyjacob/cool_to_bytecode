(*
Exercises static dispatch.

outputs 3413 ("3", "4", "1", "3")
*)

class A inherits IO {
  a : Int;
  init() : Int { a <- 1 };
  ma() : Int { a };
  mb() : Int { ma() };
};

class B inherits A {
  ma() : Int { 4 };
};

class C inherits B {
  ma() : Int { 3 };
  work() : Int {
    {
     init();
     out_int(mb()); -- should print 3
     out_int(self@B.ma()); -- should print 4
     out_int(self@A.ma()); --- should print 1
     out_int(self@A.mb()); --- should print 3
     0;
    }
  };
};

class Main {
  main() : SELF_TYPE {
    (let c : C in { c <- new C; c.work(); self; })
  };
};
