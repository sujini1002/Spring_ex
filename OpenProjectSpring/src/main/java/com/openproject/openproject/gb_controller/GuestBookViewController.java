package com.openproject.openproject.gb_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openproject.openproject.gb_model.Message;
import com.openproject.openproject.gb_service.GuestBookViewService;

@Controller
public class GuestBookViewController {
	@Autowired
	private GuestBookViewService service;

	@RequestMapping("/guest/view/{id}")
	public String getView(@PathVariable("id") int id, Model model) {
		String uri = "guest/view";
		Message message;
			
		message = service.messageSelect(id);
		model.addAttribute("id", id);
		model.addAttribute("message", message);

		return uri;
	}
}
