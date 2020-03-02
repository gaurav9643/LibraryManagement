package io.library.management.book;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class bookService {
    private List<book> books = new ArrayList<>(Arrays.asList(
            new book(1,"Java","java description"),
            new book(2,"Java","java description"),
            new book(3,"Java","java description")
    ));

    public List<book> getAllBooks() {
        return books;
    }


    public book getBook(int id){
        return  books.stream().filter(t -> t.getId() == id).findFirst().get();
    }

    public void addBook(book Book){
        books.add(Book);
    }

    public void updateBook(int id,book Book){
        for (int i = 0; i < books.size(); i++){
            book B = books.get(i);
            if(B.getId() == id){
                books.set(i,Book);
            }
        }
    }

    public void deleteBook(int id){
        books.removeIf(t -> t.getId() == id);
    }
}
