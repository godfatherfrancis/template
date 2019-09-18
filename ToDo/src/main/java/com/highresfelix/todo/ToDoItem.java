package main.java.com.highresfelix.todo;

/**
 * created by @highresfelix on 8/28/19
 */

public class ToDoItem {
    public int id;
    public String text;
    public boolean isDone;

    public ToDoItem(String text, boolean isDone) {
        this.text = text;
        this.isDone = isDone;
    }

    public ToDoItem(int id, String text, boolean isDone) {
        this.id = id;
        this.text = text;
        this.isDone = isDone;
    }
}
