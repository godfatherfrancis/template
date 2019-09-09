package main.java.info.highresfelix.microblog;

import java.util.ArrayList;

/**
 * created by @highresfelix on 9/9/19
 */

public class User {
    String name;
    ArrayList<Message> messages = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}
