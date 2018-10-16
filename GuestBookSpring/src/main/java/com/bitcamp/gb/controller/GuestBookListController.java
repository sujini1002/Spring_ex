package com.bitcamp.gb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.gb.model.MessageListView;
import com.bitcamp.gb.service.GetMessageListService;
import com.bitcamp.gb.service.ServiceException;

@Controller
public class GuestBookListController {
	
	@Autowired  //List를 받는 것을 주입받는다.
	private GetMessageListService service;
	
	@RequestMapping("/guestbook/list")
	public ModelAndView getList(@RequestParam(value="page",defaultValue="1")int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guestbook/list");
		MessageListView listView = service.getMessageList(pageNumber);
		modelAndView.addObject("listView", listView);
		
		return modelAndView;
	}
}
