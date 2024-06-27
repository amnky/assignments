package com.techlabs.test;

import com.techlabs.model.*;

public class LibraryManagement {
    public static void main(String[] args) {
        IBorrow borrowService = new BorrowBook();
        IReturn returnService = new ReturnBook();
        ICatalog catalogService = new CatalogBook();

        Book book1 = new EBook("ABC", "abc", false);

        User user1 = new User("XYZ", 123);
        UserRegistration userRegistration1 = new UserRegistration(user1);
        userRegistration1.userRegistration();

        catalogService.catalogBook(book1);
        borrowService.borrowBook(user1, book1);
        returnService.returnBook(user1, book1);


        Book book2 = new EBook("PQR", "pqr", false);

        User user2 = new User("MNO", 456);
        UserRegistration userRegistration2 = new UserRegistration(user2);
        userRegistration2.userRegistration();

        catalogService.catalogBook(book2);
        borrowService.borrowBook(user2, book2);
        returnService.returnBook(user2, book2);
    }
}
