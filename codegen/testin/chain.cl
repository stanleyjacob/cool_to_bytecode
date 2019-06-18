(*
Tests method chaining, specifically with regards to proper use of SELF_TYPE.

outputs 35 ("3" and "5")
*)

class Main inherits IO {

  main() : SELF_TYPE {

    out_int(3).out_int(5)

  };

};

