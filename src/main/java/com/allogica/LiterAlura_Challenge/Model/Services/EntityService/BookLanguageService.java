package com.allogica.LiterAlura_Challenge.Model.Services.EntityService;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookCategory;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookLanguage;
import com.allogica.LiterAlura_Challenge.Model.Repositories.BookLanguageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookLanguageService {

    @Autowired
    BookLanguageRepository bookLanguageRepository;

    @Transactional
    public Book addLanguageToBook(Book book, BookDTO bookDTO) {
        List<BookLanguage> bookLanguages = receiveLanguagesFromBookDTO(bookDTO);
        for (BookLanguage bookLanguage : bookLanguages) {
            bookLanguage.addBook(book);
            book.addLanguage(bookLanguage);
        }
        return book;
    }

    private List<BookLanguage> receiveLanguagesFromBookDTO(BookDTO bookDTO) {
        List<String> bookLanguagesString = List.of(bookDTO.languages());
        List<BookLanguage> bookLanguages = new ArrayList<>();

        for (String bookLanguageString : bookLanguagesString) {
            BookLanguage bookLanguage = createOrGetBookLanguage(bookLanguageString);
            bookLanguages.add(bookLanguage);
        }

        return bookLanguages;
    }

    private BookLanguage createOrGetBookLanguage(String bookLanguageString) {
        if (!bookLanguageRepository.existsByName(bookLanguageString)) {
            return createNewBookLanguage(bookLanguageString);
        } else {
            return bookLanguageRepository.findByName(bookLanguageString).orElseThrow();
        }
    }

    private BookLanguage createNewBookLanguage(String bookLanguageString) {
        BookLanguage bookLanguage = new BookLanguage(bookLanguageString);
        return bookLanguageRepository.save(bookLanguage);
    }

}
