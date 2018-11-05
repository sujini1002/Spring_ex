package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.model.MemberVO;
import com.bit.lib.member.service.MemberEditService;

@Controller
@RequestMapping("/admin/memberAccount/memberEdit")
public class AdminMemberAccEditController {

	@Autowired
	MemberEditService memberEditService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimMemberAccEditForm(@RequestParam("member") String member_id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("mv", memberEditService.getEditMember(member_id));
		modelAndView.setViewName("/admin/memberAccount/memberEditForm");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editAdmimMemberAcc(MemberVO mv) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/memberAccount");
		int resultCnt = memberEditService.editMember(mv);

		// 회원수정에 실패했을 경우
		if (resultCnt != 1) {
			modelAndView.addObject("msg", "회원 수정에 실패하였슶니다.");
			modelAndView.setViewName("/admin/memberAccount/memberEditForm");
		}
		return modelAndView;
	}
}
