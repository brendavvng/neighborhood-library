package com.pluralsight;

public class Book {


    // creating class properties/variables that describe a book
    // using private so it protects the properties, no changes
    private int id;
    private String isbn; // international standard book number
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // creating constructor
    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = null; // initialize to null in the constructor, using null since no one has checked out book

    }
    // creating method to check out a book
    public void checkOut(String name) {
        // set checkedOut to true using setter
        this.setCheckedOut(true);
        // set checkedOutTo, to the name passed in
        this.setCheckedOutTo(name);
    }

    // creating method to check in a book that clears the appropriate variables
    public void checkIn() {
        // clearing out name, setting to false since person checking in the book
        this.setCheckedOut(false);
        // setting to no-one / empty string since person is checking in the book
        this.setCheckedOutTo("");
    }


    // generated getters and setters below

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return this.isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return this.checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

}
