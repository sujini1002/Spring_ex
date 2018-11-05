package com.bit.lib.umki.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ReplyInfo;
import com.bit.lib.umki.service.GetContentService;
import com.bit.lib.umki.service.GetWriteContentService;


@Controller
public class ViewController {
	
	@Autowired
	GetContentService service;
	@Autowired
	GetWriteContentService service2;
	int nextCk = 1;
	int prevCk = 1;
	String check1 = "";
	
	
	@RequestMapping("member/home/view")
	public ModelAndView view(@RequestParam("idx") int idx, @RequestParam(value="check", required=false) String check) {
		
		ModelAndView modelAndView = new ModelAndView();
		ListInfo listInfo = service.getContentIdxNext(idx, check);
		List<ReplyInfo> replyInfo = service2.getReplyContent(idx); //댓글처리
		check = service.getNextPreInfo(idx);
		
		modelAndView.setViewName("member/list/view");
		modelAndView.addObject("listInfo", listInfo);
		modelAndView.addObject("replyInfo", replyInfo);
		modelAndView.addObject("check", check);
		
		return modelAndView;
	}
}
