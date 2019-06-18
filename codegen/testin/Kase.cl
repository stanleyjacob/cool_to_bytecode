class Main inherits IO {
  i : Int;
  v: Bool;
  main() : Bool {
  {
    case i of
    m : Int => v <- true;
    n : Object => v <- false;
    esac;

    v;
  }
  };

};
