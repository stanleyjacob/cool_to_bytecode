(*
Exercises attribute assignment.

outputs 44
*)

class Main inherits IO {

   v : Int;

   main() : SELF_TYPE {
      {
      v <- 2;
      out_int(v + 42);
      }
   };
};
