package com.allogica.LiterAlura_Challenge.Model.Services.EntityService;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import com.allogica.LiterAlura_Challenge.Model.Repositories.BookRepository;
import com.allogica.LiterAlura_Challenge.Model.Services.RequestAndDataManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private RequestAndDataManager requestAndDataManager;

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
        List<BookDTO> bookDTOs = requestAndDataManager.search();
        List<Book> booksFromDTO = addListOfBooksFromDTO(bookDTOs);
    }

    public List<Book> addListOfBooksFromDTO(List<BookDTO> bookDTOs) {
        if (isEmpty(bookDTOs)) {
            System.out.println("No books found.");
            return Collections.emptyList();
        }

        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOs) {
            addBookIfNotExists(bookDTO, books);
        }
        return books;
    }

    private boolean isEmpty(List<BookDTO> bookDTOs) {
        return bookDTOs == null || bookDTOs.isEmpty();
    }

    private void addBookIfNotExists(BookDTO bookDTO, List<Book> books) {
        String title = bookDTO.title();
        String address = getBookAddress(bookDTO);
        if (bookRepository.existsByTitleAndAddress(title, address)) {
            System.out.println("Book already exists in database: " + title);
            return;
        }

        Book book = createBookFromDTO(bookDTO, address);
        books.add(book);
        bookRepository.save(book);
    }

    private Book createBookFromDTO(BookDTO bookDTO, String address) {
        Book book = new Book(bookDTO.title());
        book.setAddress(address);
        book = authorService.addAuthorToBook(book, bookDTO);
        book = bookCategoryService.addCategoryToBook(book, bookDTO);
        book = bookLanguageService.addLanguageToBook(book, bookDTO);
        return book;
    }

    private String getBookAddress(BookDTO bookDTO) {
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
            else if (bookDTO.formats().get("text/html; charset=iso-8859-1") != null) {
                address = bookDTO.formats().get("text/html; charset=iso-8859-1");
                return address;
            }
            else if (bookDTO.formats().get("text/plain") != null) {
                address = bookDTO.formats().get("text/plain");
                return address;
            }
            else if (bookDTO.formats().get("text/plain; charset=us-ascii") != null) {
                address = bookDTO.formats().get("text/plain; charset=us-ascii");
                return address;
            }


        }
        System.out.println("No address found for book: " + bookDTO.title() + ". Problem converting formats to address.");
        return null;
    }
}
