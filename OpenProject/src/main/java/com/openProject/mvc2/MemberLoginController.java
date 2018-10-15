package com.openProject.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/login")
public class MemberLoginController {
	//@RequestMapping("/member/login")
	//@RequestParam(value="pageNo",required=false)
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getLoginForm(String pageNO ) { //int는 null값이 들어 올 수 없다.
		return new ModelAndView("member/loginForm");
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView loginProcess(@RequestParam(value="userId",defaultValue="nullId") String userId,
							   @RequestParam(value="password",required=true)String password) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/loginOk");
		
		System.out.println(userId + " : " + password);
		
		modelAndView.addObject("userId", userId);
		modelAndView.addObject("password", password);
		
		return modelAndView;
		
	}
}
