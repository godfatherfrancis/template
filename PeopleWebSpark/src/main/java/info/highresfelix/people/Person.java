package main.java.info.highresfelix.people;

/**
 * created by @highresfelix on 9/18/19
 */

public class Person implements Comparable<Object> {
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String country;
    private String ip_address;

    Person() {

    }

    Person(String first_name) {
        this.first_name = first_name;
    }

    Person (int id, String first_name, String last_name, String email, String country, String ip_address) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.country = country;
        this.ip_address = ip_address;
    }

    @Override
    public String toString() {
        return this.first_name + " " + this.last_name + " from " + this.country;
    }

    @Override
    public int compareTo(Object o) {
        // sort by last_name
        // TODO sort by first name if the last names are the same
        Person person = (Person) o;
        return last_name.compareTo(person.last_name);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
