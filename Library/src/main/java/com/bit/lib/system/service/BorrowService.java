package com.bit.lib.system.service;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;
import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.model.Borrow;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private BookInterfaceDao bookDao;

    public MemberVO selectMember(String member_id) {
        return memberDao.selectOneMember(member_id);
    }

    public List<MemberVO> searchMember(String member_id) {
        List<MemberVO> list = memberDao.selectSearchMember(member_id);

        return list;
    }

    public boolean isPossible(MemberVO member) {
        boolean possible = false;
        if ("possible".toUpperCase().equals(member.getPossibledate().toUpperCase()) && member.getAvailAmount() > 0) {
            possible = true;
        }
        return possible;
    }

    @Transactional
    public boolean rent(Borrow borrow, List<String> booklist) {
        boolean rentOk = false;

        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Calendar today = Calendar.getInstance();
        Date d = new Date(today.getTimeInMillis());
        borrow.setBorrowDate(dateFormat.format(d));

        today.add(Calendar.DATE, 7);
        d = new Date(today.getTimeInMillis());
        borrow.setReturnDate(dateFormat.format(d));

        for (int i = 0; i < booklist.size(); i++) {

            borrow.setBook_code(booklist.get(i));
            System.out.println(borrow.getBook_code());
            int rentSuccess = borrowDao.insert(borrow);
            if (rentSuccess == 1) {
                availAmountUpdate(borrow.getMember_id());
                book_existUpdate(borrow.getBook_code());
                rentOk = true;
            }
        }
        return rentOk;
    }

    private void book_existUpdate(String book_code) {
        BookInfo book = new BookInfo();
        book.setBook_code(book_code);
        book.setBook_exist(0);
        bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
        //책 book_exist 업데이트
        bookDao.updateBook_exist(book);
    }

    private void availAmountUpdate(String member_id) {
        MemberVO member = memberDao.selectOneMember(member_id);
        member.setAvailAmount(member.getAvailAmount() - 1);
        memberDao.updateAvailAmount(member);
    }

    public List<BookInfo> getBookCode(String bookname) {
        List<BookInfo> list = borrowDao.getBook_code(bookname);
        return list;
    }

}
