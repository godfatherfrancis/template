package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 8/29/19
 */

public class Hawk extends Bird {
    public Hawk() {
        this.name = "Hawk";
    }

    @Override
    public void makeSound() {
        System.out.println("Cawwww!");
    }
}
