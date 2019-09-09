package main.java.info.highresfelix.gametracker;

/**
 * created by @highresfelix on 9/9/19
 */

public class Game {
    String name;
    String genre;
    String platform;
    int releaseYear;

    public Game(String name, String genre, String platform, int releaseYear) {
        this.name = name;
        this.genre = genre;
        this.platform = platform;
        this.releaseYear = releaseYear;
    }
}
