package sample;

import com.google.gson.Gson;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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
        File file = new File("contacts.json");

        /*JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(contacts);*/ // json is empty

        Gson gson = new Gson();
        String json = gson.toJson(contacts);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(json);
        fileWriter.close();
        System.out.println("saveContacts");
    }

    public void loadContacts() {

    }

    public void onKeyPressed(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            addContact();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(contacts);
    }
}
