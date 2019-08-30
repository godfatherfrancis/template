package main.java.com.highresfelix.inventory;

/**
 * created by @highresfelix on 8/29/19
 */

public class Stocker {
    String name;
    String password;
    Inventory inventory = new Inventory();

    public Stocker() {

    }

    public Stocker(String user, String password) {
        this.name = user;
        this.password = password;
    }

    public void loadInventory() {
        inventory.preload();
    }

    public void login() {
        System.out.println("What's your name?");
        name = ItemTracker.scanner.nextLine();

        if (name.equalsIgnoreCase("")) {
            System.out.println("Invalid entry! Enter name again");
            login();
        } else {
            System.out.println("What would you like to do?");
            listAccess();
        }
    }

    public void listAccess() {
        loadInventory();
        while (true) {
            System.out.println("1. Create item" +
                    "\n2. Remove item" +
                    "\n2. Update item" +
                    "\n3. List items" +
                    "\n4. Logout/exit");

            int response = Integer.parseInt(ItemTracker.scanner.nextLine());

            switch (response) {
                case 1: createItem();
                    break;
                case 2: removeItem();
                    break;
                case 3: updateItem();
                    break;
                case 4: listItems();
                    break;
                case 5: exit();
                    break;
                default: System.out.println("Invalid option");
                    break;
            }
        }
    }

    private void createItem() {
        System.out.println("Enter your to-do item:");
        String text = ItemTracker.scanner.nextLine();

        System.out.println("Enter the quantity of " + text + ":");
        int quantity = Integer.parseInt(ItemTracker.scanner.nextLine());

        inventory.addItem(text, quantity);
    }

    private void removeItem() {
        // TODO can verify existing item
        System.out.println("Enter item to remove from inventory:");
        String itemName = ItemTracker.scanner.nextLine();
        inventory.removeItem(itemName);
    }

    private void updateItem() {
        listItems();
        // TODO can verify existing item
        System.out.println("Enter item name to update quantity:");
        String itemName = ItemTracker.scanner.nextLine();

        System.out.println("Enter updated quantity:");
        int itemQuantity = Integer.valueOf(ItemTracker.scanner.nextLine());

        inventory.updateItem(itemName, itemQuantity);
    }

    private void listItems() {
        inventory.listItems();
    }

    public void exit() {
        System.out.println("Goodbye.");
        System.exit(0);
    }
}
