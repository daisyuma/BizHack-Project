import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product(ProductType.LAPTOP, 500, CustomerGroup.OFFICE, "MacBookPro");
        BlueShirt blueShirt = new BlueShirt();
        blueShirt.addProduct(product);
        blueShirt.askAssistance();
        String answer = scanner.next();
        boolean complete = true;
        if (answer == "y") {
            complete = true;
        } else if (answer == "n") {
            complete = false;
        }
        blueShirt.processAssistance(complete);
        String productAnswer = scanner.next();
        ArrayList<Product> list = blueShirt.processProduct(productAnswer);
        blueShirt.askPurpose(productAnswer);
        String purpose = scanner.next();
        ArrayList<Product> list2 = blueShirt.processCustomerGroup(list,purpose);
        System.out.println("we recommend " + list2.get(0).getName() + "; " + list2.get(0).getPrice() + "$");
    }
}
