package be.gaming.controller;

import be.gaming.model.Book;
import be.gaming.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public Collection<Book> findAll(){
        return bookRepository.findAll();
    }

    @GetMapping("/title/{booktitle}")
    public List findByTitle(@PathVariable String bookTitle){
        return bookRepository.findByTitle(bookTitle);
    }

    @GetMapping("/{id}")
    public Book findOne(@PathVariable long id){
        return bookRepository.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody Book book){
        return bookRepository.save(book);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        bookRepository.findById(id);
        bookRepository.deleteById(id);
    }

    @PostMapping("/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable long id){
        if (book.getId() != id){
            throw new RuntimeException("Mismatch Book");
        }
        bookRepository.findById(id);
        return bookRepository.save(book);
    }

}

