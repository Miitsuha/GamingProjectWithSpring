package be.gaming.repository;

import be.gaming.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryImpl implements BookRepository{

    @Override
    public List<Book> findByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book deleteById(long id) {
        return null;
    }
}