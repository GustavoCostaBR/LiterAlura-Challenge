package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book_categories")
public class BookCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;

    private String  name;

    public BookCategory(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    public BookCategory() {
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public List<Book> getBook() {
        return books;
    }
}
