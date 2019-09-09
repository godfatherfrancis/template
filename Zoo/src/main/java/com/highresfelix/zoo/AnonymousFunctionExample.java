package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 9/8/19
 */

public class AnonymousFunctionExample {
    public static void main(String[] args) {
        // Run code from a separate method
        sayHello();

        // Run code from lambda/anonymous function
        Runnable runnable = () -> {
            System.out.println("Hello from a lambda");
        };
        runnable.run();
    }

    static void sayHello() {
        System.out.println("Hello from a method");
    }
}
