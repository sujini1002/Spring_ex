package com.bit.lib.system.model;

import com.bit.lib.member.model.MemberVO;

import java.util.List;

public class BorrowBookList {
 private MemberVO member;
 private List<String> booklist;

    public BorrowBookList() {
    }

    public BorrowBookList(MemberVO member, List<String> booklist) {
        this.member = member;
        this.booklist = booklist;
    }

    public MemberVO getMember() {
        return member;
    }

    public void setMember(MemberVO member) {
        this.member = member;
    }

    public List<String> getBooklist() {
        return booklist;
    }

    public void setBooklist(List<String> booklist) {
        this.booklist = booklist;
    }

    @Override
    public String toString() {
        return "BorrowBookList{" +
                "member=" + member +
                ", booklist=" + booklist +
                '}';
    }
}
