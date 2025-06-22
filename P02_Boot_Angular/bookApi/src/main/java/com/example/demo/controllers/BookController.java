package com.example.demo.controllers;

import com.example.demo.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Book get(@PathVariable long id) {
        return bookService
                .getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/", produces = "application/json")
    public Book save(@RequestBody Book book) {
       return bookService
                .save(book);
    }

    @PutMapping(path = "/{id}", produces = "application/json")
    public Book update(@RequestBody Book book, @PathVariable long id) {
        return bookService
                .update(book, id);
    }

}
