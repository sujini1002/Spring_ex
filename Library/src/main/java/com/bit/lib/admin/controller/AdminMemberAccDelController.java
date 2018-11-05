package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.service.MemberDeleteService;

@Controller
@RequestMapping("/admin/memberAccount/memberDelete")
public class AdminMemberAccDelController {

	@Autowired
	MemberDeleteService memberDeleteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimMemberAccRegForm(@RequestParam("member") String member_id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/memberAccount");

		int resultCnt = memberDeleteService.deleteMember(member_id);
		if (resultCnt == 0) {
			// 삭제 실패시
			modelAndView.addObject("msg", "회원 삭제에 실패하였습니다.");
		}
		return modelAndView;
	}
}
