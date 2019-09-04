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
    ObservableList<ToDoItem> items = FXCollections.observableArrayList();

    @FXML
    ListView list;

    @FXML
    TextField text;

    public void addItem() {
        items.add(new ToDoItem(text.getText()));
        text.setText("");
        System.out.println("addItem");
    }

    public void removeItem() {
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        items.remove(item);
        System.out.println("removeItem");
    }

    public void toggleItem() {
        ToDoItem item = (ToDoItem) list.getSelectionModel().getSelectedItem();
        if (item != null) {
            item.isDone = !item.isDone;
            list.refresh();
        }
        System.out.println("toggleItem");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        list.setItems(items);
    }
}
