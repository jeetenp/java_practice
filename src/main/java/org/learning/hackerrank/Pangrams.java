package org.learning.hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pangrams {
    public String pangrams(String s) {
        List<String> alphabets = Stream.of("abcdefghijklmnopqrstuvwxyz".split("")).collect(Collectors.toList());
        String[] split = s.split("");
        for (String alphabet: split) {
            String s1 = alphabet.toLowerCase();
            if(alphabets.contains(s1)) {
                alphabets.remove(s1);
            }
        }
        return  alphabets.size() > 0 ? "not pangram" : "pangram";
    }

}
