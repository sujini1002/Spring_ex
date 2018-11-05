package com.bit.lib.umki.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.service.GetContentService;
import com.bit.lib.umki.service.GetUpdateService;

@Controller
@RequestMapping("/member/home/update")
public class UpdateController {
	
	@Autowired
	GetContentService service1;
	@Autowired 
	GetUpdateService service2;
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView getUpdateForm(@RequestParam("idx") int idx) {
		ModelAndView modelAndView = new ModelAndView();
		ListInfo listInfo = service1.getContentIdx(idx);
		
		modelAndView.setViewName("member/list/updateForm");
		modelAndView.addObject("listInfo", listInfo);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView update(ListInfo listInfo) {
		ModelAndView modelAndView = new ModelAndView();
		service2.update(listInfo);
		
		ListInfo listInfo2 = service1.getContentIdx(listInfo.getIdx());
		modelAndView.setViewName("member/list/view");
		modelAndView.addObject("listInfo", listInfo2);
		
		return modelAndView;
	}

}
