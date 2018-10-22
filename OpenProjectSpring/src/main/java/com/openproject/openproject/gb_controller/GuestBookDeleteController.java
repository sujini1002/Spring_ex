package com.openproject.openproject.gb_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openproject.openproject.gb_service.GuestBookDeleteService;
import com.openproject.openproject.gb_service.InvalidMessagePassowrdException;
import com.openproject.openproject.gb_service.MessageNotFoundException;
import com.openproject.openproject.gb_service.ServiceException;

@Controller
@RequestMapping("/guest/delete")
public class GuestBookDeleteController {
	@Autowired
	private GuestBookDeleteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getDeleteForm(@RequestParam("id")String id,Model model) {
		//													공유할 수 있는 데이터를  받을 수 있다.
		model.addAttribute("mId", id);
		return "guest/confirmDelete"; 
	 }
	@RequestMapping(method=RequestMethod.POST)
	public String deleteMessage(@RequestParam("messageId") int mId,
								@RequestParam("password") String pw) 
	{
		String viewName = "redirect:/guest/list";
		
			try {
				service.deleteMessage(mId, pw);
			} catch (ServiceException e) {
				viewName = "redirect:/guest/error";
			} catch (InvalidMessagePassowrdException e) {
				viewName = "redirect:/guest/delete?id="+mId;
			} catch (MessageNotFoundException e) {
				viewName = "redirect:/guest/list";			}
		// /가 없으면 상대경로 /가 있으면 절대경로
		
		return viewName;
		
	}
}
