package main.java.com.highresfelix.review;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/30/19
 */

public class ProductReview {
    public static Product product = new Product();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome!");

        try {
            product = loadFile();
            System.out.println("Loading previous review");
            System.out.println(product.toString());

            update();
        } catch (Exception e) {
            product.prompt();
        }

        nextLine();
    }

    public static String nextLine() {
        String nextLine = scanner.nextLine();
        while (nextLine.startsWith("/")) {
            switch (nextLine) {
                case "/update": update();
                    break;
                case "/save":
                    try {
                        saveFile();
                        System.out.println("File saved.");
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

    public static void update() {
        System.out.println("\nWould you like to update information [y/n]");
        String answer = scanner.nextLine();

        switch (answer) {
            case "y":
                product.prompt();
                break;
            case "n":
                System.exit(0);
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }

    public static void saveFile() throws IOException {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(product);

        File file = new File("review.json");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
    }

    public static Product loadFile() throws FileNotFoundException {
        File file = new File("review.json");
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        return parser.parse(contents, Product.class);
    }
}
