package com.bit.lib.system.model;

public class MybookList {
    private String book_name;
    private String borrowDate;
    private String returnDate;
   private int extension;
    private String book_code;
    private String member_id;

    public MybookList() {
    }

    public MybookList(String book_name, String borrowDate, String returnDate) {
        this.book_name = book_name;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public MybookList(String book_name, String borrowDate, String returnDate, int extension, String book_code) {
        this.book_name = book_name;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.extension = extension;
        this.book_code = book_code;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }


    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "MybookList{" +
                "book_name='" + book_name + '\'' +
                ", borrowDate='" + borrowDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
