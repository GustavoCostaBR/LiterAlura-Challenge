package com.allogica.LiterAlura_Challenge.Model.Utilities;

import java.util.List;
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

    public static int getIntegerBetweenTwoValues(String message, int min, int max){
        System.out.println(message);
        do {
            try {
                int number = Integer.parseInt(keyboard.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } while (true);
    }

    public static long getLongInList(String message, List<Long> list){
        System.out.println(message);
        do {
            try {
                long number = Long.parseLong(keyboard.nextLine());
                for (long l : list) {
                    if (l == number) {
                        return number;
                    }
                }
                System.out.println("Please enter a valid number.");
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } while (true);
    }
}
