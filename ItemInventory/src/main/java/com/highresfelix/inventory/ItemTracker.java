package main.java.com.highresfelix.inventory;

import java.util.Scanner;

/**
 * created by @highresfelix on 8/29/19
 */

public class ItemTracker {
    public static InventoryItem inventory = new InventoryItem();
    public static Stocker stocker = new Stocker();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        stocker.login();
    }

    // TODO return an object using the correct category class (or throws and error for an invalid category name).???
    // TODO createItem to create a new item for option 1.
    // TODO When you list the items, list their category as well.
    static InventoryItem createItem(String name, int quantity, String category) {
        System.out.println("Choose category:" +
                "\n[1] Food" +
                "\n[2] Hat" +
                "\n[3] Shirt" +
                "\n[4] Pants" +
                "\n[5] Shoe");
        int selection = Integer.parseInt(scanner.next());

        if (category.equalsIgnoreCase("shoe")) {
            return new Shoe(name, quantity);
        } else {
            return null;
        }
    }
}
