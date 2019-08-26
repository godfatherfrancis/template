package main.java.com.highresfelix.textadventure;

import java.util.ArrayList;

/**
 * created by @highresfelix on 8/26/19
 */

public class Player {
    String name;
    String weapon;
    String location;
    ArrayList<String> items = new ArrayList<>();

    // constructor
    public Player() {

    }

    public void chooseName() {
        System.out.println("What is your name?");

        name = Game.scanner.nextLine();
        System.out.println("Welcome, " + name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace]");
        weapon = Game.scanner.nextLine();

        if (weapon.equalsIgnoreCase("sword")) {
            System.out.println("A sword is a nice choice!");
        } else if (weapon.equalsIgnoreCase("mace")) {
            System.out.println("A mace if a fine choice");
        } else {
            throw new Exception("An a oop! Invalid weapon.");
        }
    }

    public void chooseLocation() throws Exception {

        System.out.println("Choose your location [forest/tunnel]");
        location = Game.scanner.nextLine();

        if (location.equalsIgnoreCase("forest")) {
            System.out.println("Entering forest...");
        } else if (location.equalsIgnoreCase("tunnel")) {
            System.out.println("Entering tunnel...");
        } else {
            throw new Exception("An a oop! Invalid location.");
        }
    }

    public void findItem(String item) {
        System.out.println("New item found! Would you like to pick it up [y/n]");
        String response = Game.scanner.nextLine();

        if (response.equalsIgnoreCase("y")) {
            items.add(item);
            System.out.println("You picked up an item");
        }
    }
}
