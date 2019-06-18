class Main inherits IO {
  i : Int;


  main() : SELF_TYPE { {
    let c : Int <- 30 in i <- c + 1;
    self;
  }};
};
