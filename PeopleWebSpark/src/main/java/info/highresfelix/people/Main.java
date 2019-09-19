package main.java.info.highresfelix.people;

import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

/**
 * created by @highresfelix on 9/18/19
 */

public class Main {
    static ArrayList<Person> people = new ArrayList<>();
    static int pageIndex = 0;
    static int previousDisplayIndex = 0;
    static int nextDisplayIndex = 20;
    static int personIdNum = 0;

    public static void main(String[] args) throws FileNotFoundException {
        readFile();

        Spark.init(); // http://localhost:4567

        Spark.get(
                "/",
                ((request, response) -> {

                    // display all data of single person selected
                    String personId = request.queryParams("person");
                    if (personId != null) {
                        personIdNum = Integer.parseInt(personId);
                        response.redirect("/person");
                    }

                    HashMap hashMap = new HashMap();
                    ArrayList<Person> list = new ArrayList<>();

                    for (int i = previousDisplayIndex; i < nextDisplayIndex && i < people.size(); i++) {
                        list.add(people.get(i));
                    }

                    hashMap.put("people", list);

                    // TODO: jump to curtain page through url injection
                    // TODO: fix button display when last page reached
                    Set<String> pageDirection = request.attributes();
                    for (String att : pageDirection) {
                        System.out.println(att);
                    }
                    if (pageIndex == 0 || pageIndex == 49) {
                        hashMap.put("pageIndex", null);
                    } else if (pageIndex < 50) {
                        hashMap.put("pageIndex", pageIndex);
                    }
                    return new ModelAndView(hashMap, "home.html");
                }),
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/person",
                ((request, response) -> {

                    HashMap hashMap = new HashMap();
                    ArrayList<Person> list = new ArrayList<>();

                    for (Person person : people) {
                        if (person.getId() == personIdNum) {
                            list.add(person);
                            System.out.println(person);
                        }
                    }

                    hashMap.put("personDetail", list);
                    return new ModelAndView(hashMap, "person.html");
                }),
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/previous",
                ((request, response) -> {

                    pageIndex -= 1;
                    previousDisplayIndex -= 20;
                    nextDisplayIndex -= 20;

                    response.redirect("/");
                    return "";
                })
        );

        Spark.get(
                "/next",
                ((request, response) -> {

                    pageIndex += 1;
                    previousDisplayIndex += 20;
                    nextDisplayIndex += 20;

                    response.redirect("/");
                    return "";
                })
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