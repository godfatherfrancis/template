package main.java.com.highresfelix.textadventure;

import java.util.ArrayList;

/**
 * created by @highresfelix on 8/26/19
 */

public class Player extends Character {
    String weapon;
    String location;
    ArrayList<String> items = new ArrayList<>();

    // constructor
    public Player() {
        this.health = 20;
        this.damage = 20;
    }

    public void chooseName() {
        System.out.println("What is your name?");

        name = Game.nextLine();
        System.out.printf("Welcome, %s\n", name);
    }

    public void chooseWeapon() throws Exception {
        System.out.println("Choose your weapon [sword/mace]");
        weapon = Game.nextLine();

        if (weapon.equalsIgnoreCase("sword")) {
            System.out.printf("A %s is a nice choice!", weapon);
        } else if (weapon.equalsIgnoreCase("mace")) {
            System.out.printf("A %s is a fine choice!", weapon);
        } else {
            throw new Exception("An a oop! Invalid weapon.");
        }
    }

    public void chooseLocation() throws Exception {

        System.out.println("Choose your location [forest/tunnel]");
        location = Game.nextLine();

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
        String response = Game.nextLine();

        if (response.equalsIgnoreCase("y")) {
            items.add(item);
            System.out.println("You picked up an item");
        }
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
