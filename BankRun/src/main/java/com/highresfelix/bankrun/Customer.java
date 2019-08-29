package main.java.com.highresfelix.bankrun;

/**
 * created by @highresfelix on 8/26/19
 */

public class Customer {
    String name;
    double balance = 0;
    double withdraw;
    double deposit;
    double total = 0;

    Bank bank = new Bank("Felix"); // default account for testing

    public void chooseName() throws Exception {
        System.out.println("What's your name?");
        name = ATM.scanner.nextLine();

        if (name.equalsIgnoreCase("")) {
            System.out.println("Invalid entry! Enter name again");
            chooseName();
        } else if (bank.verifyCustomer(name)) {
            System.out.println("Welcome back, " + name);
            loadSession();
        } else {
            System.out.println("Would you like to open an account with us today [y/n]");
            String responce = ATM.scanner.nextLine();
            if (responce.equalsIgnoreCase("y")) {
                System.out.println("Welcome, " + name);
                bank.addAccount(name);
                loadSession();
            } else {
                userLogout();
            }
        }
    }

    public void loadSession() {
        total = bank.getCustomerBalance(name);
    }

    public void accountAccess() throws Exception {
        System.out.println("\nWhat would you like to do today?");
        System.out.println("" +
                "[1] Check Balance\n" +
                "[2] Withdraw\n" +
                "[3] Deposit\n" +
                "[4] Deactivate Account\n" +
                "[5] Logout\n" +
                "[6] Exit");
        int response = Integer.parseInt(ATM.scanner.nextLine());

        switch (response) {
            case 1: getBalance();
            case 2: withdraw();
            case 3: deposit();
            case 4: removeCustomerAccount();
            case 5: userLogout();
            case 6: exit();
        }
    }

    public void getBalance() throws Exception {
        System.out.println("Your current balance: $" + total);
        accountAccess();
    }

    public void withdraw() throws Exception {
        System.out.println("Enter Withdraw amount: ");
        withdraw = Double.parseDouble(ATM.scanner.nextLine());
        if (withdraw > total) {
            System.out.println("Insufficient Funds.");
        } else {
            total = total - withdraw;
            System.out.println("Please take money below.");
        }
        accountAccess();
    }

    public void deposit() throws Exception {
        System.out.println("Enter Deposit amount: ");
        deposit = Double.parseDouble(ATM.scanner.nextLine());
        if (deposit > 0) {
            total = total + deposit;
            System.out.println("Your funds have been deposited");
        } else {
            System.out.println("Invalid amount!");
            deposit();
        }
        accountAccess();
    }

    public void removeCustomerAccount() throws Exception {
        // maybe return customer funds upon removal but did they read the "terms & agreements"?
        bank.removeAccount(name);
        exit();
    }

    public void userLogout() throws Exception {
        System.out.println("Thank you and please come again.");
        chooseName();
    }

    public void exit() {
        System.out.println("Thank you and please come again.");
        System.exit(0);
    }
}
