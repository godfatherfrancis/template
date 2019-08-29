package main.java.com.highresfelix.bankrun;

import java.util.HashMap;

/**
 * created by @highresfelix on 8/26/19
 */

public class Bank {
    HashMap<String, Double> accounts = new HashMap<>();

    public Bank() {

    }

    public Bank(String customer) {
        accounts.put(customer, 10000.0);
    }

    public void addAccount(String customer) {
        accounts.put(customer, 0.0);
    }

    public void removeAccount(String customer) {
        accounts.remove(customer);
    }

    public boolean verifyCustomer(String customer) {
        if (accounts.containsKey(customer)) {
            return true;
        } else {
            return false;
        }
    }

    public double getCustomerBalance(String customer) {

        //
        return accounts.get(customer);
    }
}
