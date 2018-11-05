package com.bit.lib.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookInsertService;

@Controller
@RequestMapping("/admin/book/bookInsert")
public class BookInsertController {

	@Autowired
	private BookInsertService service;

	@RequestMapping(method = RequestMethod.POST)
	public String bookInsert(BookInfo bookInfo) {

		String url = "/admin/book/bookInsertOk";

		int resultCnt = service.bookInsert(bookInfo);
		
		return url;
	}

}
