package main.java.com.highresfelix.bankrun;

/**
 * created by @highresfelix on 8/26/19
 */

public class Customer {
    String name;
    double balance = 100;
    double withdraw;
    static double total;

    public void chooseName() throws Exception {
        total = balance;
        System.out.println("What's your name?");
        name = Bank.scanner.nextLine();
        if (name.equalsIgnoreCase("")) {
            throw new Exception("Invalid entry");
        } else {
            System.out.println("Welcome, " + name);
        }
    }

    public void accountAccess() throws Exception {
        System.out.println("What would you like to do today?");
        System.out.println("" +
                "[1] Check Balance\n" +
                "[2] Withdraw\n" +
                "[3] Cancel");
        int response = Integer.parseInt(Bank.scanner.nextLine());

        switch (response) {
            case 1: getBalance();
            case 2: withdraw();
            case 3: cancel();
        }
    }

    public void getBalance() throws Exception {
        System.out.println("Your current balance: $" + total);
        accountAccess();
    }

    public void withdraw() throws Exception {
        System.out.println("Enter Withdraw amount: ");
        withdraw = Double.parseDouble(Bank.scanner.nextLine());
        if (withdraw > total) {
            throw new Exception("Insufficient Funds.");
        } else {
            total = total - withdraw;
            System.out.println("Please take money below.");
        }
        accountAccess();
    }

    public void cancel() {
        System.out.println("Thank you and please come again.");
        System.exit(1);
    }
}
