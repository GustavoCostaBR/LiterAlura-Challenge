package com.allogica.LiterAlura_Challenge.Model.Entities;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookDTO(@JsonAlias("title") String title,
                      @JsonAlias("authors") AuthorDTO[] authors,
                      @JsonAlias("subjects") String[] categories,
                      @JsonAlias("languages") String[] languages,
                      @JsonAlias("formats") Map<String, String> formats) {

}
