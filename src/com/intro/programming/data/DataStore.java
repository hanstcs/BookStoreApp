package com.intro.programming.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class DataStore {
    private List<BookModel> bookList;
    private List<UserModel> userList;
    private List<BookQtyModel> bookQtyList;
    private List<BookSaleModel> bookSaleList;

    public DataStore() {
        this.bookList = getInitialBooks();
        this.userList = getInitialUsers();
        this.bookQtyList = getInitialBookQtyList();
        this.bookSaleList = new ArrayList<>();
    }

    private List<BookModel> getInitialBooks() {
        List<BookModel> result = new ArrayList<>();
        result.add(new BookModel("Effective Java, Third Edition", "Joshua Bloch", "9780134686097"));
        result.add(new BookModel("Java: The Complete Reference", "", "9781260440249"));
        result.add(new BookModel("Code Complete, Second Edition", "Steve McConnell", "0735619670"));
        result.add(new BookModel("The Pragmatic Programmer, 2nd Edition", "David Thomas, Andrew Hunt", "9780135956977"));
        result.add(new BookModel("Clean Architecture", "Robert C. Martin", "9780134494272"));
        return result;
    }

    private List<UserModel> getInitialUsers() {
        List<UserModel> result = new ArrayList<>();
        result.add(new AdminModel("admin", "admin123", "1231231"));
        result.add(new AdminModel("admin2", "admin211", "901238"));
        result.add(new CustomerModel("hanstcs", "hanstcs123", "Hans", "071239812"));
        return result;
    }

    private List<BookQtyModel> getInitialBookQtyList() {
        List<BookQtyModel> result = new ArrayList<>();
        result.add(new BookQtyModel(getInitialBooks().get(0), 10));
        result.add(new BookQtyModel(getInitialBooks().get(1), 2));
        result.add(new BookQtyModel(getInitialBooks().get(2), 5));
        result.add(new BookQtyModel(getInitialBooks().get(3), 10));
        result.add(new BookQtyModel(getInitialBooks().get(4), 10));
        return result;
    }

    public List<BookQtyModel> getBookQtyList() {
        return bookQtyList;
    }

    public List<UserModel> getUserList() {
        return userList;
    }

    public UserModel findUserByUserName(String username) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst()
                .get();
    }

    public void addNewBook(BookQtyModel bookQty) {
        bookQtyList.add(bookQty);
        bookList.add(bookQty.getBook());
    }

    public void orderBook(CustomerModel customer, int bookId, int qty) {
        BookModel book = getBookById(bookId);
        bookSaleList.add(new BookSaleModel(
                new BookQtyModel(book, qty),
                customer,
                new Date()
        ));
        decreaseBookQty(book, qty);
    }

    public BookModel getBookById(int bookId) {
        return bookList.get(bookId - 1);
    }

    public void decreaseBookQty(BookModel book, int qty) {
        this.bookQtyList = bookQtyList.stream()
                .peek(bookQty -> {
                    if (bookQty.getBook().getIsbn().equals(book.getIsbn()))
                        bookQty.setQty(bookQty.getQty() - qty);
                })
                .collect(Collectors.toList());
    }

    public void updateBookQty(BookModel book, int qty) {
        this.bookQtyList = bookQtyList.stream()
                .peek(bookQty -> {
                    if (bookQty.getBook().getIsbn().equals(book.getIsbn()))
                        bookQty.setQty(qty);
                })
                .collect(Collectors.toList());
    }

    public void updateBook(int bookId, BookModel updatedBook) {
        BookModel previousBookData = getBookById(bookId);
        this.bookQtyList = bookQtyList.stream()
                .peek(bookQty -> {
                    if (bookQty.getBook().getIsbn().equals(previousBookData.getIsbn()))
                        bookQty.setBook(updatedBook);
                })
                .collect(Collectors.toList());
    }
}
