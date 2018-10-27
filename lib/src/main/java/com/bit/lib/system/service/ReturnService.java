package com.bit.lib.system.service;

import com.bit.lib.member.model.MemberVO;
import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.model.Borrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class ReturnService {
    @Autowired
    private BorrowDao borrowDao;

    public boolean returnOk(String book_code) throws ParseException {

        Borrow borrow = borrowDao.selectByBook_code(book_code);

        int day = borrowDao.getDay(borrow.getReturnDate());

        if(day>0) {
            DateFormat dateFormat;
            dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar caldate = Calendar.getInstance();
            //Member member = memberDao.select(borrow.getMember_id);
            //if("possible".equals(member.getPossibledate()){

            // }else{
            //Date date = dateFormat.parse(member.getPossibleDate());
            //caldate.setTime(date);
        //}
            //caldate.add(Calendar.Date,day);
            //member.setPossibleDate(dateFormat.format(caldate);
            // dao.updateByPossible(member);
            //
             }

        return true;

    }


}
