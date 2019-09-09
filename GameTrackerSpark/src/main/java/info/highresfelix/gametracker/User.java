package main.java.info.highresfelix.gametracker;

import java.util.ArrayList;

/**
 * created by @highresfelix on 9/9/19
 */

public class User {
    String name;
    ArrayList<Game> games = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }
}
