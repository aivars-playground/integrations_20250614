package com.example.demo.books;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(path = "/{id}", produces = "application/json")
    public @ResponseBody Book getBook(@PathVariable int id) {
        return bookService.findBookById(id);
    }

}
