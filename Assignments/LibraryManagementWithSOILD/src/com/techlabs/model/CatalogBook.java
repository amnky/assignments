package com.techlabs.model;

public class CatalogBook {
    private Book book;

    public CatalogBook(Book book) {
        this.book = book;
    }

    public void catalogBook(){
        System.out.println("Book Name : "+book.getTitle()+" , Book Author : "+book.getAuthor());
    }
}
