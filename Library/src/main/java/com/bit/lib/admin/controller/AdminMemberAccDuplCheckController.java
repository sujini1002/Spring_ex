package com.bit.lib.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit.lib.admin.service.AdminMemberAccDuplCheckService;

@Controller
public class AdminMemberAccDuplCheckController {

	@Autowired
	AdminMemberAccDuplCheckService adminMemberDuplCheckService;

	@RequestMapping(value = "/admin/memberAccount/memberDuplCheck", method = RequestMethod.GET)
	@ResponseBody
	public boolean memberDuplCheck(@RequestParam("member") String member_id) {

		return adminMemberDuplCheckService.isExistID(member_id);
	}

}
