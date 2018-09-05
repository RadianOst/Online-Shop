package com.codecool;

// import com.codecool.order.process.CheckoutProcess;
// import com.codecool.order.process.PayProcess;

import com.codecool.view.*;
import com.codecool.StoreDAO;


/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        // StoreView storeView = new StoreView();
        StoreDAO storeDao = new StoreDAO();
        // storeView.printView();
        // storeView.printMenu();

        System.out.println(storeDao.toString());
      
        
    }
}
