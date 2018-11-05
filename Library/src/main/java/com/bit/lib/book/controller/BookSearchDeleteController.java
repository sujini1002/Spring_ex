package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookSearchDeleteService;

@Controller
@RequestMapping("/admin/book/searchDeleteBook")
public class BookSearchDeleteController {
	
	@Autowired
	private BookSearchDeleteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String searchBookList(@RequestParam(value="page",required=false,defaultValue="1")int page,Model model) {
		List<BookInfo> list= service.searchBookAll(page); 
		int totalPageNum = service.pageNumber();
		model.addAttribute("bookList", list);
		model.addAttribute("totalPageNum", totalPageNum);
		return "admin/book/searchBookDeleteView";
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView resultBookList(@RequestParam("searchWord")String searchWord,
									   @RequestParam("keyword")String keyword) {
		
		keyword = keyword.replaceAll(" ", "");
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("admin/book/searchBookDeleteView");
		
		List<BookInfo> bookList = service.searchBook(searchWord, keyword);
		
		modelAndView.addObject("bookList", bookList);
		
		return modelAndView;
	}
}
