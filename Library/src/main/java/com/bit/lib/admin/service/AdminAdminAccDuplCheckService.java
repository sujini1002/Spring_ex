package com.bit.lib.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;
import com.bit.lib.admin.model.AdminVO;

@Service
public class AdminAdminAccDuplCheckService {

	@Autowired
	AdminDao adminDao;

	public boolean isExistID(String admin_id) {
		// 동적
		// return (adminDao.selectOneAdmin(admin_id) != null);
		AdminVO av = new AdminVO();
		av.setAdmin_id(admin_id);
		System.out.println(!adminDao.selectAdmin(av).isEmpty());
		return (!adminDao.selectAdmin(av).isEmpty());
	}
}
