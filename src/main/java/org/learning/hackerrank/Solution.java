package org.learning.hackerrank;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Create the Filter and Mapper classes here.
 */
class Filter {

    public static Predicate<String> nameStartingWithPrefix(String nextLine) {
        return nextLine1 -> nextLine1.startsWith(nextLine);
    }
}
class Mapper {

    public static Function<String, CharactersCount> getDistinctCharactersCount_2() {
        return name -> new CharactersCount(name, Arrays.stream(name.split("")).distinct().collect(Collectors.toList()).size());
    }
    public static Function<String, CharactersCount> getDistinctCharactersCount() {
        Function<String, CharactersCount> fi = name -> {
            Set<Character> unique = new HashSet<>();
            for (int i = 0; i < name.length(); i++) {
                unique.add(name.charAt(i));
            }
            CharactersCount charactersCount = new CharactersCount(name, unique.size());
            return charactersCount;
        };
        return fi;
    }
}

class CharactersCount {
    private final String name;
    private final Integer distinctCharacterCount;

    public CharactersCount(String name, Integer distinctCharacterCount) {
        this.name = name;
        this.distinctCharacterCount = distinctCharacterCount;
    }

    @Override
    public String toString() {
        return "\"" + this.name + "\" has " + this.distinctCharacterCount + " distinct characters.";
    }
}

public class Solution {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "aaryanna", "aayanna", "airianna", "alassandra", "allanna", "allannah", "allessandra", "allianna",
                "allyanna", "anastaisa", "anastashia", "anastasia", "annabella", "annabella", "annabelle", "annabelle",
                "annebelle"
        );

        names.stream()
                .filter(Filter.nameStartingWithPrefix(scanner.nextLine()))
                .map(Mapper.getDistinctCharactersCount())
                .forEachOrdered(System.out::println);

        System.out.println(names.stream().distinct().collect(Collectors.toList()).size());
    }
}