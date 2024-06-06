package com.allogica.LiterAlura_Challenge.Model.Services.DataConversion;

import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooksConversion {

    @Autowired
    private DataConversion dataConversion;

    public BookDTO getFullBook(String json) {
        return dataConversion.convertData(json, BookDTO.class);
    }

    public List<BookDTO> getBooksList(String json) {
        BookDTO[] booksArray = dataConversion.getSpecificKeyAndConvertData(json, "results", BookDTO[].class);
        return List.of(booksArray);
    }
}
