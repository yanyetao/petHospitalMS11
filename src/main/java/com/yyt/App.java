package com.yyt;

import com.yyt.service.BookService;
import com.yyt.service.impl.BookServiceImpl;


public class App {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        bookService.save();
    }
}
