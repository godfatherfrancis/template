package main.java.com.highresfelix.person;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 9/4/19
 */

public class PersonMapper {
    static HashMap<String, ArrayList<Person>> personMap = new HashMap<>();
    static ArrayList<Person> people = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        System.out.println(personMap);
    }

    private static void readFile() throws FileNotFoundException {
        ArrayList<Person> tempPeopleList = new ArrayList<>();

        // read all the people into memory
        File file = new File("people.csv");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            Person person = new Person(Integer.parseInt(columns[0]), columns[1], columns[2], columns[3], columns[4], columns[5]);
            tempPeopleList.add(person);
        }

        int index = 0;
        // map country name to a list of ppl from that country
        while (index <= tempPeopleList.size()-1) {
            Person tempPerson = tempPeopleList.get(index);
            String countryKey = tempPerson.getCountry();

            if (!personMap.containsKey(countryKey)) {
                for (Person person : tempPeopleList) {
                    if (person.getCountry().equals(countryKey)) {
                        people.add(person);
                    }
                }
                Collections.sort(people);
                personMap.put(countryKey, people);
                people = new ArrayList<>();
            }
            index++;
        }
    }

    private static void writeToJson() {
        File file = new File("people.json");

    }
}
