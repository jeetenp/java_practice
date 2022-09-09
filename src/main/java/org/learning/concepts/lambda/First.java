package org.learning.concepts.lambda;

import java.util.function.Function;

public class First {
    Function<String, String> fi = name -> "Hello " + name;

    public static void main(String[] args) {
        First first = new First();
        System.out.println(first.fi.apply("Jeeten"));
    }

}
