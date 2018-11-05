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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Service
public class ReturnService {
    @Autowired
    private BorrowDao borrowDao;

    @Autowired
    private MemberDao memberDao;

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    private BookInterfaceDao bookDao;

    @Transactional
    public HashMap<String, String> returnOk(String book_code) throws ParseException {
        HashMap<String, String> map = new HashMap<String, String>();

        Borrow borrow = borrowDao.selectByBook_code(book_code);
        if(borrow!=null) {
            int day = borrowDao.getDay(borrow.getReturnDate());
            int allBorrwDay = borrowDao.getDay(borrow.getBorrowDate());
            MemberVO member = memberDao.selectOneMember(borrow.getMember_id());
            map.put("username", member.getName());

            if (day > 0) {
                map.put("msg", day + "일 연체되었으며");
                DateFormat dateFormat;
                dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar caldate = Calendar.getInstance();
            member.setTotoverduedays(member.getTotoverduedays()+day);
            if (!("possible".toUpperCase().equals(member.getPossibledate().toUpperCase()))) {
                Date date = dateFormat.parse(member.getPossibledate());
                caldate.setTime(date);
            }
            caldate.add(Calendar.DATE, day);
            member.setPossibledate(dateFormat.format(new Date(caldate.getTimeInMillis())));
            map.put("msg", day + "일 연체되었으며"+member.getPossibledate()+"에 대여가능합니다.");
            borrowDao.updatePossible(member);
        } else {
            map.put("msg", "정상적으로 반납이 완료 되었습니다 ");
        }

        member.setTotborrowDays(member.getTotborrowDays()+allBorrwDay+1);
        availAmountUpdate(member);
        book_existUpdate(book_code);
        borrowDao.delete(borrow);
    }else{
            map.put("msg","대여 중인 북코드가 아닙니다.");
        }
        return map;

    }

    private void book_existUpdate(String book_code) {
        BookInfo book = new BookInfo();
        book.setBook_code(book_code);
        book.setBook_exist(1);
        bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
        //책 book_exist 업데이트
        bookDao.updateBook_exist(book);
    }

    private void availAmountUpdate(MemberVO memberVO) {
        memberVO.setAvailAmount(memberVO.getAvailAmount() + 1);
        memberDao.updateAvailAmount(memberVO);
    }

}
