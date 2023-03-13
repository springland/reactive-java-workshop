package io.javabrains.reactiveworkshop;

import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().filter(i -> i > 5).subscribe(
//                i -> System.out.print(i + ","),
//                e -> System.err.println(e.getMessage()),
//                () -> System.out.println()
//        );


        // Print 10 multiplies each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().filter(i -> i > 5).subscribe(
//                i -> System.out.print(i * 10 + ","),
//                e -> System.err.println(e.getMessage()),
//                () -> System.out.println()
//        );

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here

//        ReactiveSources.intNumbersFlux()
//                .filter(i -> i > 5)
//                .take(3)
//                .map(i -> i * 10)
//                .subscribe(i -> System.out.print(i + ",")
//                );


        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
//        ReactiveSources.intNumbersFlux().filter(i -> i > 20)
//                .defaultIfEmpty(-1)
//                .subscribe(i -> System.out.print(i)
//                );

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here

//        ReactiveSources.intNumbersFlux().flatMap(
//                i -> ReactiveSources.userFlux().filter(u -> u.getId() == i)
//        ).subscribe(System.out::println);


        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here

        //ReactiveSources.intNumbersFluxWithRepeat().distinct().subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here

//        ReactiveSources.intNumbersFluxWithRepeat().log().subscribe(
//                new RemoveImmediatelyRepeatingElementSubscriber<Integer>()
//        );

        ReactiveSources.intNumbersFluxWithRepeat().distinctUntilChanged().subscribe(System.out::println);


        System.out.println("Press a key to end");
        System.in.read();
    }


}

class RemoveImmediatelyRepeatingElementSubscriber<T> extends BaseSubscriber<T> {

    T previousValue;

    protected void hookOnNext(T value) {
        if (previousValue == null) {
            System.out.println(value);
        } else {
            if (!previousValue.equals(value)) {
                System.out.println(value);
            }
        }
        previousValue = value;

    }

}
