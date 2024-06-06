package com.allogica.LiterAlura_Challenge.Model.Menus;

import com.allogica.LiterAlura_Challenge.Model.Services.EntityService.AuthorService;
import com.allogica.LiterAlura_Challenge.Model.Services.EntityService.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Menu {

    private Scanner keyboard = new Scanner(System.in);

    @Autowired
    private BookService bookService;
//    RequestValidationAndDataReturn requestValidationAndDataReturn = new RequestValidationAndDataReturn();

    @Autowired
    private AuthorService authorService;

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    1 - Search book;
                    2 - List all books;
                    3 - List all authors;
                    4 - Find musics by artist
                    5 - Search artist data
                    6 - Register album
                    9 - Exit
                    """;

            System.out.println(menu);
            option = keyboard.nextInt();
            keyboard.nextLine();

            switch (option) {
                case 1:
                    bookService.searchAndAddToDB();

                    break;
                case 2:
                    bookService.findAllAndPrint();
                    break;
                case 3:
                    authorService.findAllAndPrint();
                    break;
//                case 4:
//                    CustomPrinter.printMusicList(musicService.listMusicsByArtistFragmentName());
//                    break;
//                case 5:
//                    System.out.println("Please inform the artist name to search: ");
//                    ChatGPTSearch.searchArtistOnline(keyboard.nextLine());
//                    break;
//                case 6:
//                    albumService.registerAlbum();
//                    break;

                case 9:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option!");
            }


        }
    }
}
