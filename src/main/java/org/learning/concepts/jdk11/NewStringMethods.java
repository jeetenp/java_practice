package org.learning.concepts.jdk11;

import java.util.List;
import java.util.stream.Collectors;

public class NewStringMethods {

    /**
     * lines(), isBlank()
     */
    public void linesMethod(){
        String multilineString = "Baeldung helps \n \n developers \n explore Java.";
        List<String> lines = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.toList());

        String a = multilineString.lines()
                .filter(line -> !line.isBlank())
                .map(String::strip)
                .collect(Collectors.joining(",", "", ""));

        System.out.println(lines);
        System.out.println(a);
    }

    public static void main(String[] args) {
        NewStringMethods object = new NewStringMethods();

        object.linesMethod();
    }
}
