package com.allogica.LiterAlura_Challenge.Model.Repositories;

import com.allogica.LiterAlura_Challenge.Model.Entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
