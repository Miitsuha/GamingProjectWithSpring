package be.gaming.repository;

import be.gaming.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BookRepositoryImpl implements BookRepository{

    private List<Book> books = new ArrayList<>();

    @Override
    public List<Book> findByTitle(String title) {
        return books.stream().filter(book -> book.getTitle().equals(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> findAll() {
        return books;
    }

    @Override
    public Book findById(long id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Book save(Book book) {

        if (findById(book.getId()) == null){
            books.add(book);
        }else{
            books.remove(book);
            books.add(book);
        }
        return findById(book.getId());
    }

    @Override
    public boolean deleteById(long id) {
        Book bookToDelete = findById(id);
        return books.remove(bookToDelete);
    }

    @PostConstruct
    public void onPostConstruct(){
        books.add(new Book(1,"Les Grandes Marées","Jules Bernes"));
        books.add(new Book(2,"Les Sous-Fifres","Dalida"));
    }
}