package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("browser_desktop.fxml"));
        primaryStage.setTitle("Browser Desktop");
        primaryStage.setScene(new Scene(root, 800, 600)); // 300 x 275
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}