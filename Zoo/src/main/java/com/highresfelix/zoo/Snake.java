package main.java.com.highresfelix.zoo;

/**
 * created by @highresfelix on 8/29/19
 */

public class Snake extends Reptile {
    public Snake() {
        this.name = "Snake";
    }

    @Override
    public void makeSound() {
        System.out.println("Sssssssss!");
    }
}
