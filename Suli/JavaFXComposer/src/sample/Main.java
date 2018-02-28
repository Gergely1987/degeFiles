package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }
    public void pressButton(ActionEvent event){
        System.out.println("sikerült");
    }

    public void closeButton(ActionEvent event) throws IOException {
      Parent root =FXMLLoader.load(getClass().getResource("Orszagok.fxml"));
      Scene scene=new Scene(root);
      

    }

    public static void main(String[] args) {
        launch(args);
    }
}
