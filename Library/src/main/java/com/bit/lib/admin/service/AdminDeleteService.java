package com.bit.lib.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;

@Service
public class AdminDeleteService {

	@Autowired
	AdminDao adminDao;

	public int deleteAdmin(String admin_id) {
		int resultCnt = adminDao.deleteAdmin(admin_id);
		System.out.println(admin_id + "서비스");
		return resultCnt;
	}
}
