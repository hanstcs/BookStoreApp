package com.intro.programming.data;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    private List<BookModel> bookList;
    private List<UserModel> userList;
    private List<BookQtyModel> bookQtyList;

    public DataStore() {
        this.bookList = getInitialBooks();
        this.userList = getInitialUsers();
        this.bookQtyList = getInitialBookQtyList();
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
        result.add(new BookQtyModel(getInitialBooks().get(1), 10));
        result.add(new BookQtyModel(getInitialBooks().get(2), 2));
        result.add(new BookQtyModel(getInitialBooks().get(3), 5));
        result.add(new BookQtyModel(getInitialBooks().get(4), 10));
        result.add(new BookQtyModel(getInitialBooks().get(5), 10));
        return result;
    }
}
