package com.bit.lib.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.aladin.model.AladinDataVO;
import com.bit.lib.aladin.service.AladinBookAPIService;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.service.BookUserViewService;

@Controller
@RequestMapping("/member/book/bookView")
public class BookUserViewController {

	@Autowired
	private BookUserViewService service;
	
	@Autowired
	private AladinBookAPIService aladinBookAPIService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	public ModelAndView bookView(@RequestParam("book_isbn") String book_isbn) {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/book/bookView");

		System.out.println("컨트롤러");
		try {

			BookInfo bookInfo = service.bookView(book_isbn);
			String bookExist = service.bookExist(book_isbn);
			List<BookInfo> list = service.bookCodeList(book_isbn);

			modelAndView.addObject("bookInfo", bookInfo);
			modelAndView.addObject("bookExist", bookExist);
			modelAndView.addObject("bookCodeList", list);

			// 알라딘추가
			String isbn13 = book_isbn.substring(11, 24); // 저장된 ISBN 중 ISBN13만 사용
			AladinDataVO aladinDataVO = aladinBookAPIService.getAladinData(isbn13);
			modelAndView.addObject("ad", aladinDataVO);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return modelAndView;
	}
}
