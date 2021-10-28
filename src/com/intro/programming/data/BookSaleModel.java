package com.intro.programming.data;

import java.util.Date;
import java.util.List;

public class BookSaleModel {
    private final List<BookQtyModel> bookAndQtyList;
    private final CustomerModel customer;
    private final Date saleDate;

    public BookSaleModel(List<BookQtyModel> bookAndQtyList,
                         CustomerModel customer, Date saleDate) {
        this.bookAndQtyList = bookAndQtyList;
        this.customer = customer;
        this.saleDate = saleDate;
    }

    public List<BookQtyModel> getBookAndQtyList() {
        return bookAndQtyList;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public Date getSaleDate() {
        return saleDate;
    }
}
