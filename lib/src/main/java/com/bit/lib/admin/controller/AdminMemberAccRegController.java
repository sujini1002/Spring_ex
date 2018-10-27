package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.model.MemberVO;
import com.bit.lib.member.service.MemberListService;
import com.bit.lib.member.service.MemberRegService;

@Controller
@RequestMapping("/admin/memberAccount/memberReg")
public class AdminMemberAccRegController {

	@Autowired
	MemberRegService memberRegService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimMemberAccRegForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/memberAccount/memberRegForm");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView regAdmimMemberAcc(MemberVO mv) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin/memberAccount/memberReg");
		int resultCnt = memberRegService.insertMember(mv);

		if (resultCnt != 1) {
			// 가입실패처리
		}
		return modelAndView;
	}
}
