package com.codecool;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
// import org.omg.CORBA.portable.OutputStream;

import com.codecool.Product;

public class StoreDAO {

    private Product newProduct;
    private List <Product> listOfProduct = new ArrayList<Product>();

    
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
                if ( productData.length == 3  ){
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
                            if ( ProductCategory.getProductCategoryList().get(i).getName().equals(categoryOfProduct)   ){
                                newProduct = new Product(nameOfProduct, price, (ProductCategory.getProductCategoryList().get(i)));
                                listOfProduct.add(newProduct);
                            }
                        }
                    }
                }else{
                    String nameOfProduct = productData[0];
                    Float price = Float.valueOf(productData[1]);
                    String categoryOfProduct = productData[2];
                    String exDate = productData[3];

                    String[] yyyyMmDd = exDate.split("=");
                    Integer year = Integer.valueOf(yyyyMmDd[0]); 
                    Integer mounth = Integer.valueOf(yyyyMmDd[1]);
                    Integer day = Integer.valueOf(yyyyMmDd[2]);

                    Date tempDate = new Date(year,mounth,day);

                    if ( !listOfcategory.contains(categoryOfProduct) ){
                        ProductCategory tempProductCategory = new  FeaturedProductCategory(nameOfProduct, tempDate);
                        Product newProduct = new Product(nameOfProduct, price, tempProductCategory);
                        listOfProduct.add(newProduct);
                        listOfcategory.add(categoryOfProduct);
                    }else{
                        for ( int i = 0; i < ProductCategory.getProductCategoryList().size(); i++  ){
                            if ( ProductCategory.getProductCategoryList().get(i).getName().equals(categoryOfProduct)   ){
                                newProduct = new Product(nameOfProduct, price, (ProductCategory.getProductCategoryList().get(i)));
                                listOfProduct.add(newProduct);
                            }
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
            Date data;
            
            ProductCategory productCategory =  tempProduct.getProductCategory();

            if (productCategory instanceof FeaturedProductCategory){
                FeaturedProductCategory tempCategory = (FeaturedProductCategory)productCategory;
                data = tempCategory.getExpirationDate();
                SimpleDateFormat dateStr = new SimpleDateFormat("yyyy=MM=dd");
                String dateString = dateStr.format(data);
                String str = tempName +"-"+ String.valueOf(tempprice) +"-"+ tempProdactCategory+"-"+dateString;
                sBuilder.append(str);
                sBuilder.append("\n");
            }else{
                String str = tempName +"-"+ String.valueOf(tempprice) +"-"+ tempProdactCategory;
                sBuilder.append(str);
                sBuilder.append("\n");
            }
        }

        String fullTExt = sBuilder.toString();
        
        try {
            Writer fw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream( "src/main/resources/products.txt"), "UTF-8"));
            String line = null;
            fw.write(fullTExt);
            fw.close();

        } catch (IOException iox) {
            iox.printStackTrace();
        }
    }

    public Product getProduct( Integer idOfProduct ){
        return listOfProduct.get(idOfProduct);
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


    public void addProduct(Product product){
        listOfProduct.add(product);
    }


}

