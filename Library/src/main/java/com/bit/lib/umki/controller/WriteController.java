package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.service.GetWriteContentService;
import com.bit.lib.umki.service.GetWriteService;

@Controller
@RequestMapping("/member/home/writeForm")
public class WriteController {
	
	@Autowired
	GetWriteService service1;
	@Autowired
	GetWriteContentService service2;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getWriteForm() {
		return "member/list/writeForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView write(ListInfo listInfo) {
		ModelAndView modelAndView = new ModelAndView();
		service1.write(listInfo);
		ListInfo listInfo2 = service2.getContent(listInfo.getList_name());
		modelAndView.setViewName("redirect:/member/home/view?idx="+listInfo2.getIdx());
		modelAndView.addObject("listInfo", listInfo2);
		return modelAndView;
	}
}
