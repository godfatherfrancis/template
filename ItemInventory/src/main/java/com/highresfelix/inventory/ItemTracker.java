package main.java.com.highresfelix.inventory;

import java.util.Scanner;

/**
 * created by @highresfelix on 8/29/19
 */

public class ItemTracker {
    public static Stocker stocker = new Stocker();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        stocker.login();
    }
}
