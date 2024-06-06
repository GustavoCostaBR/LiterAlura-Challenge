package com.allogica.LiterAlura_Challenge.Model.Utilities;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;

import java.util.List;

public class CustomPrinter {

    public static void printBooks(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books found.");
            return;
        }
        for (Book book : books) {
            System.out.println(book + "\n");
        }
    }
}
