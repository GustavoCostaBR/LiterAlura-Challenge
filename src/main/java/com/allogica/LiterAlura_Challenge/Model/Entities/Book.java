package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Map;

@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    private Map<String, String> formats;



}
