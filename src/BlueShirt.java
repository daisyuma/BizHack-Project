import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BlueShirt {
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;
    private String file = "./data/products.txt";
    public BlueShirt() {
        customers = new ArrayList<>();
        products = new ArrayList<>();
    }


    //MODIFIES: this
    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void addProduct(Product p){
        this.products.add(p);
    }

    public void askAssistance(){
        System.out.println("Do you need assistance?\nChoose <yes> or <no>.");
    }

    public void processAssistance(boolean response){
        if(response) {
            askProduct();
        }else{
            System.out.println("ok fine");
        }
    }

    public void askProduct(){
        System.out.println("What type of product are you looking for?\nChoose <camera>, <laptop>, or <cellphone>.");
    }

    public ArrayList<Product> processProduct(String answer){
        ArrayList<Product> matchingProducts = new ArrayList<>();
        for(Product p : products){
            ProductType type = p.getType();
            switch(type){
                case CAMERA:
                    if(answer.equals("camera")) {
                        matchingProducts.add(p);
                    }
                    System.out.println("camera added");
                    break;
                case LAPTOP:
                    if(answer.equals("laptop"))
                    matchingProducts.add(p);
//                    System.out.println("laptop added");
                    break;
                case CELLPHONES:
                    if(answer.equals("cellphone"))
                        matchingProducts.add(p);
                    System.out.println("cell added");
                    break;
                default:
                    System.out.println("error");
                    break;
            }
        }
        return matchingProducts;
    }
    public void askPurpose(String t){
        System.out.println("What are you doing with your " + t + "?\nChoose <student>, <office>, <gamer>, <everyday>");
    }

    public void askPriceRange() {
        System.out.println("What's your price range?\nChoose <400-600>\n<600-800>\n<800-1000>\n<100+>");
    }

    public ArrayList<Product> processCustomerGroup(ArrayList<Product> productList, String answer){
        ArrayList<Product> matchingProducts = new ArrayList<>();
        for(Product p : productList){
            CustomerGroup group = p.getCustomerGroup();
            switch(group){
                case OFFICE:
                    if(answer.equals("office")) {
                        matchingProducts.add(p);
                    }
                    break;
                case STUDENT:
                    if(answer.equals("student"))
                        matchingProducts.add(p);
                    break;
                case EVERYDAY:
                    if(answer.equals("everyday"))
                        matchingProducts.add(p);
                    break;
                default:
                    System.out.println("please choose again");
                    break;
            }
        }
        return matchingProducts;
    }

    public void load() throws IOException {
        System.out.println(Paths.get(file));
        List<String> lines = Files.readAllLines(Paths.get(file));
        for (String line : lines) {
            ArrayList<String> partsOfLine = splitOnBar(line);

            String type = partsOfLine.get(0);
            String price = partsOfLine.get(1);
            String customerGroup = partsOfLine.get(2);
            String name = partsOfLine.get(3);

            loadProduct(type, price, customerGroup, name);
        }
    }

    // EFFECTS: a helper method that splits up words separated by "|"
    public static ArrayList<String> splitOnBar(String line) {
        String[] splits = line.split("\\|");
        return new ArrayList<>(Arrays.asList(splits));
    }

    public void loadProduct(String type, String price, String customerGroup, String name) {
        double doublePrice = Double.parseDouble(price);
        ProductType prodType = ProductType.valueOf(type);
        CustomerGroup custGrp = CustomerGroup.valueOf(customerGroup);
        Product product = new Product(prodType, doublePrice, custGrp, name);
        addProduct(product);
    }



//    //EFFECTS: saves User's entries to a file
//    public void saveProduct() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("./data/outputfile.txt"));
//        for (Product product : products) {
//            String name = product.getName();
//            CustomerGroup group = product.getCustomerGroup();
//            double price = product.getPrice();
//            ProductType type = product.getType();
//            lines.add(name + ";" + group + ";" + price + ";" + type);
//            PrintWriter writer = new PrintWriter("./data/outputfile.txt", "UTF-8");
//            for (String line : lines) {
//                writer.println(line);
//            }
//            writer.close(); //note -- if you miss this, the file will not be written at all.
//        }
//    }
//
//
//    //MODIFIES:this
//    //EFFECTS: load all entries back the entries field of this
//    public User loadProduct() throws IOException {
//        List<String> lines = Files.readAllLines(Paths.get("./data/outputfile.txt"));
//        User myUser = new User();
//        for (String line : lines) {
//            ArrayList<String> partsOfLine = splitOnFirstSpace(line);
//            HealthyEntry entry = new HealthyEntry();
//            String goal = (partsOfLine.get(0));
//            String journal = (partsOfLine.get(1));
//            try {
//                entry.setGoal(goal);
//                entry.setJournal(journal);
//            } catch (InvalidInputException e) {
//                System.out.println("An InvalidInputException is found in the file");
//            }
//            myUser.addEntry(entry);
//        }
//        return myUser;
//    }
//
//
//    //EFFECTS: split a string on the first space encountered by cursor and stores substrings in a collection
//    private static ArrayList<String> splitOnFirstSpace(String line) {
//        ArrayList<String> splitOnFirstSpace = new ArrayList<>();
//        int i = line.indexOf(" ");
//        String goal = line.substring(0, i);
//        String entry = line.substring(i++);
//        splitOnFirstSpace.add(goal);
//        splitOnFirstSpace.add(entry);
//        return splitOnFirstSpace;
//    }
}
