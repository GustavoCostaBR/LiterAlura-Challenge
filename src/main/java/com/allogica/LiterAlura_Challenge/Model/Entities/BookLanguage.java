package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_languages")
public class BookLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public BookLanguage() {
    }

    public String getName() {
        return name;
    }

    public BookLanguage(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "languages")
    private List<Book> books;

    public void addBook(Book book) {
        this.books.add(book);
    }

    public Long getId() {
        return id;
    }

    public List<Book> getBook() {
        return books;
    }
}
