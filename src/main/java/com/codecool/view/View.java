package com.codecool.view;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class View {
    protected Scanner scanner = new Scanner(System.in);

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

    public void println(String message){
        print(message+"\n");
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
        System.out.println();
    }

    public void clearConsole(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public void waitForSeconds(float amount){
        try{
            Thread.sleep((int)(1000*amount));
            // TimeUnit.SECONDS.wait(amount);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public String getInput() {
        return scanner.nextLine().trim();
    }

    public String askForInput(String askMessage){
        println(String.format("%s", askMessage));
        return getInput();
    }

    public int getIntInput() {
        String intString;
        boolean isNotInteger = true;
        int number = 0;

        while (isNotInteger) {
            intString = getInput();

            try {
                number = Integer.parseInt(intString);
                isNotInteger = false;
            } catch (NumberFormatException e) {
                System.out.println("Error! Type an integer...");
                isNotInteger = true;
            }
        }
        return number;
    }
}