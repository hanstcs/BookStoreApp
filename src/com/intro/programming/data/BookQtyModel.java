package com.intro.programming.data;

public class BookQtyModel {
    private BookModel book;
    private int qty;

    public BookQtyModel(BookModel book, int qty) {
        this.book = book;
        this.qty = qty;
    }

    public BookModel getBook() {
        return book;
    }

    public int getQty() {
        return qty;
    }

    public void setBook(BookModel book) {
        this.book = book;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book Detail \n" + book +
                "Quantity : " + qty;
    }
}
