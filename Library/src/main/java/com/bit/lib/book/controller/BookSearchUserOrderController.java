package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.model.OrderParam;
import com.bit.lib.book.service.BookSearchUserOrderService;

@Controller
@RequestMapping("/member/book/bookOrderBy")
public class BookSearchUserOrderController {
	
	@Autowired
	private BookSearchUserOrderService service;
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public List<BookInfo> bookOrderList(OrderParam orderParam){
		System.out.println(orderParam);
		
		List<BookInfo> bookList = service.bookList(orderParam);
		
		return bookList;
	}
}
