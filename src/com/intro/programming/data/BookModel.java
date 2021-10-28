package com.intro.programming.data;

public class BookModel {
    private final String title;
    private final String author;
    private final String isbn;

    public BookModel(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String toString() {
        return "Title  : " + title + '\n' +
                "Author : " + author + '\n' +
                "ISBN   : " + isbn + '\n';
    }
}