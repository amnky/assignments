package com.techlabs.model;

public class ReturnBook {
    private User user;
    private Book book;

    public ReturnBook(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    public void returnBook(){
        book.setBorrowed(false);
        System.out.println("User "+user.getUserName()+" returned "+book.getTitle());
    }

}
