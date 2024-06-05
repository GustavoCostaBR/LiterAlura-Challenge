package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

public class BookLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
