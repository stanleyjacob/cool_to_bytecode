class Main inherits IO { (* -- comment *)
  i : Int;

  init() : SELF_TYPE { {
   i <- 1;
   self;
  }};

  main() : SELF_TYPE { {
    init();
    i <- IF i < 0 then 5 else 3 fi;
    out_int(i);
 k / 2;
 out_string("\n\{\^\~\''\"\d\"\\\"'\'\1\df\tt\
                ddf\
                df");
  }};

};
-- *)
