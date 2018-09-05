package com.codecool.view;

import java.util.Scanner;

public class View {
    Scanner scanner;

    public String getInput() {
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        return input;
    }

    public int getIntInput() {
        scanner = new Scanner(System.in);
        boolean isInt = false;
        Integer integer = null;

        while(!isInt && integer != null) {
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

    public void 
}