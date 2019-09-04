package sample;

/**
 * created by @highresfelix on 9/4/19
 */

public class Contact {
    String name;
    String phoneNum;
    String email;

    public Contact(String name, String phoneNum, String email) {
        this.name = name;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    @Override
    public String toString() {

        return name + ", " + phoneNum + ", " + email;
    }
}
