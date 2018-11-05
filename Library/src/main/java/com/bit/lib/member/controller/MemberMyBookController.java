package com.bit.lib.member.controller;

import com.bit.lib.system.model.MybookList;
import com.bit.lib.system.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member/memberAccount/myBook")
public class MemberMyBookController {
	@Autowired
	private MyBookService myBookService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimMemberAccRegForm(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
			List<MybookList> mybookLists= myBookService.bookInfoList(session);
			modelAndView.addObject("mybookList",mybookLists);

		modelAndView.setViewName("/member/memberAccount/myBook");

		return modelAndView;
	}
}
