package com.allogica.LiterAlura_Challenge.Model.Services.EntityService;

import com.allogica.LiterAlura_Challenge.Model.Entities.Author;
import com.allogica.LiterAlura_Challenge.Model.Entities.AuthorDTO;
import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import com.allogica.LiterAlura_Challenge.Model.Entities.BookDTO;
import com.allogica.LiterAlura_Challenge.Model.Repositories.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

//    private List<Author> authors;

//    public List<Author> getAuthors() {
//        return authors;
//    }

    @Transactional
    public Book addAuthorToBook(Book book, BookDTO bookDTO) {
        List<Author> authors = receiveAuthorsFromBookDTO(bookDTO);
        for (Author author : authors) {
            book.addAuthor(author);
        }
        return book;
    }

    public List<Author> receiveAuthorsFromBookDTO(BookDTO bookDTO) {
        List<AuthorDTO> authorsDTO = List.of(bookDTO.authors());
        List<Author> authors = new ArrayList<>();

        for (AuthorDTO authorDTO : authorsDTO) {
            Author author = createOrGetAuthor(authorDTO);
            authors.add(author);
        }

        return authors;
    }

    private Author createOrGetAuthor(AuthorDTO authorDTO) {
        if (!authorRepository.existsByName(authorDTO.name())) {
            return createNewAuthor(authorDTO);
        } else {
            return authorRepository.findByName(authorDTO.name()).orElseThrow();
        }
    }

    private Author createNewAuthor(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.name());
        author.setYearOfBirth(authorDTO.birthYear());
        author.setYearOfDeath(authorDTO.deathYear());
        return authorRepository.save(author);
    }
}
