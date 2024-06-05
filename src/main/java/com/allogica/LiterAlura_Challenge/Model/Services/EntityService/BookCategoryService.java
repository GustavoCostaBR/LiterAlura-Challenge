package com.allogica.LiterAlura_Challenge.Model.Services.EntityService;

import com.allogica.LiterAlura_Challenge.Model.Entities.*;
import com.allogica.LiterAlura_Challenge.Model.Repositories.BookCategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Transactional
    public Book addCategoryToBook(Book book, BookDTO bookDTO) {
        List<BookCategory> bookCategories = receiveCategoriesFromBookDTO(bookDTO);
        for (BookCategory bookCategory : bookCategories) {
            bookCategory.addBook(book);
            book.addCategory(bookCategory);
        }
        return book;
    }

    public List<BookCategory> receiveCategoriesFromBookDTO(BookDTO bookDTO) {
        List<String> bookCategoriesString = List.of(bookDTO.categories());
        List<BookCategory> bookCategories = new ArrayList<>();

        for (String bookCategoryString : bookCategoriesString) {
            BookCategory bookCategory = createOrGetBookCategory(bookCategoryString);
            bookCategories.add(bookCategory);
        }

        return bookCategories;
    }

    private BookCategory createOrGetBookCategory(String bookCategoryString) {
        if (!bookCategoryRepository.existsByName(bookCategoryString)) {
            return createNewBookCategory(bookCategoryString);
        } else {
            return bookCategoryRepository.findByName(bookCategoryString).orElseThrow();
        }
    }

    private BookCategory createNewBookCategory(String bookCategoryString) {
        BookCategory bookCategory = new BookCategory(bookCategoryString);
        return bookCategoryRepository.save(bookCategory);
    }
}
