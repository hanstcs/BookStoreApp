package com.intro.programming;

import com.intro.programming.data.BookModel;
import com.intro.programming.data.BookQtyModel;
import com.intro.programming.data.UserModel;

import java.util.List;
import java.util.Scanner;

public class View {
    public void showHeader() {
        System.out.println("Welcome to Book Store App");
    }

    public UserModel showLogin() {
        System.out.println(".:: Login ::.");
        System.out.print("Username : ");
        String username = new Scanner(System.in).nextLine();
        System.out.print("Password : ");
        String password = new Scanner(System.in).nextLine();
        return new UserModel(username, password);
    }

    public void showAdminPage() {
        System.out.println("Admin Page\n" +
                "1. See Books\n" +
                "2. Add New Book\n" +
                "3. Update Book\n" +
                "0. Exit");
    }

    public BookQtyModel showAddNewBookForm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Book Detail");
        System.out.print("Title  : ");
        String title = scanner.nextLine();
        System.out.print("Author : ");
        String author = scanner.nextLine();
        System.out.print("ISBN   : ");
        String isbn = scanner.nextLine();
        System.out.print("Qty    : ");
        int qty = scanner.nextInt();
        return new BookQtyModel(new BookModel(title, author, isbn), qty);
    }

    public void showCustomerPage() {
        System.out.println("Customer Page\n" +
                "1. See Books\n" +
                "2. Order Book\n" +
                "0. Exit");
    }

    public void showBooks(List<BookQtyModel> bookQtyList) {
        int index = 1;
        for (int i = 0; i < bookQtyList.size(); i++) {
            System.out.println("ID: " + index + "\n"
                    + bookQtyList.get(i));
            System.out.println();
            index++;
        }
    }

    public void showOrderBookForm() {
        System.out.println("=== Order Book ===");
        System.out.print("Enter book ID : ");
    }

    public void showQtyForm() {
        System.out.print("Enter book qty : ");
    }

    public void showTitleForm() {
        System.out.print("Enter title : ");
    }

    public void showAuthorForm() {
        System.out.print("Enter author : ");
    }

    public void showIsbnForm() {
        System.out.print("Enter ISBN : ");
    }

    public void showPickUpdateBookForm() {
        System.out.println("=== Update Book ===");
        System.out.print("Enter book ID : ");
    }

    public void showUpdateBookForm() {
        System.out.println("Select field you want to update\n" +
                "1. Title\n" +
                "2. Author\n" +
                "3. ISBN\n" +
                "4. Quantity\n" +
                "0. Cancel");
    }
}
