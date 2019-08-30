package main.java.com.highresfelix.textadventure;

import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

import static main.java.com.highresfelix.textadventure.Player.loadGame;
import static main.java.com.highresfelix.textadventure.Player.saveGame;

/**
 * created by @highresfelix on 8/26/19
 */

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Player playerOne = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, Traveller");

        try {
            playerOne = loadGame();
            System.out.println("Loaded saved game.");
        } catch (Exception e) {
            System.out.println("Starting new game.");
        }

        if (playerOne.name == null) playerOne.chooseName();
        if (playerOne.weapon == null) playerOne.chooseWeapon();
        if (playerOne.location == null) playerOne.chooseLocation();

        if (playerOne.items.isEmpty()) {
            playerOne.findItem("shield");
            playerOne.findItem("boots");
            playerOne.findItem("belt");
        }

        Enemy egor = new Enemy("Egor", 10, 10);
        playerOne.battle(egor);
    }

    public static String nextLine() {
        String nextLine = scanner.nextLine();
        while (nextLine.startsWith("/")) {
            switch (nextLine) {
                case "/inv":
                    for (String item : playerOne.items) {
                        System.out.println(item);
                    }
                    break;
                case "/save":
                    try {
                        saveGame();
                        System.out.println("Saved game.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case "/exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Command not found!");
                    break;
            }
            nextLine = scanner.nextLine();
        }
        return nextLine;
    }
}
