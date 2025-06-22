package com.example.demo.services;

import com.example.demo.controllers.Book;
import com.example.demo.entities.BookEntity;
import com.example.demo.entities.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Optional<Book> getById(long id) {
        return bookRepository
                .findById(id)
                .map(
                entity -> toBookRecord(entity)
        );

    }

    public Book save(Book book) {
        BookEntity entity = toBookEntity(book);
        bookRepository.save(entity);
        return toBookRecord(entity);
    }

    public Book update(Book book, long id) {
        BookEntity existing = bookRepository.findById(id).get();
        toUpdatedBookEntityWithVersion(existing, book);
        bookRepository.save(existing);
        return toBookRecord(existing);
    }

    private void toUpdatedBookEntityWithVersion(BookEntity existing, Book book)  {
        existing.setVersion(book.version());
        existing.setAuthor(book.author());
        existing.setTitle(book.title());
        existing.setIsbn(book.isbn());
    }

    private BookEntity toBookEntity(Book book)  {
            var entity = new BookEntity();
            entity.setAuthor(book.author());
            entity.setTitle(book.title());
            entity.setIsbn(book.isbn());
            return entity;
    }

    private Book toBookRecord(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                bookEntity.getAuthor(),
                bookEntity.getIsbn(),
                bookEntity.getVersion()
        );
    }

}
