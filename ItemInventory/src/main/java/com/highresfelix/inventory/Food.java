package main.java.com.highresfelix.inventory;

/**
 * created by @highresfelix on 8/30/19
 */

public class Food extends InventoryItem {
    public Food(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
        this.category = "Food";
    }
}
