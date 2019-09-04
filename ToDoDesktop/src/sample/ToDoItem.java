package sample;

/**
 * created by @highresfelix on 9/4/19
 */

public class ToDoItem {
    String text;
    boolean isDone;

    public ToDoItem(String text) {
        this.text = text;
        this.isDone = false;
    }

    @Override
    public String toString() {
        return text + (isDone ? " (done)" : "");
    }
}
