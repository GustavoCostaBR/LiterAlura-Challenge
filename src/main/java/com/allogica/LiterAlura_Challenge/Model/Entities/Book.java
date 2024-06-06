package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books", uniqueConstraints = @UniqueConstraint(columnNames = {"title", "address"}))
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.languages = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

//    @Lob
    @Column(columnDefinition = "TEXT")
    private String title;



    @ManyToMany
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<BookCategory> categories;

    @ManyToMany
    @JoinTable(
            name = "book_language",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private List<BookLanguage> languages;

//    @Lob
    @Column(columnDefinition = "TEXT")
    private String address;

    public Book() {
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BookCategory> getCategories() {
        return categories;
    }

    public void addCategory(BookCategory categorie) {
        this.categories.add(categorie);
    }

    public List<BookLanguage> getLanguages() {
        return languages;
    }

    public void addLanguage(BookLanguage language) {
        this.languages.add(language);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
