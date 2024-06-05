package com.allogica.LiterAlura_Challenge.Model.Repositories;

import com.allogica.LiterAlura_Challenge.Model.Entities.BookLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookLanguageRepository extends JpaRepository<BookLanguage, Long> {
    Optional<BookLanguage> findByName(String name);
    boolean existsByName(String name);
}
