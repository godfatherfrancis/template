package main.java.info.highresfelix.machine;

import java.util.Scanner;

/**
 * created by @highresfelix on 9/10/19
 */

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();
        coffeeRequest(cupsOfCoffee);
//        makeCoffee();
    }

    private static void coffeeRequest(int cupsOfCoffee) {
        // makes one cup of coffee
        int water = 200;
        int almondMilk = 50;
        int coffeeBeans = 15;
        // calculate request
        int waterNeeded = water * cupsOfCoffee;
        int almondMilkNeeded = almondMilk * cupsOfCoffee;
        int beansNeeded = coffeeBeans * cupsOfCoffee;
        System.out.println(String.format("For %d cups of coffee you will need:\n" +
                "%d ml of water\n%d ml of almond milk\n%d g of coffee beans",
                cupsOfCoffee, waterNeeded, almondMilkNeeded, beansNeeded));
    }

    private static void makeCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready!");
    }
}
