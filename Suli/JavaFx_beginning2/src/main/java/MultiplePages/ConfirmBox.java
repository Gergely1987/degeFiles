package MultiplePages;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;
    public static boolean display(String title,String message){
        Stage window=new Stage();
        //amíg ezt nem zárjuk be a többi oldal nem elérhető
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(250);
        Label label=new Label();
        label.setText(message);


        Button yesButton=new Button("yes");
        Button noButton=new Button("no");

        yesButton.setOnAction(e-> {
            answer=true;
            window.close();
            System.out.println(answer);
        });

        noButton.setOnAction(e-> {
            answer=false;
            window.close();
            System.out.println(answer);
        });

        VBox layout=new VBox(100);
        layout.getChildren().addAll(label,noButton,yesButton);
        layout.setAlignment(Pos.CENTER_RIGHT);

        Scene scene=new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}