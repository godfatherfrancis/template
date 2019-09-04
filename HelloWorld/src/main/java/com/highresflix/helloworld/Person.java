package main.java.com.highresflix.helloworld;

/**
 * created by @highresfelix on 8/23/19
 */

public class Person {
    String name;
    int age;
    boolean isAlive;

    public Person() {

    }

    public Person(String name, int age, boolean isAlive) {
        this.name = name;
        this. age = age;
        this.isAlive = isAlive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
