package com.bit.lib.system.controller;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class BookSearchController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "admin/borrow/bookSearch", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public List<BookInfo> Search(@RequestParam("bookname") String bookname) {

        return borrowService.getBookCode(bookname);
    }

}
