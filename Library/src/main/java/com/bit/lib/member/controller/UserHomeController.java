package com.bit.lib.member.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.aladin.model.AladinDataVO;
import com.bit.lib.aladin.service.AladinBookAPIService;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.member.service.UserHomeService;

@Controller
public class UserHomeController {

	@Autowired
	private UserHomeService service;

	@Autowired
	private AladinBookAPIService aladinBookAPIService;

	@RequestMapping("/member/home")
	public ModelAndView getMemberHome() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/member/home");

		List<BookInfo> list = service.bookNewList();
		modelAndView.addObject("bookList", list);
		// 알라딘 추가
		int getObjsize = list.size();

		List<AladinDataVO> ads = new ArrayList<AladinDataVO>();
		for (int i = 0; i < getObjsize; i++) {
			ads.add(aladinBookAPIService.getAladinData(list.get(i).getBook_isbn().substring(11, 24)));
		}
		modelAndView.addObject("ads", ads);

		// 알라딘 추가 끝
		return modelAndView;
	}
}
