package main.java.com.highresfelix.inventory;

import java.util.HashMap;
import java.util.Set;

/**
 * created by @highresfelix on 8/29/19
 */

public class Inventory {
    HashMap<String, Integer> items = new HashMap<>();

    public void addItem(String item, int quantity) {
        items.put(item, quantity);
        System.out.println("[" + items.get(item) + "] " + item);
    }

    public void removeItem(String item) {
        items.remove(item);
        System.out.println("Removed: [" + items.get(item) + "] " + item);
    }

    public void updateItem(String item, int newQuantity) {
        int oldQuantity = items.get(item);
        items.replace(item, oldQuantity, newQuantity);
        System.out.println("[" + items.get(item) + "] " + item);
    }

    public void listItems() {
        Set<String> keys = items.keySet();
        for (String key : keys) {
            System.out.println("[" + items.get(key) + "] " + key);
        }
    }

    public void preload() {
        items.put("Apples", 10);
        items.put("Pears", 5);
        items.put("Bananas", 7);
    }
}
