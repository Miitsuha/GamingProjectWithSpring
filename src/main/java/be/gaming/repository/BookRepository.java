package be.gaming.repository;


import be.gaming.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> findByTitle(String title);
    List<Book> findAll();
    Book findById(long id);
    Book save(Book book);
    boolean deleteById(long id);
}
