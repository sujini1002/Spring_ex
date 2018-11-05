package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.admin.service.AdminDeleteService;

@Controller
@RequestMapping("/admin/adminAccount/adminDelete")
public class AdminAdminAccDelController {

	@Autowired
	AdminDeleteService adminDeleteService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimAdminAccRegForm(@RequestParam("admin") String admin_id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/adminAccount");

		int resultCnt = adminDeleteService.deleteAdmin(admin_id);
		if (resultCnt == 0) {
			// 삭제 실패시
			modelAndView.addObject("msg", "관리자 삭제에 실패하였습니다.");
		}
		return modelAndView;
	}
}
