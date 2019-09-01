package main.java.com.highresfelix.countries;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * created by @highresfelix on 8/31/19
 */

public class Traveler {
    static Country country;
    static HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
    static ArrayList<Country> countriesList = new ArrayList<>();
    static Scanner scanner;

    public static void main(String[] args) throws Exception {
        loadFile();
        userInput();
    }

    static void userInput() {
        
    }

    static void loadFile() throws FileNotFoundException {
        File file = new File("countries.txt");

        scanner = new Scanner(file);

        ArrayList<Country> tempList = new ArrayList<>();

        // read & parse file to temp ArrayList
        while (scanner.hasNext()) {
            String lineValue = scanner.nextLine();
            String countryAbbreviation = lineValue.substring(0,2);
            String countryName = lineValue.substring(3);

            country = new Country(countryAbbreviation, countryName);
            tempList.add(country);
        }

        int keys = 0;
        // iterate through temp ArrayList; add keys
        while (keys < tempList.size()) {
            Country temptCountry = tempList.get(keys);
            String cKey = temptCountry.getName().substring(0, 1); // countryKey: A

            if (!countryMap.containsKey(cKey)) {
                for (Country country : tempList) {
                    if (country.getName().startsWith(cKey.toLowerCase())) {
                        countriesList.add(country);
                    }
                }

                countryMap.put(cKey, countriesList);
                countriesList = new ArrayList<>();
            }
            keys++;
        }
    }

    static void saveFile(String userKey, ArrayList<Country> arrayList) throws IOException {
        File file = new File(userKey + "_countries.txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(arrayList.toString());
        fileWriter.close();
    }
}
