import java.util.List;
import java.util.ArrayList;

class Product{
    private String name;
    private Float defaultPrice;
    private ProductCategory productCategory;
    private Integer ID;
    private static List<Product> productList = new ArrayList<Product>();

    public Product(){
        
    }

    public Product(String name, Float defaultPrice, ProductCatgory productCategory){
        this.name = name;
        this.defaultPrice = defaultPrice;
        this.productCategory = productCategory;
        ID = generateID();
        productList.add(this);
    }

    private Integer generateID(){
        return productList.size();
    }
}