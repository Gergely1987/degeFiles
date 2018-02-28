package java.FirstRealApp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class NewWindow {

    @FXML
    public void goToMainController(ActionEvent event) throws IOException {
        System.out.println("alma");
        Parent newPage = FXMLLoader.load(getClass().getResource("/java/FirstRealApp/MainController.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(newPage));
        stage.show();

    }

    @FXML
    public void goToModalPage(ActionEvent event) throws IOException {
        System.out.println("alma");
        Parent newPage = FXMLLoader.load(getClass().getResource("/java/FirstRealApp/ModalWindow.fxml"));
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOpacity(1);

        stage.setScene(new Scene(newPage));
        stage.show();


    }
}
