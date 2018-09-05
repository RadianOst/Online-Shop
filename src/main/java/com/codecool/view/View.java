package com.codecool.view;

import com.codecool.Product;
import java.util.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class View {

    public String center(String text, int width){
        int padSize = width - text.length();
        int padStart = text.length() + (padSize / 2);

        text = String.format("%" + padStart + "s", text);
        text = String.format("%-" + width + "s", text);

        return text;
    }

    public void print(String message){
        System.out.print(message);
    }

    public void printCenteredError(String error, int width){
        printCentered(String.format("!!! %s !!!", error), width);
    }

    public void printCentered(String text, int width){
        System.out.print(center(text, width));
    }
    
    public void printMenu(String[] options){
        for (int i = 0; i < options.length; i++){
            System.out.println(String.format("%d. %s", i+1, options[i]));
        }
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void waitForSeconds(int amount){
        try{
            TimeUnit.SECONDS.wait(amount);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        boolean isInt = false;
        int integer = 1;

        while(!isInt) {
            String input = scanner.nextLine(); 
            try {
                integer = Integer.parseInt(input);
                isInt = true;
            } catch (NumberFormatException e) {
                System.out.println("Type a number!");
            }
        }
        scanner.close();

        return integer;
    }
}