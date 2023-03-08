package com.driver;
import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    private List<Book> bookList;
    private int id;

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BookRepository(){
        bookList = new ArrayList<>();
        id = 1;
    }

    public Book save(Book book){
        book.setId(this.id);
        this.id++;
        bookList.add(book);
        return book;
    }

    public Book findBookById(int id){
        for(Book book: bookList){
            if(book.getId() == id){
                return book;
            }
        }
        return null;
    }

    public List<Book> findAll(){

        return bookList;
    }

    public void deleteBookById(int id){

        for(Book book: bookList){
            if(book.getId() == id){
                this.bookList.remove(book);
            }
        }
        return;
    }

    public void deleteAll(){
        bookList.clear();
        return;
    }

    public List<Book> findBooksByAuthor(String author){
        List<Book> list = new ArrayList<>();
        for(Book book: bookList){
            if(book.getAuthor().equals(author)){
                list.add(book);
            }
        }
        return list;
    }

    public List<Book> findBooksByGenre(String genre){
        List<Book> list = new ArrayList<>();
        for(Book book: bookList){
            if(book.getGenre().equals(genre)){
                list.add(book);
            }
        }
        return list;
    }
}
