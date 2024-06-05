package com.allogica.LiterAlura_Challenge.Model.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book_languages")
public class BookLanguage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
