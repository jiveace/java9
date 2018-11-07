package academy.learn.discrete.collections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Java 8 way
        List<String> unmodifiableTrees = Arrays.asList("Oak", "Pine", "Teak");

        List<String> modifiableTrees = new ArrayList(Arrays.asList("Oak", "Pine", "Teak"));
        modifiableTrees.add("Apple");

        //Java 9 way
        List<String> java9Trees = List.of("Oak", "Pine", "Teak");
        Set<Integer> java9Set = Set.of(1,2,3,4,5);
        var java9Map = Map.of("Key 1", "Value 1",
                "Key 2", "Value 2",
                "Key 3", "Value 3");
    }

}
