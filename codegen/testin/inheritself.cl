(*
Exercises inheriting an attribute of SELF_TYPE.

outputs B
*)

class A {
  x : SELF_TYPE;
};

class B inherits A {
  getme() : SELF_TYPE { x <- new SELF_TYPE };
};

class Main inherits IO {
  main() : SELF_TYPE {
    let b : B in {
      b <- (new B).getme();
      out_string(b.type_name());
    }
  };
};

