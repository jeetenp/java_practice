package org.learning.concepts.functionalinterface;

public interface Foo1 {
    // Default Method - Optional can be 0 or more
    public default String defaultMethod1() {
        return "defaultMethod1";
    }

    public default String defaultMethod2() {
        return "defaultMethod2";
    }

    public default String defaultMethod4() {
        return "defaultMethod4";
    }
    // Static Method - Optional can be 0 or more
    public static String staticMethod1(String msg) {
        return msg;
    }
    public static String staticMethod2(String msg) {
        return msg;
    }

    // Single Abstract Method
    public void bar();
}