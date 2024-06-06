package com.allogica.LiterAlura_Challenge.Model.Services;

import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import com.allogica.LiterAlura_Challenge.Model.Services.DataConversion.BooksConversion;
import com.allogica.LiterAlura_Challenge.Model.Utilities.UserInputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class RequestAndDataManager {
    @Autowired
    private RequestPreparation requestPreparation;

    @Autowired
    private BooksConversion booksConversion;

    private Scanner keyboard = new Scanner(System.in);

    private String searchBook(String bookInformation) {
        return requestPreparation.searchRequest(bookInformation);
    }

    public BookDTO getFullBook(String bookInformation) {
        String json = searchBook(bookInformation);
        return booksConversion.getFullBook(json);
    }

    public List<BookDTO> getBooksList(String bookInformation) {
        String json = searchBook(bookInformation);
        return booksConversion.getBooksList(json);
    }

    public List<BookDTO> search() {
        String bookInformation = getUserInput();
        return getBooksList(bookInformation);
    }

    private String getUserInput() {
        return UserInputs.getStringFromUser("Enter the book name or author: ").replaceAll(" ", "%20");
    }


}
