package main.java.com.highresfelix.textadventure;

import java.util.Scanner;

/**
 * created by @highresfelix on 8/26/19
 */

public class Game {
    public static Scanner scanner = new Scanner(System.in);
    public static Player playerOne = new Player();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome, Traveller");

        playerOne.chooseName();
        playerOne.chooseWeapon();
        playerOne.chooseLocation();
        playerOne.findItem("shield");
        playerOne.findItem("boots");
        playerOne.findItem("belt");
    }

    public static String nextLine() {
        String nextLine = scanner.nextLine();
        while (nextLine.startsWith("/")) {
            switch (nextLine) {
                case "inv":
                    for (String item : playerOne.items) {
                        System.out.println(item);
                    }
                    break;
                case "exit":
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
