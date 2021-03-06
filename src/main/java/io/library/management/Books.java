package io.library.management;

import java.util.List;

import io.library.management.book.book;
import io.library.management.book.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Books {

    @Autowired
    private bookService bookservice;

    @RequestMapping("/books")
    List<book> getAllBooks(){
        return bookservice.getAllBooks();
    }

    @RequestMapping("/books/{id}")
    book getBook(@PathVariable int id){
        return bookservice.getBook(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    void addBook(@RequestBody book Book){
        bookservice.addBook(Book);
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    void updateBook(@RequestBody book Book,@PathVariable int id){
        bookservice.updateBook(id,Book);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    void deleteBook(@PathVariable int id){
        bookservice.deleteBook(id);
    }

}
