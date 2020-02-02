import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoosePurposeBox {
    public static String answer;
    public static String display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("What's your purpose");
        Button relaxButton = new Button("Relax");
        Button workButton = new Button("Office");
        relaxButton.setOnAction(e-> {
            answer = "relax";
            window.close();
        });
        workButton.setOnAction(e-> {
            answer = "office";
            window.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, relaxButton, workButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
