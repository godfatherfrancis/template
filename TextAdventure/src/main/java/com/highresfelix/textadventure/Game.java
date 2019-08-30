package main.java.com.highresfelix.textadventure;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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

    public static void saveGame() throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.include("*").serialize(playerOne);

        File file = new File("game.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
    }

    public static Player loadGame() throws FileNotFoundException {
        File file = new File("game.json");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        return parser.parse(contents, Player.class);
    }
}
