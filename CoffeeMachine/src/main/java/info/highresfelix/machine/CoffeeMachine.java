package main.java.info.highresfelix.machine;

import java.util.Scanner;

/**
 * created by @highresfelix on 9/10/19
 */

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Write how many ml of water the coffee machine has:");
        int water = scanner.nextInt();

        System.out.print("Write how many ml of almond milk the coffee machine has:");
        int milk = scanner.nextInt();

        System.out.print("Write how many grams of coffee beans the coffee machine has:");
        int coffeeBeans = scanner.nextInt();

        System.out.print("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();

        coffeeRequest(water, milk, coffeeBeans, cupsOfCoffee);
//        makeCoffee();
    }

    private static void coffeeRequest(int water, int milk, int coffeeBeans, int cupsOfCoffee) {
        // calculate the amount of ingredients the machine needs depending on how much coffee requested
        // recipe for one cup of coffee
        /*int waterRecipe = 200;
        int milkRecipe = 50;
        int coffeeBeansRecipe = 15;

        int waterNeeded = waterRecipe * cupsOfCoffee;
        int almondMilkNeeded = milkRecipe * cupsOfCoffee;
        int beansNeeded = coffeeBeansRecipe * cupsOfCoffee;

        System.out.println(String.format("For %d cups of coffee you will need:\n" +
                "%d ml of water\n%d ml of almond milk\n%d g of coffee beans",
                cupsOfCoffee, waterNeeded, almondMilkNeeded, beansNeeded));*/


        // estimate how many coffees the machine can make based on the amount of ingredients entered
        water /= 200; // % or /= returns remainder
        milk /= 50;
        coffeeBeans /= 15;

        // find lowest remaining value
        int min = Math.min(water, milk);
        min = Math.min(coffeeBeans, min);

        if (cupsOfCoffee == min) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (cupsOfCoffee < min) {
            System.out.println("Yes, I can make that amount of coffee (and even " + (min - cupsOfCoffee) + " more than that)");
        } else {
            System.out.println("No, I can make only " + min + " cup(s) of coffee");
        }
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
