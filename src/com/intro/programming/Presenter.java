package com.intro.programming;

import com.intro.programming.data.*;

import java.util.Scanner;

public class Presenter {
    private final View view;
    private final DataStore dataStore;
    private final UserAuth userAuth;
    private final Scanner scanner;

    public Presenter(View view, DataStore dataStore, UserAuth userAuth) {
        this.view = view;
        this.dataStore = dataStore;
        this.userAuth = userAuth;
        this.scanner = new Scanner(System.in);
    }

    public void showLandingPage() {
        view.showHeader();
        toLogin();
    }

    private void toLogin() {
        UserModel userData = view.showLogin();
        if (!userAuth.isCorrectUser(userData)) {
            System.out.println("Wrong username or password!");
            toLogin();
            return;
        }
        if (userAuth.isAdmin(userData)) {
            toAdminPage();
            return;
        }
        if (userAuth.isCustomer(userData)) {
            toCustomerPage();
        }
    }

    private void toAdminPage() {
        view.showAdminPage();
        int choice = scanner.nextInt();
        if (choice == 1) {
            view.showBooks(dataStore.getBookQtyList());
            toAdminPage();
        }
        if (choice == 2) {
            addNewBook();
            toAdminPage();
        }
    }

    public void toCustomerPage() {
        view.showCustomerPage();
        int choice = scanner.nextInt();
        if (choice == 1) {
            view.showBooks(dataStore.getBookQtyList());
            toCustomerPage();
        }
        if (choice == 2) {
            view.showOrderBookForm();
            int bookId = scanner.nextInt();
            view.showQtyForm();
            int qty = scanner.nextInt();
            dataStore.orderBook(null, bookId, qty);
            toCustomerPage();
        }
    }

    private void addNewBook() {
        BookQtyModel bookQty = view.showAddNewBookForm();
        dataStore.addNewBook(bookQty);
    }
}
