package main.java.info.highresfelix.people;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 9/18/19
 */

public class Main {
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readFile();

        Spark.init(); // http://localhost:4567

        Spark.get(
                "/",
                ((request, response) -> {

                    HashMap hashMap = new HashMap();
                    ArrayList<Person> list = new ArrayList<>();

                    for (Person person : people) {
                        list.add(person);
                    }

                    // TODO limit view to 20
                    // when server issue resolved, resume assignments 4.3-paging
                    /*for (int i = 0; i <= 20; i++) {
                        list.add(people.get(i));
                    }*/

                    hashMap.put("people", list);
                    return new ModelAndView(hashMap, "home.html");
                }),
                new MustacheTemplateEngine()
        );

        // TODO display all the data about a single person
        Spark.get(
                "/person",
                ((request, response) -> {

                    HashMap hashMap = new HashMap();
                    ArrayList<Person> list = new ArrayList<>();


                    hashMap.put("people", list);
                    return new ModelAndView(hashMap, "home.html");
                }),
                new MustacheTemplateEngine()
        );
    }

    private static void readFile() throws FileNotFoundException {

        // read all the people into memory
        File file = new File("people.csv");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
            people.add(person);
        }
    }
}