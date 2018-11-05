package com.bit.lib.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.book.service.BookCheckCodeService;

@Controller
@RequestMapping("/admin/book/bookCodeCheck")
public class BookCheckCodeController {
	
	@Autowired
	private BookCheckCodeService service;
	
	@RequestMapping(method=RequestMethod.GET,produces = "text/json; charset=UTF-8")
	@ResponseBody
	public String bookCodeCheck(@RequestParam("book_code")String book_code) {
		//"{\"resultCnt\":\""+service.bookCodeCheck(book_code)+"\"}";
		int resultCnt = service.bookCodeCheck(book_code);
		String resultMsg = "사용가능한 북코드 입니다.";
		if(resultCnt>0) {
			resultMsg = "사용 !불가능한! 북코드 입니다.";
		}
		String resultJson = "{\"resultCnt\":\""+resultCnt+"\""
							+",\"resultMsg\":\""+resultMsg
							+"\"}";
		
		System.out.println("컨트롤러"+resultJson);
		return resultJson;
	}
	
	//주석
}
