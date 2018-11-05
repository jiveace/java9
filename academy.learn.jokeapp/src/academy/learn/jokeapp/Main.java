package academy.learn.jokeapp;

import academy.learn.jokeserver.*;
import academy.learn.jokeserver.kid.KidJokeServer;
import academy.learn.jokeserver.programmer.CoderJokeServer;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LinkedHashMap<String, JokeServer> servers = new LinkedHashMap<>();

        servers.put("1", new KidJokeServer());
        servers.put("2", new CoderJokeServer());

        Scanner scanner = new Scanner(System.in);
        String choice = "";
        do {

            servers.forEach((k, v) -> System.out.printf("%s: %s\n", k, v.name()));

            System.out.print("(Q to quit) : ");
            choice = scanner.nextLine().trim().toUpperCase();

            if (servers.containsKey(choice)) {
                System.out.println(servers.get(choice).getJoke() + "\n");
            } else if (!choice.equals("Q")) {
                System.out.println("Sorry, try again. ");
            }

        } while (!choice.equals("Q"));

        System.out.println("Thanks! I hope you laughed!!");
    }
}