package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.admin.service.AdminAdminAccDuplCheckService;

@Controller
public class AdminAdminAccDuplCheckController {

	@Autowired
	AdminAdminAccDuplCheckService adminAdminAccDuplCheckService;

	@RequestMapping(value = "/admin/adminAccount/adminDuplCheck", method = RequestMethod.GET)
	@ResponseBody
	public boolean adminDuplCheck(@RequestParam("admin") String admin_id) {

		return adminAdminAccDuplCheckService.isExistID(admin_id);
	}

}
