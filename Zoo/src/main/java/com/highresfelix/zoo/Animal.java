package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 8/29/19
 */

public class Animal {
    String name;

    public void makeSound() {
        System.out.println("Animal sound!");
    }

    @Override
    public String toString() {
        return this.name;
    }
}
