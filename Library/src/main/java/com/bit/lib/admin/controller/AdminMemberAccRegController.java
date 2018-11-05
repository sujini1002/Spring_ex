package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.model.MemberVO;
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
		modelAndView.setViewName("redirect:/admin/memberAccount");
		int resultCnt = memberRegService.insertMember(mv);

		// 회원가입에 실패했을 경우
		if (resultCnt != 1) {
			modelAndView.addObject("msg", "회원 등록에 실패하였슶니다.");
			modelAndView.setViewName("/admin/memberAccount/memberRegForm");
		}
		return modelAndView;
	}
}
