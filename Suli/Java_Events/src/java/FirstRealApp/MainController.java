package java.FirstRealApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.util.Random;


public class MainController {

    private Main main;

    @FXML
    private Label myMessage;

    public void generateRandom(ActionEvent event) {
        Random random = new Random();
        int a = random.nextInt();
        myMessage.setText(Integer.toString(a));
        System.out.println(a);
    }


    @FXML
    public void goToNewPage(ActionEvent event) throws IOException {
        System.out.println("alma");
        Parent newPage = FXMLLoader.load(getClass().getResource("/java/FirstRealApp/NewWindow.fxml"));
        Scene newPageScene = new Scene(newPage);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(newPageScene);
        stage.show();

    }



}
