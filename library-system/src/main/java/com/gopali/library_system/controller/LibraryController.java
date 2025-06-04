package com.gopali.library_system.controller;

import org.springframework.web.bind.annotation.RestController;

import com.gopali.library_system.model.Book;
import com.gopali.library_system.service.LibraryService;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

    @Autowired // // dependency injection - library service dependent on library so it will
               // inject library automatically
    LibraryService libraryService; // dependency

    // get maping
    // https://upgraded-xylophone-9r47jrwg7x2xvpq-8080.app.github.dev/api/books/add?writer=gopali&title=java
    // or
    // https://upgraded-xylophone-9r47jrwg7x2xvpq-8080.app.github.dev/api/books/add?writer=gopali&title=java&isbn=isbn_number
    // so we are adding ?writer=gopali&title=java&isbn=isbn_number in the end of url
    // as @requestparam
    // @RequestParam(name = "writer") means if someone sending value as writer or as
    // author
    // @RequestParam(required = false) means its optional if we want to add in url
    // or we can skip without error

    @GetMapping("/add")
    public String getBook(@RequestParam(name = "writer") String author, @RequestParam String title,
            @RequestParam(required = false) String isbn) {
        Book book = new Book(title, author, isbn);
        return String.valueOf(libraryService.addBook(book));
    }

    @GetMapping("/")
    public String getAllBooks() {
        return libraryService.getAllBooks();
    }

    @DeleteMapping("/remove/{isbn}")
    public boolean removeBookByIsbn(@PathVariable String isbn) {

        return libraryService.removeBookByIsbn(isbn);
    }

    @GetMapping("/all")
    public ArrayList<Book> displayAllBooks() {
        return libraryService.displayAllBooks();
    }

    @GetMapping("/{title}")
    public String findBookByTitle(@PathVariable String title) {
        Book book=libraryService.findBookByTitle(title);
        if(book!=null)
        return book.toString();
        else
        return "Book not found"; 
    }
    

}