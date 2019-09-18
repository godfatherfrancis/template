package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 9/8/19
 */

public class AnonymousClassExample {
    public static void main(String[] args) {
        // anonymous class used if we only intend to use this object one, defining a new class is a bit of overkill
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
