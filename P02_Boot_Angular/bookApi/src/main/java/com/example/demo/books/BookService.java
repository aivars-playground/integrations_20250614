package com.example.demo.books;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    public Book findBookById(int id) {
        return new Book(1l,"aaa","vv","fff");
    }
}
