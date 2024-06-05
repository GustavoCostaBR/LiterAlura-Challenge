package com.allogica.LiterAlura_Challenge.Model.Utilities;

import java.util.Scanner;

public class UserInputs {
    public static String getStringFromUser(String message){
        System.out.println(message);
        return new Scanner(System.in).nextLine();
    }
}
