package main.java.com.highresfelix.bankrun;

import java.util.Scanner;

/**
 * created by @highresfelix on 8/26/19
 */

public class ATM {
    public static Scanner scanner = new Scanner(System.in);
    public static Customer customer = new Customer();

    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Cash Money Inc.");
        customer.chooseName();
        customer.accountAccess();

    }

}
