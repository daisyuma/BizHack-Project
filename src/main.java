import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Product product = new Product(ProductType.LAPTOP, 500, CustomerGroup.OFFICE, "MacBookPro");
        BlueShirt blueShirt = new BlueShirt();
        blueShirt.load();
        blueShirt.addProduct(product);
        blueShirt.askAssistance();      // Do you need assistance? Choose <yes> or <no>.
        String answer = scanner.next();
        if (answer.equals("yes")) {
            blueShirt.processAssistance(true);      // "What type of product are you looking for?\nChoose <camera>, <laptop>, or <cellphone>."
        } else if (answer.equals("no")) {
            blueShirt.processAssistance(false);
        }
        String productAnswer = scanner.next();
        ArrayList<Product> list = blueShirt.processProduct(productAnswer);
        blueShirt.askPurpose(productAnswer);
        String purpose = scanner.next();
        ArrayList<Product> list2 = blueShirt.processCustomerGroup(list,purpose);
        System.out.println("We recommend: \n");
        for (int i = 0; i < list2.size(); i++) {
            Product curr = list2.get(i);
            System.out.println(curr.name + " | " + "$" + curr.price + " | " + curr.customerGroup);
        }
//        System.out.println("we recommend " + list2.get(0).getName() + "; " + list2.get(0).getPrice() + "$");
    }
}
