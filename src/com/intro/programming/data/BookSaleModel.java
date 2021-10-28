package com.intro.programming.data;

import java.util.Date;
import java.util.List;

public class BookSaleModel {
    private final BookQtyModel bookAndQty;
    private final CustomerModel customer;
    private final Date saleDate;

    public BookSaleModel(BookQtyModel bookAndQty,
                         CustomerModel customer, Date saleDate) {
        this.bookAndQty = bookAndQty;
        this.customer = customer;
        this.saleDate = saleDate;
    }

    public BookQtyModel getBookAndQty() {
        return bookAndQty;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }
}
