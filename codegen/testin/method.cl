class Main inherits IO {
  i : Int;
  j : Int;
  k : Int;

  init() : SELF_TYPE { {
   i <- 1;
   j <- 2;
   self;
  }};

  add(a : Int, b : Int) : Int {{
    k <- a + b;
    k;
  }};

  main() : SELF_TYPE { {
    init();
    k <- add(3, 4);
    out_int(k);
  }};
};
