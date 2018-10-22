package com.openproject.openproject.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.openproject.openproject.model.MemberInfo;
import com.openproject.openproject.service.MemberListService;

@Controller
public class MemberListController {
	
	@Autowired
	private MemberListService service;
	
	@RequestMapping("/member/list")
	public String memberList(Model model) {
		
		List<MemberInfo> list;
		String url = "";
		
		try {
			list = service.memberSelect();
			model.addAttribute("list", list);
			url = "member/memberList";
		} catch (SQLException e) {
			url = "member/meberListFail";
		}
		
		return url;
	}
}
