package com.openproject.openproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.openproject.openproject.model.MemberInfo;
import com.openproject.openproject.service.MemberRegService;

@Controller
@RequestMapping("/member/memberReg")
public class MemberRegController {
	
	@Autowired
	private MemberRegService regService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getMemberRegForm() {
		return "member/memberRegForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView getMemberReg(MemberInfo member,HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("member/regok");
		try {
			int resultCnt = 0;
			try {
				resultCnt = regService.memberReg(member,request);
			} catch (IllegalStateException e) {
				modelAndView.setViewName("member/regFail");
			} catch (IOException e) {
				modelAndView.setViewName("member/regFail");
			}
			if(resultCnt < 1) {
				modelAndView.setViewName("member/regFail");
			}
		} catch (SQLException e) {
			modelAndView.setViewName("member/regFail");
			e.printStackTrace();
		}
		return modelAndView;
	}
}
