package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here


        List<Integer> numberList = ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList());
        System.out.println(numberList);

        // System.out.println("Press a key to end");
        // System.in.read();
    }

}
