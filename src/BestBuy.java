import java.util.ArrayList;
import java.util.Scanner;

public class BestBuy {
    private static Scanner scanner = new Scanner(System.in);
    private BlueShirt blueShirt = new BlueShirt();

    public BestBuy(){
        Product product = new Product(ProductType.LAPTOP, 500, CustomerGroup.OFFICE, "MacBookPro");
        blueShirt.addProduct(product);  //change it to load product
        blueShirt.askAssistance();
        String answer = scanner.next();
        boolean needAssistance = true;
        if (answer == "y") {
            needAssistance = true;
        } else if (answer == "n") {
            needAssistance = false;
        }
        String productAnswer = scanner.next();
        ArrayList<Product> list = blueShirt.filterProduct(productAnswer);
        blueShirt.askPurpose(productAnswer);
        String purpose = scanner.next();
        ArrayList<Product> list2 = blueShirt.filterCustomerGroup(list,purpose);
        blueShirt.presentProductChoice(list2);
    }
    public static void main(String[] args) {
        new BestBuy();
    }
}
