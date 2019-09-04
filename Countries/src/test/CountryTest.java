import main.java.com.highresfelix.countries.Country;
import main.java.com.highresfelix.countries.Traveler;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * created by @highresfelix on 9/3/19
 */

public class CountryTest {

    @Test
    public void testCountries() throws FileNotFoundException {
        Traveler traveler = new Traveler();
        Country country = new Country("YE", "yemen");
        HashMap<String, ArrayList<Country>> countryMap = new HashMap<>();
        ArrayList<Country> countriesList = new ArrayList<>();

        File file = new File("countries.txt");
        Scanner scanner = new Scanner(file);
        traveler.parseFile(scanner);

        countriesList.add(country);
        countryMap.put("y", countriesList);
        
        assertTrue(traveler.countryMap.containsKey("y"));
        assertTrue(traveler.countryMap.containsValue(countriesList)); // true but test reads false, why?
    }
}
