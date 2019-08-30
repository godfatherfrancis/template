package main.java.com.highresfelix.inventory;

/**
 * created by @highresfelix on 8/30/19
 */

public class Hat extends InventoryItem {
    public Hat(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.category = "Hat";
    }
}
