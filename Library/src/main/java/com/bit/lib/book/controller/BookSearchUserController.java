package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookSearchUserService;

@Controller
@RequestMapping("/member/book/searchBook")
public class BookSearchUserController {
	
	@Autowired
	private BookSearchUserService service;
	
	// -추가시작-
	@RequestMapping(method= {RequestMethod.GET,RequestMethod.POST})
	public ModelAndView bookSearchGet(@RequestParam("keyword")String keyword,
									  @RequestParam(value="nowPageNum",required=false,defaultValue="1")int nowPageNum) {
		
		ModelAndView modelAndView = new ModelAndView();
		//공백제거
		keyword = keyword.replaceAll(" ", "");
		
		List<BookInfo> list = service.searchBook(keyword,nowPageNum);
		int bookCount = service.bookCountAll();
		
		modelAndView.addObject("bookList", list);
		modelAndView.addObject("keyword", keyword);
		modelAndView.addObject("bookCount", bookCount);
		modelAndView.setViewName("member/book/searchBookList");
		
		return modelAndView;
	}
	// -추가끝-

	/*@RequestMapping(method=RequestMethod.POST)
	public ModelAndView bookSearch(@RequestParam("keyword")String keyword,
								   @RequestParam(value="nowPageNum",required=false,defaultValue="1")int nowPageNum) {
		
		ModelAndView modelAndView = new ModelAndView();
		//공백제거
		keyword = keyword.replaceAll(" ", "");
		
		List<BookInfo> list = service.searchBook(keyword,nowPageNum);
		
		modelAndView.addObject("bookList", list);
		modelAndView.addObject("keyword", keyword);
		modelAndView.setViewName("member/book/searchBookList");
		
		return modelAndView;
	}*/
}
//주석
