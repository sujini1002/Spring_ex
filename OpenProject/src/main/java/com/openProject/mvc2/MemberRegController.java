package com.openProject.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openProject.mvc2.model.MemberInfo;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getMemberReg() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/memberRegForm");
		//        /WEB-INF/views/
		
		return modelAndView;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView memberReg(MemberInfo member) {
		
		System.out.println(member);
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.setViewName("member/regok");
		
		return modelAndView;
	}
}
