package com.allogica.LiterAlura_Challenge.Model.Utilities;

import com.allogica.LiterAlura_Challenge.Model.Entities.Author;
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

    public static void printAuthors(List<Author> authors) {
        if (authors.isEmpty()) {
            System.out.println("No authors found.");
            return;
        }
        for (Author author : authors) {
            System.out.println("Author id: " + author.getId() + ", " + author + ", " + author.getYearOfBirth() + " - " + author.getYearOfDeath() + "\n");
        }
    }
}
