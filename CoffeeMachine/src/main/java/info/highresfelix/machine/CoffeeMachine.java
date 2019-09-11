package main.java.info.highresfelix.machine;

import java.util.Scanner;

/**
 * created by @highresfelix on 9/10/19
 */

public class CoffeeMachine {
    static int waterSupply;
    static int almondMilkSupply;
    static int coffeeBeansSupply;
    static int cupsOfCoffee;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Write how many ml of water the coffee machine has:");
        waterSupply = scanner.nextInt();
        System.out.print("Write how many ml of almond milk the coffee machine has:");
        almondMilkSupply = scanner.nextInt();
        System.out.print("Write how many grams of coffee beans the coffee machine has:");
        coffeeBeansSupply = scanner.nextInt();
        System.out.print("Write how many cups of coffee you will need:");
        int cupsOfCoffee = scanner.nextInt();
        coffeeRequest(cupsOfCoffee);
//        makeCoffee();
    }

    private static void coffeeRequest(int cupsOfCoffee) {
        // recipe for one cup of coffee
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

        int waterResult = waterSupply % water;
        int recipeWater = waterSupply - waterResult;
        int almondMilkResult = almondMilkSupply % almondMilk;
        int recipeAlmondMilk = almondMilkSupply - almondMilkResult;
        int coffeeBeansResult = coffeeBeansSupply % coffeeBeans;
        int recipeCoffeeBeans = coffeeBeansSupply - coffeeBeansResult;

        int waterUsed = 0;
        int almondMilkUsed = 0;
        int coffeeBeansUsed = 0;
        int makeCupsOfCoffee = 0;
        int additionalCups = 0;
        for (int i = 0; i < cupsOfCoffee; i++) {
            if (waterUsed < recipeWater && almondMilkUsed < recipeAlmondMilk && coffeeBeansUsed < recipeCoffeeBeans) {
                waterUsed += water;
                almondMilkUsed += almondMilk;
                coffeeBeansUsed += coffeeBeans;
                makeCupsOfCoffee++;
            }
        }

        // check if additional cups of coffee can be made with remaining supplies
        // TODO make valid iteration
        for (int i = 0; i < 10000; i++) {
            if (waterUsed < recipeWater && almondMilkUsed < recipeAlmondMilk && coffeeBeansUsed < recipeCoffeeBeans) {
                waterUsed += water;
                almondMilkUsed += almondMilk;
                coffeeBeansUsed += coffeeBeans;
                additionalCups++;
            }
        }

        System.out.println(String.format("\nRecipe can make %d cups of coffee:\n%d ml of water\n%d ml of almond milk\n%d g of coffee beans",
                makeCupsOfCoffee, recipeWater, recipeAlmondMilk, recipeCoffeeBeans));

        if (waterSupply >= waterNeeded && almondMilkSupply >= almondMilkNeeded && coffeeBeansSupply >= beansNeeded) {
            if (additionalCups > 0) {
                System.out.println(String.format("Yes, I can make that amount of coffee (and even %d more than that)", additionalCups));
            } else {
                System.out.println("Yes, I can make that amount of coffee");
            }
        } else {
            System.out.println(String.format("No, I can make only %d cup(s) of coffee", makeCupsOfCoffee));
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
