(*
Exercises type_name of Object static dispatch on String object.

The behavior here is subtle, Object's type_name function just calls
type_name() on the object passed in, which calls String's type_name.

outputs String
*)

class Main inherits IO {

   main() : SELF_TYPE {
      {
      out_string("hello"@Object.type_name());
      }
   };
};
