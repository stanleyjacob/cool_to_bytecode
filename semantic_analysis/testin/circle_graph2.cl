
class A inherits Q {

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


class E {

};

class Q inherits B {

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
