package com.openproject.openproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.openproject.openproject.model.MemberInfo;
import com.openproject.openproject.service.MemberUpdateService;

@Controller
@RequestMapping("/member/update")
public class MemberUpdateController {

	@Autowired
	private MemberUpdateService service;

	@RequestMapping(method = RequestMethod.GET)
	public String updateForm(@RequestParam("id") String userid, Model model) {

		String url = "member/updateForm";
		try {
			MemberInfo member = service.selectUser(userid);
			model.addAttribute("memberInfo", member);
		} catch (SQLException e) {
			url = "member/updateFormFail";
		}

		// member_spring에서 해당 아이디를 찾아 memberInfo에 저장한다.
		return url;

	}

	@RequestMapping(method=RequestMethod.POST)
	public String update(MemberInfo memberInfo, HttpServletRequest request) {

		int resultCnt = 0;
		String url = "redirect:/member/list";

		try {
			resultCnt = service.updateMember(memberInfo, request);
			if (resultCnt < 1) {
				url = "member/updateFail";
			}
		} catch (IllegalStateException e) {
			url = "member/updateFail";
		} catch (IOException e) {
			url = "member/updateFail";
		}

		return url;
	}
}
