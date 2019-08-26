package main.java.com.highresfelix.textadventure;

import java.util.Scanner;

/**
 * created by @highresfelix on 8/26/19
 */

public class Game {

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, Traveller");
        System.out.println("What is your name?");

        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        System.out.println("Welcome, " + name);

        System.out.println("Choose your weapon [sword/mace]");
        String weapon = scanner.nextLine();
        
        if (weapon.equalsIgnoreCase("sword")) {
            System.out.println("A sword is a nice choice!");
        } else if (weapon.equalsIgnoreCase("mace")) {
            System.out.println("A mace if a fine choice");
        } else {
            throw new Exception("An a oop! Invalid weapon.");
        }

        System.out.println("Choose your location [forest/tunnel]");
        String location = scanner.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("An a oop! Invalid location.");
        }
    }
}
