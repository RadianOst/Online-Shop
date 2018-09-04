package com.codecool;

import java.util.*;
import java.io.*;



public class StoreDAO {

    private Product newProduct;
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
                Float price = Float.valueOf(0);
                String categoryOfProduct = null;

                String[] productData = line.split("\t");
    
                nameOfProduct = productData[0];
                price = Float.parseFloat(productData[1]);
                categoryOfProduct = productData[2];

                List<ProductCategory> tempListProductCategory = ProductCategory.getProductCategoryList();

                String tempName = "";
                for ( int i =0; i <tempListProductCategory.size(); i++ ){
                    tempName =  tempListProductCategory.get(i).getName();
                    if ( tempName != categoryOfProduct ){
                        ProductCategory tempProductCategory = new ProductCategory(categoryOfProduct);
                        newProduct = new Product(nameOfProduct, price, tempProductCategory);
                        listOfProduct.add(newProduct); 
                    }else{
                        ProductCategory tempProductCategory = tempListProductCategory.get(i);
                        newProduct = new Product(nameOfProduct, price, tempProductCategory);
                        listOfProduct.add(newProduct); 
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
            String str = tempName + String.valueOf(tempprice) + tempProdactCategory;
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

}