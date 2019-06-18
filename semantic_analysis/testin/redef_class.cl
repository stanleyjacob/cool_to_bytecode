
class A inherits IO {

foo(x : C) : SELF_TYPE {
    out_string("class A")
};

};

class B inherits A {

foo(x : C) : SELF_TYPE {
    out_string("class B")
};

};

class C inherits E {
y : Int;
};

class D inherits C {

};

class E inherits Main {

};

class Main inherits IO{
x : A;
y : C;
main() : A { {
    x  <- new B;
    y  <- new C;
    x.foo(y);
}
};

};
