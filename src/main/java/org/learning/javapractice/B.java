package org.learning.javapractice;

public class B extends A {
    static {
        System.out.println("Static block of B");
    }
    B(){
        super();
        System.out.println("Constructor of B");
    }

    public static void main(String[] args) {
        A a = new B();

    }
}
