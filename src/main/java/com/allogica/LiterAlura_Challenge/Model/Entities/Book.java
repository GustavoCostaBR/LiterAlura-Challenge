package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "books")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private String title;



    @OneToMany(mappedBy = "book")
    private List<BookCategory> categories;

    @OneToMany(mappedBy = "book")
    private List<BookLanguage> languages;

    private String address;

    public List<Author> getAuthors() {
        return authors;
    }

    public void addAuthors(Author author) {
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

    public void addCategories(BookCategory categorie) {
        this.categories.add(categorie);
    }

    public List<BookLanguage> getLanguages() {
        return languages;
    }

    public void addLanguages(BookLanguage language) {
        this.languages.add(language);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
