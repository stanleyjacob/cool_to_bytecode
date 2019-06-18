
class A {
    x : Int;

    foo(x : Int) : Int {
        x + x
    };
};


class B inherits A {

};


class Main inherits IO{
    x : A;
    y : B;
    n : Int;
    r : Int;

    main () : SELF_TYPE 
    { 
      {
        (let int : Int <- 0 in out_int(int));
       

        case r of nd : Bool => (new A);
                mx : Int => (nd);
        esac;

        x <- new A;
        out_int(x.foo(15));
        self; 
      }
    };
};

