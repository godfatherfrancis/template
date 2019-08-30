package main.java.com.highresflix.helloworld;

import java.io.File;
import java.io.IOException;
import java.time.Period;

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
    }
}
