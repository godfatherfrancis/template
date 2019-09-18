package main.java.com.highresfelix.todo;

import org.h2.tools.Server;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/28/19
 */

public class ToDo {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String args[]) throws SQLException {
        Server.createWebServer().start();
        Connection connection = DriverManager.getConnection("jdbc:h2:./main");
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS todos (id IDENTITY, text VARCHAR, is_done BOOLEAN)");

        while (true) {
            System.out.println("1. Create to-do item" +
                    "\n2. Toggle to-do item" +
                    "\n3. List to-do items");

            int response = Integer.parseInt(scanner.nextLine());

            switch (response) {
                case 1:
                    System.out.println("Enter your to-do item:");
                    String text = scanner.nextLine();

                    /*ToDoItem item = new ToDoItem(text, false);
                    items.add(item);*/
                    insertToDo(connection, text);
                    break;
                case 2:
                    System.out.println("Enter the number of the item(s) you want to toggle:");
                    int itemNum = Integer.valueOf(scanner.nextLine());

                    /*ToDoItem item = items.get(itemNum-1);
                    item.isDone = !item.isDone;*/
                    toggleToDo(connection, itemNum);
                    break;
                case 3:
                    ArrayList<ToDoItem> items = new ArrayList<>();
//                    int i = 1;
                    for (ToDoItem item : items) {
                        String checkbox = "[ ] ";
                        if (item.isDone) {
                            checkbox = "[x] ";
                        }
                        System.out.printf("%s %s. %s\n", checkbox, item.id, item.text);
//                        i++;
                    }
                        break;
                default: System.out.println("Invalid option");
                        break;
            }
        }
    }

    public static void insertToDo(Connection connection, String text) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO todos VALUES (NULL, ?, false)");
        statement.setString(1, text);
        statement.execute();
    }

    public static ArrayList<ToDoItem> selectToDos(Connection connection) throws SQLException {
        ArrayList<ToDoItem> items = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet results = statement.executeQuery("SELECT * FROM todos");
        while (results.next()) {
            int id = results.getInt("id");
            String text = results.getString("text");
            boolean isDone = results.getBoolean("is_done");
            items.add(new ToDoItem(id, text, isDone));
        }
        return items;
    }

    public static void toggleToDo(Connection connection, int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("UPDATE todos SET is_done WHERE id = ?");
        statement.setInt(1, id);
        statement.execute();
    }
}
