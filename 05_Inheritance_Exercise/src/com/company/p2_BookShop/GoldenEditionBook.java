package com.company.p2_BookShop;

public class GoldenEditionBook extends Book {


    public GoldenEditionBook(String author, String title, double price) {
        super(author,title,price);

    }

    @Override
    public double getPrice() {
        return super.getPrice() + super.getPrice() * 0.3;
    }
}
