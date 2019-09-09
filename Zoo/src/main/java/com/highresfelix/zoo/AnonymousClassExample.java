package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 9/8/19
 */

public class AnonymousClassExample {
    public static void main(String[] args) {
        // anonymous class
        Reptile alligator = new Reptile() {
            @Override
            public void makeSound() {
                System.out.println("Croak");
            }
        };
        alligator.name = "Alligator";

        alligator.makeSound();
    }
}
