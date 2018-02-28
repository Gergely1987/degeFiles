package MultiplePages;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import com.sun.org.apache.xpath.internal.SourceTree;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.awt.*;
import java.util.Arrays;
import javafx.scene.control.Label;

public class AlertBox {

    public static void display(String title,String message){
        Stage window=new Stage();

        //amíg ezt nem zárjuk be a többi oldal nem elérhető
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);

        Label label=new Label();
        label.setText(message);
        Button closeButton=new Button("close Button");
        closeButton.setOnAction(e->window.close());

        VBox layout=new VBox(100);
        layout.getChildren().addAll(label,closeButton);
        layout.setAlignment(Pos.CENTER_RIGHT);

        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }
}








