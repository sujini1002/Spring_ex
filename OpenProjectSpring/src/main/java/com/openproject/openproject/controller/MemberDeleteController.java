 package com.openproject.openproject.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openproject.openproject.service.MemberDeleteService;

@Controller
@RequestMapping("/member/delete")
public class MemberDeleteController {
	
	@Autowired
	private MemberDeleteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String deleteForm(@RequestParam("id")String userId,Model model) {
		
		model.addAttribute("userId", userId);
		return "member/deleteForm";
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String delete(@RequestParam("userId")String userId,@RequestParam("userPw")String userPw) {
		int resultCnt = 0;
		String url = "redirect:/member/logout";
		try {
			resultCnt = service.deleteMember(userId, userPw);
			if(resultCnt <1) {
				url = "member/deleteFail";
			}
		} catch (SQLException e) {
			url = "member/deleteFail";
		}
		return url;
	}
}
