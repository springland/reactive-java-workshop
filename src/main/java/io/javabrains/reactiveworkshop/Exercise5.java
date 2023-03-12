package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.Exceptions;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
//        System.out.println("Subscribe to a flux using the error and completion hooks");
//        ReactiveSources.intNumbersFlux().subscribe(
//                i -> System.out.println(i),
//                ex -> {
//                    System.err.println(ex);
//                    ex.printStackTrace();
//                },
//                () -> System.out.println(" Flux completed")
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here

        System.out.println(" Subscribe to a flux using an implementation of BaseSubscriber");
        Subscriber mySubscriber = new MySubscriber<Integer>();
        ReactiveSources.intNumbersFlux().subscribe(mySubscriber);
        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {

    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription happened");
        upstream().request(1);
    }

    protected void hookOnNext(T value) {
        System.out.println(String.valueOf(value) + " Received");
        upstream().request(1);
    }

    protected void hookOnComplete() {
        System.out.println(" subscription completed");

    }

    protected void hookOnError(Throwable throwable) {
        System.err.println(throwable.getMessage());
        throwable.printStackTrace();
        throw Exceptions.errorCallbackNotImplemented(throwable);
    }


}