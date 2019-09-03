package main.java.com.highresfelix.countries;

/**
 * created by @highresfelix on 8/30/19
 */

public class Country {
    String name;
    String abbreviation;

    public Country(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    @Override
    public String toString() {
        String country = abbreviation + "|" + name;
        return country;
    }
}
