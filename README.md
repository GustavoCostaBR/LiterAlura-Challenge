# LiterAlura-Challenge
//Portuguese version below.

This is a Spring Boot API project for cataloging books, allowing you to search for books, list them by various criteria, and manage authors and their information.
Features

    Search and add books from an external API.
    List all books.
    List all authors.
    List all living authors in a specific year.
    List all books in a specific language.
    Search authors by name.

Prerequisites

    Java JDK 17 installed on your machine.
    Java IDE (recommended: IntelliJ IDEA, Eclipse, NetBeans).
    PostgreSQL database.
    Dependencies: Spring Boot, Spring Data JPA, PostgreSQL driver, Jackson Databind.

Configuration

    Set up your application.properties file with the following configurations:

    properties

    spring.application.name=LiterAlura-Challenge
    spring.datasource.url=jdbc:postgresql://${postgresDBHost}/${DBNAME1}
    spring.datasource.username=${postgresUSER}
    spring.datasource.password=${postgresPASSWORD}
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.HSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    #spring.jpa.show-sql=true
    #spring.jpa.format-sql=true

How to Use

    Clone or download this repository to your local machine.
    Open the project in your Java IDE.
    Configure your PostgreSQL database and update the application.properties file with your database credentials.
    Run the application using your IDE or build a JAR file with dependencies and run it using the command:

    bash

    java -jar liter-alura-challenge.jar

    Use the provided menu to interact with the application:



                    1 - Search book in the API and add to the database;
                    2 - List all books;
                    3 - List all authors;
                    4 - List all living authors in a specific year;
                    5 - List all books in a specific language;
                    6 - List author by name;
                    9 - Exit.
            

API Consumption

The external API used to fetch book information is Gutendex API.
Author

Gustavo Henrique da Costa

This README.md provides instructions on how to use the LiterAlura-Challenge Spring Boot API application, including prerequisites, features, and usage steps.
LiterAlura-Challenge




Este é um projeto de API Spring Boot para catalogar livros, permitindo que você pesquise livros, liste-os por vários critérios e gerencie autores e suas informações.
Funcionalidades

    Pesquisar e adicionar livros de uma API externa.
    Listar todos os livros.
    Listar todos os autores.
    Listar todos os autores vivos em um ano específico.
    Listar todos os livros em um idioma específico.
    Pesquisar autores por nome.

Pré-requisitos

    Java JDK 17 instalado na máquina.
    IDE Java (recomendado: IntelliJ IDEA, Eclipse, NetBeans).
    Banco de dados PostgreSQL.
    Dependências: Spring Boot, Spring Data JPA, driver PostgreSQL, Jackson Databind.

Configuração

    Configure seu arquivo application.properties com as seguintes configurações:

    properties

    spring.application.name=LiterAlura-Challenge
    spring.datasource.url=jdbc:postgresql://${postgresDBHost}/${DBNAME1}
    spring.datasource.username=${postgresUSER}
    spring.datasource.password=${postgresPASSWORD}
    spring.datasource.driver-class-name=org.postgresql.Driver
    hibernate.dialect=org.hibernate.dialect.HSQLDialect
    spring.jpa.hibernate.ddl-auto=update
    #spring.jpa.show-sql=true
    #spring.jpa.format-sql=true

Como Usar

    Clone ou faça o download deste repositório para sua máquina local.
    Abra o projeto em sua IDE Java.
    Configure seu banco de dados PostgreSQL e atualize o arquivo application.properties com suas credenciais do banco de dados.
    Execute a aplicação usando sua IDE ou gere um arquivo JAR com dependências e execute-o usando o comando:

    bash

    java -jar liter-alura-challenge.jar

    Use o menu fornecido para interagir com a aplicação:


                    1 - Pesquisar livro na API e adicionar ao banco de dados;
                    2 - Listar todos os livros;
                    3 - Listar todos os autores;
                    4 - Listar todos os autores vivos em um ano específico;
                    5 - Listar todos os livros em um idioma específico;
                    6 - Listar autor por nome;
                    9 - Sair.

            

Consumo de API

A API externa usada para obter informações dos livros é a Gutendex API.
Autor

Gustavo Henrique da Costa

Este README.md fornece instruções sobre como usar a aplicação LiterAlura-Challenge Spring Boot API, incluindo pré-requisitos, funcionalidades e etapas de uso.
