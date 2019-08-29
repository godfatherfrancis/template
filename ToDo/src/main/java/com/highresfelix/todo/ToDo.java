package main.java.com.highresfelix.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/28/19
 */

public class ToDo {
    public static ArrayList<ToDoItem> items = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) {

        while (true) {
            System.out.println("1. Create to-do item" +
                    "\n2. Toggle to-do item" +
                    "\n3. List to-do items");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1: createItem();
                case 2: toggleItem();
                case 3: listItems();
                default: System.out.println("Invalid option");
            }
        }
    }

    private static void createItem() {
        System.out.println("Enter your to-do item:");
        String text = scanner.nextLine();

        ToDoItem item = new ToDoItem(text, false);
        items.add(item);
    }

    private static void toggleItem() {
        System.out.println("Enter the number of the item(s) you want to toggle:");
        int itemNum = Integer.valueOf(scanner.nextLine());
        ToDoItem item = items.get(itemNum-1);
        item.isDone = !item.isDone;
    }

    private static void listItems() {
        int i = 1;
        for (ToDoItem item : items) {
            String checkbox = "[ ] ";
            if (item.isDone) {
                checkbox = "[x] ";
            }
            System.out.println(checkbox + i + ". " + item.text);
            i++;
        }
    }
}
