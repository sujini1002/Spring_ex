package com.bit.lib.system.service;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.member.model.MemberVO;
import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.model.MybookList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class MyBookService {

    @Autowired
    private BorrowDao borrowDao;

    public List<MybookList> bookInfoList(HttpSession session){
       MemberVO member= (MemberVO) session.getAttribute("memberLoginInfo");

       String member_id=  member.getMember_id();
       MybookList mybookList = new MybookList();
       mybookList.setMember_id(member_id);
    return borrowDao.myBookList(mybookList);
    }
}
