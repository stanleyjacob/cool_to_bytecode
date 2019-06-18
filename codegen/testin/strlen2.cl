(*
Exercises String length of String attribute.

outputs 6
*)

class Main inherits IO {
   x : String <- "Hello\n";

   main(): SELF_TYPE {
    out_int(x.length())
   };
};
