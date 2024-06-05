package com.allogica.LiterAlura_Challenge.Model.Services.EntityService;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookLanguage;
import com.allogica.LiterAlura_Challenge.Model.Repositories.BookRepository;
import com.allogica.LiterAlura_Challenge.Model.Services.RequestValidationAndDataReturn;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private RequestValidationAndDataReturn requestValidationAndDataReturn;

    @Autowired
    AuthorService authorService;

    @Autowired
    BookCategoryService bookCategoryService;

    @Autowired
    BookLanguageService bookLanguageService;

    @Autowired
    BookRepository bookRepository;

    public void searchAndAddToDB() {
        List<Book> books = new ArrayList<>();
        List<BookDTO> bookDTOs = requestValidationAndDataReturn.search();
        List<Book> booksFromDTO = addListOfBooksFromDTO(bookDTOs);
    }

    @Transactional
    private List<Book> addListOfBooksFromDTO(List<BookDTO> bookDTOs) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOs) {
            Book book = new Book(bookDTO.title());
            book = authorService.addAuthorToBook(book, bookDTO);
            book = bookCategoryService.addCategoryToBook(book, bookDTO);
            book = bookLanguageService.addLanguageToBook(book, bookDTO);
            book.setAddress(getBookAdress(bookDTO));
            books.add(book);
            bookRepository.save(book);
        }
        return books;
    }

    private String getBookAdress(BookDTO bookDTO) {
        if (bookDTO.formats() == null) {
            System.out.println("No address found for book: " + bookDTO.title());
            return null;
        }

        else {
            String address;
            if (bookDTO.formats().get("text/html") != null) {
                address = bookDTO.formats().get("text/html");
                return address;
            }
            if (bookDTO.formats().get("text/plain") != null) {
                address = bookDTO.formats().get("text/plain");
                return address;
            }
        }
        System.out.println("No address found for book: " + bookDTO.title() + ". Problem converting formats to address.");
        return null;
    }
}
