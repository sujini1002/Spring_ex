package com.bitcamp.gb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.gb.model.MessageListView;
import com.bitcamp.gb.service.GetMessageListService;
import com.bitcamp.gb.service.ServiceException;

@Controller

public class GuestBookListController {
	
	@Autowired  //List를 받는 것을 주입받는다.
	private GetMessageListService service;
	
	/*@RequestMapping("/guest/list")
	public ModelAndView getGuestList(HttpServletRequest request) throws ServiceException {
		String pageNumberStr = request.getParameter("page");
		int pageNumber = 1;
		if (pageNumberStr != null) {
			pageNumber = Integer.parseInt(pageNumberStr);
		}
		//GetMessageListService messageListService = GetMessageListService.getInstance();
		MessageListView viewData = service.getMessageList(pageNumber);
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guest/list");
		//view에 결과 데이터를 공유(전달)
		modelAndView.addObject("listView", viewData);
		
		return modelAndView;
	}*/
	
	@RequestMapping("/guest/list")
	public ModelAndView getList(@RequestParam(value="page",defaultValue="1")int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guest/list");
		MessageListView listView = service.getMessageList(pageNumber);
		modelAndView.addObject("listView", listView);
		
		return modelAndView;
	}
}
