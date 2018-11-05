package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bit.lib.admin.model.AdminVO;
import com.bit.lib.admin.service.AdminEditService;
import com.bit.lib.admin.service.AdminPermissionService;

@Controller
@RequestMapping("/admin/adminAccount/adminEdit")
public class AdminAdminAccEditController {

	@Autowired
	AdminEditService adminEditService;
	
	@Autowired
	AdminPermissionService adminPermissionService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getAdmimAdminAccRegForm(@RequestParam("admin") String admin_id) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("av", adminEditService.getEditAdmin(admin_id));
		modelAndView.addObject("permissions", adminPermissionService.getPermissionNames());
		modelAndView.setViewName("/admin/adminAccount/adminEditForm");
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView regAdmimAdminAcc(AdminVO av) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/admin/adminAccount");
		int resultCnt = adminEditService.editAdmin(av);

		// 회원수정에 실패했을 경우
		if (resultCnt != 1) {
			modelAndView.addObject("msg", "회원 수정에 실패하였슶니다.");
			modelAndView.setViewName("/admin/adminAccount/adminEditForm");
		}
		return modelAndView;
	}
}
