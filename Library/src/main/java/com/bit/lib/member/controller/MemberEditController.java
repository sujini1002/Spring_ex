package com.bit.lib.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.member.model.MemberVO;
import com.bit.lib.member.service.MemberEditService;

@Controller
@RequestMapping("/member/memberAccount/editMember")
public class MemberEditController {

	@Autowired
	MemberEditService memberEditService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEditForm(@RequestParam("member") String member_id) {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.addObject("mv", memberEditService.getEditMember(member_id));
		modelAndView.setViewName("/member/memberAccount/memberEditForm");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView editMember(MemberVO mv, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();

		// 회원 정보 수정시, 세션의 값도 변경해준다
		memberEditService.editMember(mv);
		// DB 업데이트 후에 세션값 업데이트
		session.removeAttribute("memberLoginInfo");
		mv.setPassword(""); // 보안을 위해 비밀번호 공백 처리
		session.setAttribute("memberLoginInfo", mv);
		modelAndView.setViewName("redirect:/member/memberAccount/myPage");
		return modelAndView;
	}

}
