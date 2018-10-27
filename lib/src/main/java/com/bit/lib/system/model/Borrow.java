package com.bit.lib.system.model;

import java.util.Date;

public class Borrow {
    private String book_code;
    private String member_id;
    private String borrowDate;
    private String returnDate;


    public Borrow(){}

    public Borrow(String book_code, String member_id) {
        this.book_code = book_code;
        this.member_id = member_id;
    }

    public Borrow(String book_code, String member_id, String borrowDate, String returnDate) {
        this.book_code = book_code;
        this.member_id = member_id;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getBook_code() {
        return book_code;
    }

    public void setBook_code(String book_code) {
        this.book_code = book_code;
    }

    public String getMember_id() {
        return member_id;
    }

    public void setMember_id(String member_id) {
        this.member_id = member_id;
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
}
