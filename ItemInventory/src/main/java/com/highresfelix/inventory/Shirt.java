package main.java.com.highresfelix.inventory;

/**
 * created by @highresfelix on 8/30/19
 */

public class Shirt extends InventoryItem {
    public Shirt(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.category = "Shirt";
    }
}
