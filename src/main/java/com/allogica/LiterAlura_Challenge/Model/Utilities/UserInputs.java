package com.allogica.LiterAlura_Challenge.Model.Utilities;

import java.util.Scanner;

public class UserInputs {


    static Scanner keyboard = new Scanner(System.in);

    public static String getStringFromUser(String message){
        System.out.println(message);
        return keyboard.nextLine();
    }

    public static Integer getIntegerFromUser(String message){
        System.out.println(message);
        do {
            try {
                return Integer.parseInt(keyboard.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } while (true);


    }
}
