package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

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

    public void addContact() {
        contacts.add(new Contact(name.getText(), phoneNum.getText(), email.getText()));
        name.setText("");
        name.setPromptText("Name");
        phoneNum.setText("");
        phoneNum.setPromptText("Phone #");
        email.setText("");
        email.setPromptText("Email");
        System.out.println("addContact");
    }

    public void removeContact() {
        Contact contact = (Contact)  listView.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        System.out.println("removeContact");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.setItems(contacts);
    }
}
