package com.bit.lib.system.service;

import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.model.Borrow;
import com.bit.lib.system.model.MybookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ExtensionService {

    @Autowired
    private BorrowDao borrowDao;

    public int extension(MybookList mybookList) {
        mybookList.setExtension(1);
        return borrowDao.updateExtension(mybookList);
    }
    public int extensionNo(String book_code) {
        MybookList mybookList = new MybookList();
        mybookList.setBook_code(book_code);
        mybookList.setExtension(0);
        return borrowDao.updateExtension(mybookList);
    }
    public List<MybookList> getList() {
        return borrowDao.myBookList(new MybookList());
    }

    public int getCount() {
        return borrowDao.countExtension();
    }

    public void extensionOk(String book_code) {
        MybookList mybookList = new MybookList();
        mybookList.setBook_code(book_code);
        List<MybookList> list = borrowDao.myBookList(mybookList);
        mybookList = list.get(0);
        DateFormat dateFormat;
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar caldate = Calendar.getInstance();

        Date date = null;
        try {
            date = dateFormat.parse(mybookList.getReturnDate());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        caldate.setTime(date);
        caldate.add(Calendar.DATE, 7);
        date = new Date(caldate.getTimeInMillis());
        System.out.println(dateFormat.format(date));
        mybookList.setReturnDate(dateFormat.format(date));
        mybookList.setExtension(-1);
        mybookList.setBook_code(book_code);

        borrowDao.updateExtensionreturndate(mybookList);

    }

}
