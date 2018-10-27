package com.bit.lib.umki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ViewInfo;
import com.bit.lib.umki.service.GetListPageService;
import com.bit.lib.umki.service.GetListService;

@Controller
public class ListController {
	
	@Autowired
	GetListService listService;
	@Autowired
	GetListPageService pageService;
	
	@RequestMapping("/member/home/list")
	public ModelAndView getList(@RequestParam("page") String pageStr) {
		ModelAndView modelAndView = new ModelAndView();
		int pageNum = 1;
		if (pageStr != null) {
			pageNum = Integer.parseInt(pageStr);
		}
		List<ListInfo> viewInfo = listService.getList(pageNum);
		ViewInfo page = pageService.getPageTotalNum(pageNum);
//		System.out.println(page);
		modelAndView.setViewName("member/list/list");
		modelAndView.addObject("viewInfo", viewInfo);
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}
}

















