package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    BookService bookService = new BookService();

    // One example controller, make the rest by yourself
    @PostMapping("/create-book")
    public ResponseEntity createBook(@RequestBody Book book){
        Book newbook = bookService.createBook(book);
        return new ResponseEntity<>(newbook, HttpStatus.CREATED);
    }

    @GetMapping("/get-book-by-id/{id}")
    public ResponseEntity getBookById(@PathVariable String id) {
        Book newbook = bookService.findBookById(id);
        return new ResponseEntity<>(newbook, HttpStatus.FOUND);
    }
    @GetMapping("/get-book-by-author")
    public ResponseEntity getBookByAuthor(@PathVariable String author) {
        List<Book> list = bookService.findBooksByAuthor(author);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }
    @GetMapping("/get-book-by-genre")
    public ResponseEntity getBookByGenre(@PathVariable String genre) {
        List<Book> list = bookService.findBooksByGenre(genre);
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @GetMapping("/get-all-books")
    public ResponseEntity getBookAllBooks() {
        List<Book> list = bookService.findAllBooks();
        return new ResponseEntity<>(list, HttpStatus.FOUND);
    }

    @DeleteMapping("/delete-book-by-id/{id}")
    public void deleteBookById(@PathVariable String id) {
        bookService.deleteBookById(id);
    }
    @DeleteMapping("/delete-all-books")
    public void deleteAllBooks() {
        bookService.deleteAllBooks();
    }
}
