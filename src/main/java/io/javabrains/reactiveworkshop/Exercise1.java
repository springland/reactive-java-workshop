package io.javabrains.reactiveworkshop;

import java.util.Set;
import java.util.stream.Collectors;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources.intNumbersStream() and StreamSources.userStream()

        // Print all numbers in the intNumbersStream stream
        // TODO: Write code here

        System.out.println(StreamSources.intNumbersStream().map(String::valueOf).collect(Collectors.joining(",")));

        // Print numbers from intNumbersStream that are less than 5
        // TODO: Write code here
        System.out.println(StreamSources.intNumbersStream().filter(i -> i < 5).map(String::valueOf).collect(Collectors.joining(",")));

        // Print the second and third numbers in intNumbersStream that's greater than 5
        // TODO: Write code here
        System.out.println(StreamSources.intNumbersStream().filter(i -> i > 5).map(String::valueOf).skip(1).limit(2).collect(Collectors.joining(",")));
        //  Print the first number in intNumbersStream that's greater than 5.
        //  If nothing is found, print -1
        // TODO: Write code here
        System.out.println(StreamSources.intNumbersStream().filter(i -> i > 5).findFirst().orElse(-1));

        // Print first names of all users in userStream
        // TODO: Write code here

        System.out.println(StreamSources.userStream().map(u -> u.getFirstName()).collect(Collectors.joining(",")));
        // Print first names in userStream for users that have IDs from number stream
        // TODO: Write code here

        Set<Integer> uniqueNumbers = StreamSources.intNumbersStream().collect(Collectors.toSet());
        System.out.println(StreamSources.userStream().filter(u -> uniqueNumbers.contains(u.getId())).map(u -> u.getFirstName()).collect(Collectors.joining(",")));

        System.out.println(
                StreamSources.intNumbersStream().flatMap(i -> StreamSources.userStream().filter(user -> user.getId() == i))
                        .map(u -> u.getFirstName())
                        .collect(Collectors.joining(","))
        );

        System.out.println(
                StreamSources.userStream().filter(u -> StreamSources.intNumbersStream().anyMatch(i -> u.getId() == i))
                        .map(u -> u.getFirstName())
                        .collect(Collectors.joining(","))

        );
    }

}
