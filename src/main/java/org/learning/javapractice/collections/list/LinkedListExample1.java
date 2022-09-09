package org.learning.javapractice.collections.list;

import java.util.LinkedList;

public class LinkedListExample1 {
    public static void main(String[] args) {
        LinkedList<String> a = new LinkedList<>();

        a.add("Jeeten");
        a.add("Santhoshi");
        a.add("Poorvi");
        a.add("Poorvi");

        System.out.println(a);
        System.out.println(a.peek());
        System.out.println(a);
        System.out.println(a.pop());
        System.out.println(a);
        System.out.println(a.getFirst());
        System.out.println(a);
        System.out.println(a.getLast());
        System.out.println(a);

    }
}
