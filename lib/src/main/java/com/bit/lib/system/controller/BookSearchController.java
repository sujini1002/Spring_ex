package com.bit.lib.system.controller;

import com.bit.lib.system.dao.BorrowDao;
import com.bit.lib.system.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookSearchController {

    @Autowired
    private BorrowService borrowService;

    @RequestMapping(value = "admin/borrow/bookSearch")
    @ResponseBody
    public String Search() {

        return "";
    }

}
