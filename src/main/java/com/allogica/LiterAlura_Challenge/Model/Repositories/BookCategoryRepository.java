package com.allogica.LiterAlura_Challenge.Model.Repositories;

import com.allogica.LiterAlura_Challenge.Model.Entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
    Optional<BookCategory> findByName(String name);

    boolean existsByName(String name);
}
