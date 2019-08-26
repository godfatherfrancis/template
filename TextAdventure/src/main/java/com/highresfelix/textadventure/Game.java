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
    }
}
