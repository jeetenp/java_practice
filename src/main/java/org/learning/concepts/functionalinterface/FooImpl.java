package org.learning.concepts.functionalinterface;

public class FooImpl implements Foo1, Foo2{
    @Override
    public String defaultMethod1() {
        return "";
    }

    @Override
    public String defaultMethod2() {
        return "";
    }

    public String testMethod() {
        return "";
    }

    @Override
    public void bar() {

    }

    public static void main(String[] args) {
        FooImpl foo = new FooImpl();
        foo.bar();
        foo.defaultMethod1();
        foo.defaultMethod2();
        foo.defaultMethod3();
        foo.defaultMethod4();
        foo.testMethod();
    }
}
