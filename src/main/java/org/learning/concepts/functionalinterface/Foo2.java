package org.learning.concepts.functionalinterface;

public interface Foo2 {
    // Default Method - Optional can be 0 or more
    public default String defaultMethod1() {
        return "defaultMethod1";
    }

    public default String defaultMethod2() {
        return "defaultMethod2";
    }
    public default String defaultMethod3() {
        return "defaultMethod3";
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