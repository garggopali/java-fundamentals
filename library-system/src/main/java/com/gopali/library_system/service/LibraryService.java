package com.gopali.library_system.service;

import java.util.ArrayList;
import java.util.Optional;

import org.apache.tomcat.jni.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopali.library_system.model.Book;

@Service
public class LibraryService {

    private ArrayList<Book> books;

    LibraryService() { //
        books = new ArrayList<>();
    }

   public Boolean addBook(Book book) {
        if (book == null)
            return false;
        else {
            books.add(book);
            return true;
        }
    }
public String getAllBooks(){
    StringBuilder sb=new StringBuilder(); //building lots of string in one string
    books.stream().forEach(book->{sb.append(book.toString());sb.append("\n");});
return sb.toString();
}

public boolean removeBookByIsbn(String isbn) {
    return books.removeIf(book-> book != null && book.getIsbn().equalsIgnoreCase(isbn));
}

public ArrayList<Book> displayAllBooks() {
        return books;
    }

    public Book findBookByTitle(String title) {
        Optional<Book> opt=books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst();
        if(opt.isPresent())
        return opt.get();
        else
        return null;
    }


}
