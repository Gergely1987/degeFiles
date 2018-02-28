import javafx.application.Application;
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

//how to jump between sceenes

public class Java_Beginning2 extends Application {

    Stage window;
    Scene scene1,scene2,scene3;


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;

        Label label1=new Label("Welcome to the first scene!");
        Button button1=new Button("Go to scene 2");
        button1.setOnAction(e->window.setScene(scene2));

        //layout1
        VBox layout1=new VBox(3);
        layout1.getChildren().addAll(label1,button1);
        scene1=new Scene(layout1,200,200);
        window.setTitle("Ugrálunk az ablakok között1");

        Button button2=new Button("This scene sucks, go back to scene 1");
        button2.setLayoutX(30);
        button2.setLayoutY(30);
        button2.setOnAction(e->window.setScene(scene1));



        //layout2
        StackPane layout2=new StackPane();
        layout2.getChildren().add(button2);
        scene2=new Scene(layout2, 400,300);

        Button button3=new Button("this goes to 3rd panel");
        button3.setOnAction(e->window.setScene(scene3));
        button3.setLayoutY(30);
        button3.setLayoutX(100);

        layout2.getChildren().add(button3);

        StackPane layout3=new StackPane();
        Button button4=new Button("back to the Second panel");
        Button button5=new Button("back to the First panel");
        layout3.getChildren().add(button4);
        layout3.getChildren().add(button5);
        button4.setOnAction(e->window.setScene(scene2));
        button5.setOnAction(e->window.setScene(scene1));
        button4.setLayoutX(30);
        button4.setLayoutY(40);
        button5.setLayoutX(150);
        button5.setLayoutY(40);

        scene3=new Scene(layout3,500,400);
        window.setScene(scene1);
        window.setTitle("Ugrálunk az ablakok között2");
        window.show();
    }
}
