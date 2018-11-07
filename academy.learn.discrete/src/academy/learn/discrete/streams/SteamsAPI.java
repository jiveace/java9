package academy.learn.discrete.streams;

import java.util.*;
import java.util.stream.Stream;

import static java.util.Arrays.*;
import static java.util.stream.Collectors.toList;

public class SteamsAPI {

    public static final List<Integer> NUMS = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    //Ordered List - is important
    public static final List<String> TREES = List.of("Cherry", "Oak", "Pine", "Spruce", "Walnut", "Willow");

    public static void main(String[] args) {
        System.out.println("Take while n < 8");
        NUMS.stream().takeWhile(n -> n < 8).forEach(System.out::print);
        System.out.println();

        System.out.println("Drop while n < 8");
        NUMS.stream().dropWhile(n -> n < 8).forEach(System.out::print);
        System.out.println();

        System.out.println("Take while n > 100");
        NUMS.stream().takeWhile(n -> n > 100).forEach(System.out::print);
        System.out.println();

        System.out.println("Drop while n < 100");
        NUMS.stream().dropWhile(n -> n < 100).forEach(System.out::print);
        System.out.println();

        // Prints 3 and iterates always
//        Stream.iterate(10, x-> x+1).filter(n -> n <=13).forEach(System.out::println);

        // New Stream method
        Stream.iterate(10, n -> n <=100, n -> n +=2).forEach(System.out::println);

        // New Stream method with  takeAll
        Stream.iterate(100, n -> n <=200, n -> n +=2).dropWhile(n -> n<150).forEach(System.out::println);

        TREES.stream().map(s -> s.toLowerCase()).takeWhile(s -> !s.startsWith("w")).forEach(System.out::println);
        System.out.println();
        TREES.stream().map(s -> s.toLowerCase()).dropWhile(s -> !s.startsWith("w")).forEach(System.out::println);

        var feedback = asList("3. Great Example",
                "5. Thanks for explaining this",
                null,
                "4. It was too cold in the room",
                "1. Perfect",
                null,
                "2. Wow - Perfect!");

        // Java 8 way
        var f1 = feedback.stream().filter(e -> e != null).sorted().collect(toList());

        // Java 9 way
        var f2 = feedback.stream().flatMap(e -> Stream.ofNullable(e)).sorted().collect(toList());

        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Frank", "Franky");
        nickNames.put("James", "JC");
        nickNames.put("Oscar", null);
        nickNames.put("Michael", "Mike");
        nickNames.put("Herb", "Herbie");
        nickNames.put("Elizabeth", "Liz");
        nickNames.put("Suzy", null);

        //Java 8 way
        var nick1 = nickNames.entrySet()
                .stream()
                .flatMap(e -> {
                    if (e.getValue() != null) {
                        return Stream.of(e.getValue());
                    } else {
                        return Stream.empty();
                    }
                }).collect(toList());
        System.out.println(nick1);

        //Java 9 way
        var nick2 = nickNames.entrySet()
                .stream()
                .flatMap(e -> Stream.ofNullable(e.getValue()))
                .collect(toList());

        System.out.println(nick2);

    }
}