package com.bit.lib.umki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
	@RequestMapping(value="/member/home/list", method = RequestMethod.GET)	
	public ModelAndView getList(@RequestParam(value="page", required=false) String pageStr) {
		ModelAndView modelAndView = new ModelAndView();
		int pageNum = 1;
		if (pageStr != null) {
			pageNum = Integer.parseInt(pageStr);
		}
		List<ListInfo> viewInfo = listService.getList(pageNum);
		ViewInfo page = pageService.getPageTotalNum(pageNum);
		
		modelAndView.setViewName("member/list/list");
		modelAndView.addObject("viewInfo", viewInfo);
		modelAndView.addObject("page", page);
		
		
		return modelAndView;
	}
	
	@RequestMapping(value="/member/home/list", method = RequestMethod.POST)
	public ModelAndView getSearchList(@RequestParam("content") String content, @RequestParam("select") String select) {
		ModelAndView modelAndView = new ModelAndView();
		int pageNum = 1;
		List<ListInfo> viewInfo = listService.getSearchList(select, content);
		ViewInfo page = new ViewInfo(1, pageNum, 15);
		modelAndView.setViewName("member/list/list");
		modelAndView.addObject("viewInfo", viewInfo);
		modelAndView.addObject("page", page);
		
		return modelAndView;
	}
}

















