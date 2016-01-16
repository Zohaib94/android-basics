package com.example.zohaib.sqlite;

/**
 * Created by zohaib on 12/7/15.
 */
public class Book {
    private int ID;
    private String bookname;

    public Book()
    {

    }
    public Book(int id, String bookname) {
        this.setID(id);
        this.setBookname(bookname);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
}
