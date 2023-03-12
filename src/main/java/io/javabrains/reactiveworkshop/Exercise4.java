package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Exercise4 {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        // TODO: Write code here

        ReactiveSources.intNumberMono().subscribe(System.out::println);
        // Get the value from the Mono into an integer variable
        // TODO: Write code here

        int value = ReactiveSources.intNumberMono().toFuture().get();
        System.out.println(value);

        value = ReactiveSources.intNumberMono().block();
        System.out.println(value);

        // System.out.println("Press a key to end");
        // System.in.read();
    }

}
