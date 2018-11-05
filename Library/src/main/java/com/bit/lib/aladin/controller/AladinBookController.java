package com.bit.lib.aladin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.aladin.model.AladinDataVO;
import com.bit.lib.aladin.service.AladinBookAPIService;

@Controller
@CrossOrigin("*")
public class AladinBookController {

	@Autowired
	AladinBookAPIService aladinBookAPIService;

	@RequestMapping(value = "/member/aladin/getAladinData", method = RequestMethod.GET)
	@ResponseBody
	public AladinDataVO getAladinData(@RequestParam("isbn13") String book_isbn13) throws Exception {
		// return aladinBookAPIService.getAladinAPIaddr(book_isbn13);
		// http://deoki.tistory.com/54
		

		
		return aladinBookAPIService.getAladinData(book_isbn13);

	
		// https://spring.io/guides/gs/rest-service-cors/
	}
}
