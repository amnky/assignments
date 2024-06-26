package com.techlabs.model;

import java.util.ArrayList;
import java.util.List;

public class BorrowBook {
    private User user;
    private Book book;

    public BorrowBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public void borrowBook(){
        book.setBorrowed(true);
        System.out.println("User ID : "+user.getUserId()+" , User Name : "+user.getUserName());
        System.out.println("Book Title : "+book.getTitle()+" , Book Author : "+book.getAuthor());
    }

}
