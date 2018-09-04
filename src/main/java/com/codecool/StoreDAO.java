
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;
import java.io.FileWriter;


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
                ProductCatgory prodactCatgory = null;

                String[] productData = line.split("\t");
    
                nameOfProduct = productData[0];
                price = Float.valu productData[1];
                prodactCatgory = productData[2];

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

    public void exportToTXT(){
        
        for ( int i = 0; i <listOfProduct.size(); i++  ){
            
            Product tempProduct = listOfProduct.get(i);

            String tempName = tempProduct.getName();
            Float tempprice = tempProduct.getPrice();
            ProductCatgory tempProdactCatgory = tempProduct.getProdactCatgory();

            String str = tempName + String.valueOf(tempprice) + tempProdactCatgory.getProdactCatgory();

            try {
                
                File newTextFile = new File("products.txt");
                FileWriter fw = new FileWriter(newTextFile);
                fw.write(str);
                fw.close();
    
            } catch (IOException iox) {
                //do stuff with exception
                iox.printStackTrace();
            }



        }
       


    }





}