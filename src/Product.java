import com.sun.tools.doclets.internal.toolkit.util.ClassUseMapper;

enum ProductType{
    CELLPHONES, HOME_APPLIANCES, LAPTOP, CAMERA, OFFICE_SUPPLIES, OTHER;
}
enum CustomerGroup {
    STUDENT, OFFICE, GAMER, EVERYDAY;
}
public class Product {
    ProductType type;
    String name;
    double price;
    CustomerGroup customerGroup;
    String description;

    public Product(ProductType type, double price, CustomerGroup customerGroup, String name){
        this.type = type;
        this.price = price;
        this.customerGroup = customerGroup;
        this.name = name;
    }

    public void setDescription(String s){
        description = s;
    }

    public void setType(ProductType type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setCustomerGroup(CustomerGroup customerGroup) {
        this.customerGroup = customerGroup;
    }


    public double getPrice(){
        return this.price;
    }

    public ProductType getType(){
        return type; //stub
    }

    public String getName(){
        return this.name;
    }

    public CustomerGroup getCustomerGroup(){
        return customerGroup;
    }

    public String getDescription(){
        return description;
    }




    //REQUIRES: percentage is positive
    //MODIFIES: this.price
    //EFFECT: apply discount on the price of this product
    public void discount(int percentage){

    }


}
