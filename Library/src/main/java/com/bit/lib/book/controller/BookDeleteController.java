package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookDeleteService;

@Controller
@RequestMapping("/admin/book/bookDelete")
public class BookDeleteController {
	
	@Autowired
	private BookDeleteService service;
	
	
	@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<BookInfo> bookDelete(@RequestParam("book_code")String book_code) {
		System.out.println("북코드는 :"+book_code);
		
		int result=service.bookDelete(book_code);
		System.out.println("삭제"+result);
		
		List<BookInfo> bookList = service.afterDelete();
		System.out.println(bookList);
		
		return bookList;
	}
}
