package com.openproject.openproject.gb_controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.openproject.gb_model.MessageListView;
import com.openproject.openproject.gb_service.GuestBookListService;
import com.openproject.openproject.gb_service.ServiceException;

@Controller
public class GuestBookListController {
	
	@Autowired
	private GuestBookListService service;
	
	
	@RequestMapping("/guest/list")
	public ModelAndView getList(@RequestParam(value="page",defaultValue="1")int pageNumber) throws ServiceException {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("guest/list");
		MessageListView listView;
		try {
			listView = service.getMessageList(pageNumber);
			modelAndView.addObject("listView", listView);
		} catch (SQLException e) {
			modelAndView.setViewName("guest/listFail");
		}
		
		return modelAndView;
	}
	
	
}
