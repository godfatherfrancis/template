package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 8/29/19
 */

public class Dog extends Mammal {
    public Dog() {
        this.name = "Dog";
    }

    @Override
    public void makeSound() {
        System.out.println("Bark!");
    }
}
