package com.allogica.LiterAlura_Challenge.Model.Repositories;

import com.allogica.LiterAlura_Challenge.Model.Entities.BookLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookLanguageRepository extends JpaRepository<BookLanguage, Long> {
    Optional<BookLanguage> findByName(String name);

    boolean existsByName(String name);

    @Query("SELECT bl.id FROM BookLanguage bl")
    List<Long> findAllIds();

}
