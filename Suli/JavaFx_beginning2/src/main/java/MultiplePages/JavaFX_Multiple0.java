package MultiplePages;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class JavaFX_Multiple0 extends Application {

    Stage window;
    Button button;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Multiple pages");

        button = new Button("Click to another Stage");
        button.setOnAction(e -> AlertBox.display("Modál ablak", "Wow it is working"));

        StackPane layout = new StackPane();
        layout.getChildren().add(button);
        layout.setAlignment(Pos.CENTER_LEFT);
        Scene scene1 = new Scene(layout, 400, 400);

        window.setScene(scene1);
        window.show();
    }

}
