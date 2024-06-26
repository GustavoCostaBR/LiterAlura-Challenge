package com.allogica.LiterAlura_Challenge.Model.Repositories;

import com.allogica.LiterAlura_Challenge.Model.Entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);

    boolean existsByName(String name);

    List<Author> findByYearOfBirthLessThanAndYearOfDeathGreaterThanOrYearOfDeathIsNull(int year, int year2);

    List<Author> findByNameContaining(String name);
}
