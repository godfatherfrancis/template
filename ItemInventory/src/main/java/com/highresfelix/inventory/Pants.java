package main.java.com.highresfelix.inventory;

/**
 * created by @highresfelix on 8/30/19
 */

public class Pants extends InventoryItem {
    public Pants(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.category = "Pants";
    }
}
