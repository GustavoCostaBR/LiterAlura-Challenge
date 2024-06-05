package com.allogica.LiterAlura_Challenge.Model.Services;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
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

    public void searchAndAddToDB() {
        List<Book> books = new ArrayList<>();
        List<BookDTO> bookDTOs = requestValidationAndDataReturn.search();
        for (BookDTO bookDTO : bookDTOs) {
            Book book = new Book();
            book.setTitle(bookDTO.title());
            book.setAuthors(authorService.receiveAuthorsFromBookDTO(bookDTO));
            book.setPublisher(bookDTO.getPublisher());
            book.setLanguage(bookDTO.getLanguage());
            book.setLicense(bookDTO.getLicense());
            book.setDownloadCount(bookDTO.getDownloadCount());
            book.setMediaType(bookDTO.getMediaType());
            book.setSubjects(bookDTO.getSubjects());
            book.setBookshelves(bookDTO.getBookshelves());
            book.setFormats(bookDTO.getFormats());
            books.add(book);
        }
    }

    private List<Book> addListOfBooksFromDTO(List<BookDTO> bookDTOs) {
        List<Book> books = new ArrayList<>();
        for (BookDTO bookDTO : bookDTOs) {
            Book book = new Book();
            book.setTitle(bookDTO.title());
            book.setAuthors(bookDTO.getAuthors());

            book.setPublisher(bookDTO.getPublisher());
            book.setLanguage(bookDTO.getLanguage());
            book.setLicense(bookDTO.getLicense());
            book.setDownloadCount(bookDTO.getDownloadCount());
            book.setMediaType(bookDTO.getMediaType());
            book.setSubjects(bookDTO.getSubjects());
            book.setBookshelves(bookDTO.getBookshelves());
            book.setFormats(bookDTO.getFormats());
            books.add(book);
        }
        return books;
    }
}
