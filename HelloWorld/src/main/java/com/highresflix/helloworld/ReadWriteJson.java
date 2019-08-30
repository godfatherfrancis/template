package main.java.com.highresflix.helloworld;

import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Period;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/30/19
 */

public class ReadWriteJson {
    public static void main(String[] args) throws IOException {
        Person person = new Person();
        person.name = "Alice Smith";
        person.age = 30;

        File file = new File("person.json");

        // write json
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(person);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();

        // read json
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        JsonParser parser = new JsonParser();
        Person personTwo = parser.parse(contents, Person.class);

        System.out.println(personTwo);
    }
}
