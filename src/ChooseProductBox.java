import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChooseProductBox {
    static String answer;
    public static String display(){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Label label = new Label();
        label.setText("What kind of product are you looking for");
        Button laptopButton = new Button("Laptop");
        Button cameraButton = new Button("Camera");
        laptopButton.setOnAction(e-> {
            answer = "laptop";
            window.close();
        });
        cameraButton.setOnAction(e-> {
            answer = "camera";
            window.close();
        });
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, laptopButton, cameraButton);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
