
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class StoreDAO {

    private List <Product> listOfProduct = new ArrayList<Product>();

    public StoreDAO(){
        loadTXT();
    }

    public void loadTXT(){
        try{
            BufferedReader br = new BufferedReader(new FileReader(new File("products.txt")));
            String line = br.readLine();
           
            while (line != null) {
                
                String nameOfProduct = "";
                Float price = 0;
                ProdactCategory prodactCategory = null;

                String[] productData = line.split("\t");
    
                nameOfProduct = productData[0];
                price = productData[1];
                prodactCategory = productData[2];

                Product newProduct = new Product(nameOfProduct, price, prodactCategory);

                listOfProduct.add(newProduct); 
            }
            br.close();
            
        } catch(IOException e){
            System.out.println("File not found");
        }
    }


    public List <Product> getListOfProducts(){
        return listOfProduct;
    }




}