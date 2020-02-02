import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;


public class UI extends Application{
    Button yesButton;
    Button productButton;
    Stage window;
    Scene scene1, scene2;
    Text text = new Text("What type of product are you looking for?");
    private BlueShirt blueShirt = new BlueShirt();
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Product product = new Product(ProductType.LAPTOP, 500, CustomerGroup.OFFICE, "MacBookPro");
        blueShirt.addProduct(product);  //change it to load product
        window = primaryStage;
        Label label = new Label("Welcome to BestBuy");
        window.setTitle("BestBuy");
        yesButton = new Button("yes");
        productButton = new Button("product");
        VBox layout = new VBox(20);
        VBox layout2 = new VBox(20);
        layout2.getChildren().add(productButton);
        layout2.getChildren().add(text);
        layout.getChildren().addAll(yesButton,label);
        yesButton.setOnAction(e -> {
            String answer = ChooseProductBox.display();
            ArrayList<Product> list1 = blueShirt.filterProduct(answer);
            String answer2 = ChoosePurposeBox.display();
            ArrayList<Product> list2 = blueShirt.filterCustomerGroup(list1,answer2);
            blueShirt.presentProductChoice(list2);
        }
        );
        scene1 = new Scene(layout, 200, 200);
        scene2 = new Scene(layout2, 200, 200);

        window.setScene(scene1); //use this scene for our main programme
        window.show(); //display to the user

    }
}
