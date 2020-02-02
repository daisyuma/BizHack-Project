import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ProductSuggestionBox {
    public static void displayProductChoice(ArrayList<Product> products){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(250);

        Text text = new Text();
        String textString = "";
        for(Product p:products){
            String name = p.getName();
            double price = p.getPrice();
            String description = p.getDescription();
            textString = name + " ; " + price + " $ " + " ; " + description + "\n";
        }
        text.setText("we recommend: \n" + textString);
        VBox layout = new VBox(10);
        layout.getChildren().addAll(text);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout, 200, 200);
        window.setScene(scene);
        window.showAndWait();
    }
}
