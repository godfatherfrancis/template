package main.java.com.highresflix.helloworld;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/30/19
 */

public class ReadWriteFile {
    public static void main(String[] args) throws IOException {
        File file = new File("names.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Alice\n"); // overwrites file
        fileWriter.append("Bob\n");
        fileWriter.append("Charlie\n");
        fileWriter.close();

        // read line-by-line
        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }

        // read entire file
        scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);
    }
}
