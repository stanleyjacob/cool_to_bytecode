class Main inherits IO {
  i : Int;

  init() : SELF_TYPE { {
   i <- 1;
   self;
  }};

  main() : SELF_TYPE { {
    init();
    while i < 10 loop i <- i + 1 pool;
    out_int(i);
  }};
};
