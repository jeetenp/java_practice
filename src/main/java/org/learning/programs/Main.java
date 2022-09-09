package org.learning.programs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        a.add("d");
        a.add("a");
        a.add("d");
        a.add("d");
        a.add("d");

        String csv = a.stream().filter(e -> e.equalsIgnoreCase("d")).collect(Collectors.joining(","));
        System.out.println(csv);

        List<String> collect = List.of(csv.split(",")).stream().collect(Collectors.toList());
        System.out.println(collect);

        List<Integer> ll = new LinkedList<>();
        ll.add(2);
        ll.add(4);
        ll.add(1);
        ll.add(3);


    }
}
