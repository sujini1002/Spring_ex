package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.admin.model.AdminVO;
import com.bit.lib.admin.service.AdminPermissionService;
import com.bit.lib.admin.service.AdminRegService;

@Controller
@RequestMapping("/admin/adminAccount/adminReg")
public class AdminAdminAccRegController {

	@Autowired
	AdminRegService adminRegService;

	@Autowired
	AdminPermissionService adminPermissionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimAdminAccRegForm() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("permissions", adminPermissionService.getPermissionNames());
		modelAndView.setViewName("/admin/adminAccount/adminRegForm");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView regAdmimAdminAcc(AdminVO av) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/adminAccount");
		int resultCnt = adminRegService.insertAdmin(av);

		// 회원가입에 실패했을 경우
		if (resultCnt != 1) {
			modelAndView.addObject("msg", "관리자 등록에 실패하였슶니다.");
			modelAndView.setViewName("/admin/adminAccount/adminRegForm");
		}
		return modelAndView;
	}
}
