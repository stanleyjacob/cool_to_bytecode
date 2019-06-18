(*
Exercises conditional expression.

outputs 3
*)

class Main inherits IO {
  i : Int;

  init() : SELF_TYPE { {
   i <- 1;
   self;
  }};

  main() : SELF_TYPE { {
    init();
    i <- if i < 0 then 5 else 3 fi;
    out_int(i);
  }};
};
