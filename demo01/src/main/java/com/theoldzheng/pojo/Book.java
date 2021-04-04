package com.theoldzheng.pojo;

/**
 * Description:
 *
 * @author theoldzheng@163.com  @ZYD
 * @create 2021.4.4 21:48
 */
public class Book {
    private String bookName;
    private String author;
    private String price;
    private String stock;
    private String sales;

    private Address add;
    public Book() {
    }

    public Book(String bookName, String author, String price, String stock, String sales, Address add) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
        this.stock = stock;
        this.sales = sales;
        this.add = add;
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getSales() {
        return sales;
    }

    public void setSales(String sales) {
        this.sales = sales;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", price='" + price + '\'' +
                ", stock='" + stock + '\'' +
                ", sales='" + sales + '\'' +
                ", add=" + add +
                '}';
    }
}
