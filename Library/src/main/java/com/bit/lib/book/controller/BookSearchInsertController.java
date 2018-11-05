package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookSearchInsertService;


@Controller
@RequestMapping("/admin/book/searchInsertBook")
public class BookSearchInsertController {
	
	@Autowired
	private BookSearchInsertService serivce;
	
	@RequestMapping(method=RequestMethod.GET)
	public String searchBookView() {
		return "admin/book/searchBookInsertView";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView searchBookList(@RequestParam("optionCode") String option,
									   @RequestParam("keyword")String keyword,
									   @RequestParam("listCnt")int listCnt) {
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<BookInfo> bookList;
		
		try {
			bookList = serivce.bookList(option, keyword,listCnt);
			modelAndView.addObject("bookList", bookList);
			modelAndView.setViewName("admin/book/searchBookInsertView");
		} catch (Exception e) {
			
		}
		
		return modelAndView;
	}
}
