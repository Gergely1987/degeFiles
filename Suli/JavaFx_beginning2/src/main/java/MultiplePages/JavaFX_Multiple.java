package MultiplePages;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
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

public class JavaFX_Multiple extends Application {

    Stage window;
    Button button, button1;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Multiple pages");

        button = new Button("Click to another Stage");
        button.setOnAction(e -> ConfirmBox.display("Modál ablak", "Wow it is working"));

        button1=new Button("close");
        button1.setAlignment(Pos.BOTTOM_CENTER);
        button1.setOnAction(e->closeProgram());
        StackPane layout = new StackPane();
        layout.getChildren().addAll(button, button1);
        layout.setAlignment(Pos.CENTER_LEFT);
        Scene scene1 = new Scene(layout, 400, 400);

        window.setOnCloseRequest(
                e->{
                    e.consume();
                    closeProgram();
                });
        window.setScene(scene1);
        window.show();
    }

    private void closeProgram() {
        Boolean answer=ConfirmBox.display("Title", "sure you want to exit?");
        if(answer){
            window.close();
        }
    }

}
