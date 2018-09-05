package com.codecool;



import java.util.*;
import java.io.*;
import java.io.File;


public class StoreDAO {

    private Product newProduct;
    private List <Product> listOfProduct = new ArrayList<Product>();
    private ProductCategory tempProductCategory;
    
    public StoreDAO(){
        loadTXT();
    }

    public void loadTXT(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream("/" + "products.txt"), "UTF-8"));
            String line = null;

            HashSet<String> listOfcategory = new HashSet<String>(0);

            while ((line = br.readLine()) != null) {
            
                String[] productData = line.split("-");
        
                String nameOfProduct = productData[0];
                Float price = Float.valueOf(productData[1]);
                String categoryOfProduct = productData[2];
             
                String tempName = "";
 
                if ( !listOfcategory.contains(categoryOfProduct) ){
                    ProductCategory tempProductCategory = new ProductCategory(categoryOfProduct);
                    Product newProduct = new Product(nameOfProduct, price, tempProductCategory);
                    listOfProduct.add(newProduct);
                    listOfcategory.add(categoryOfProduct);
                }else{
                    for ( int i = 0; i < ProductCategory.getProductCategoryList().size(); i++  ){
                        // System.out.println(ProductCategory.getProductCategoryList().size());
                        if ( ProductCategory.getProductCategoryList().get(i).getName().equals(categoryOfProduct)   ){
                            newProduct = new Product(nameOfProduct, price, (ProductCategory.getProductCategoryList().get(i)));
                            listOfProduct.add(newProduct);
                        }
                    }
                }
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
        StringBuilder sBuilder = new StringBuilder();
        for ( int i = 0; i <listOfProduct.size(); i++  ){
            Product tempProduct = listOfProduct.get(i);
            String tempName = tempProduct.getName();
            Float tempprice = tempProduct.getPrice();
            String tempProdactCategory = tempProduct.getProductCategory().getName();
            String str = tempName +"\t"+ String.valueOf(tempprice) +"\t"+ tempProdactCategory;
            sBuilder.append(str);
            sBuilder.append("\n");
        }
        String fullTExt = sBuilder.toString();
        try {
            FileWriter fw = new FileWriter("products.txt");
            fw.write(fullTExt);
            fw.close();
        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public String toString(){
        String daoString = "";
        int index = 1;
        for ( Product product : listOfProduct ){
            String temString = product.toString();
            daoString += index+ " "+temString + "\n";
            index++;
        }
        return daoString;
    }

}