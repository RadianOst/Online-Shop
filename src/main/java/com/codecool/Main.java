package com.codecool;

// import com.codecool.order.process.CheckoutProcess;
// import com.codecool.order.process.PayProcess;

import com.codecool.view.StoreView;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        View storeView = new StoreView();

        storeView.printView();
        storeView.printMenu();
        
 
    }
}
