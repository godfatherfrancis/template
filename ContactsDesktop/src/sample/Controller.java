package sample;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    ObservableList<Contact> contacts = FXCollections.observableArrayList();

    @FXML
    TextField name;

    @FXML
    TextField phoneNum;

    @FXML
    TextField email;

    @FXML
    ListView listView;

    public void addContact() throws IOException {
        if (!name.getText().isBlank() && !phoneNum.getText().isBlank() && !email.getText().isBlank()) {
            contacts.add(new Contact(name.getText(), phoneNum.getText(), email.getText()));
            name.setText("");
            name.setPromptText("Name");
            phoneNum.setText("");
            phoneNum.setPromptText("Phone #");
            email.setText("");
            email.setPromptText("Email");

            System.out.println("addContact");
            saveContacts();
        } else {
            System.out.println("addContact failed");
        }
    }

    public void removeContact() throws IOException {
        Contact contact = (Contact)  listView.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        System.out.println("removeContact");
        saveContacts();
    }

    public void saveContacts() throws IOException {
        System.out.println(contacts);
        File file = new File("contacts.json");

        Gson gson = new Gson();
        String json = gson.toJson(contacts);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
        System.out.println("saveContacts");
    }

    public ObservableList<Contact> loadContacts() throws FileNotFoundException {
        File file = new File("contacts.json");
        Scanner scanner = new Scanner(file);

        Gson gson = new Gson();

        Type userListType = new TypeToken<ArrayList<Contact>>(){}.getType();

        ArrayList<Contact> contactArray = gson.fromJson(scanner.nextLine(), userListType);
        ObservableList<Contact> contactsList = FXCollections.observableArrayList();

        for (Contact contact : contactArray) {
            contactsList.add(contact);
            System.out.println(contact);
        }

        return contactsList;
    }

    public void onKeyPressed(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            addContact();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            contacts = loadContacts();
            System.out.println("Contacts loaded successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listView.setItems(contacts);
    }
}
