package com.bitcamp.gb.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.gb.model.Message;
import com.bitcamp.gb.service.ServiceException;
import com.bitcamp.gb.service.WriteMessageService;

@Controller
@RequestMapping("/guest/write")
public class GuestBookWriteController {
	
	@Autowired
	WriteMessageService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public String writeForm() {
		// view이름을 디스패쳐서블릿에  반환한다. 
		//그럼 디스패쳐서블릿에서(/WEB-INF/views/guest/writeForm.jsp)가 있는지 viewResolve에물어본다
		// 스프링 컨테이너에서 <beans:property name="prefix" value="/WEB-INF/views/" />
		//<beans:property name="suffix" value=".jsp" />을 붙인다.
		//viewResolve에서 디츠패처서블릿에서 받은 view네임이 있는지 확인하고 있으면 해당 view로 넘어간다.
		return "guest/writeForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String writeMessage(Message message) throws ServiceException{
		
		service.write(message);
		
		
		return "redirect:/guest/list";
		
	}
}
