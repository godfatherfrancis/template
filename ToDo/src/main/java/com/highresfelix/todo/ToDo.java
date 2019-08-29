package main.java.com.highresfelix.todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/28/19
 */

public class ToDo {

    public static void main(String args[]) {

        ArrayList<ToDoItem> items = new ArrayList<>();
//        HashMap<String, Boolean> toDoList = new HashMap<String, Boolean>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create to-do item" +
                    "\n2. Toggle to-do item" +
                    "\n3. List to-do items");

            String response = scanner.nextLine();

            if (response.equals("1")) {
                System.out.println("Enter your to-do item:");
                String text = scanner.nextLine();

                ToDoItem item = new ToDoItem(text, false);
                items.add(item);

            } else if (response.equals("2")) {
                System.out.println("Enter the number of the item(s) you want to toggle:");
                int itemNum = Integer.valueOf(scanner.nextLine());
                ToDoItem item = items.get(itemNum-1);
                item.isDone = !item.isDone;

            } else if (response.equals("3")) {
                int i = 1;
                for (ToDoItem item : items) {
                    String checkbox = "[ ] ";
                    if (item.isDone) {
                        checkbox = "[x] ";
                    }
                    System.out.println(checkbox + i + ". " + item.text);
                    i++;
                }

            } else {
                System.out.println("Invalid option");
            }
        }
    }
}
