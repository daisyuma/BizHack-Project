import java.util.ArrayList;

public class BlueShirt {
    private ArrayList<Customer> customers;
    private ArrayList<Product> products;

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
        System.out.println("Do you need assistance?");
    }

    public void askProduct(){
        System.out.println("What type of product are you looking for?");
    }

    public ArrayList<Product> filterProduct(String answer){
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
                    System.out.println("laptop added");
                    break;
                case CELLPHONES:
                    if(answer.equals("cellphone"))
                        matchingProducts.add(p);
                    System.out.println("cell added");
                    break;
                default:
                    System.out.println("please choose again");
                    break;
            }
        }
        return matchingProducts;
    }
    public void askPurpose(String product){
        System.out.println("what are you doing with your " + product);
    }

    public ArrayList<Product> filterCustomerGroup(ArrayList<Product> productList, String answer){
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
                case RELAX:
                    if(answer.equals("relax"))
                        matchingProducts.add(p);
                    break;
                case GAMER:
                    if(answer.equals("game"))
                        matchingProducts.add(p);
                default:
                    System.out.println("please choose again");
                    break;
            }
        }
        return matchingProducts;
    }

    public ArrayList<Product> filterPrice(ArrayList<Product> list, double priceRange){
        ArrayList<Product> matchingProducts = new ArrayList<>();
        for(Product p:list){
            double price = p.getPrice();
            if(priceRange<price){
                matchingProducts.add(p);
            }
        }
        return matchingProducts;
    }

    public void presentProductChoice(ArrayList<Product> list){
        for(Product p:list){
            String name = p.getName();
            double price = p.getPrice();
            String description = p.getDescription();
            System.out.println("we recommend" + name + " ; " + price + " $ " + " ; " + description);
        }
    }

}
