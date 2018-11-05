package com.bit.lib.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;
import com.bit.lib.admin.model.AdminVO;

@Service
public class AdminEditService {

	@Autowired
	AdminDao adminDao;

	public AdminVO getEditAdmin(String admin_id) {
		// 동적
		// return adminDao.selectOneAdmin(admin_id);
		AdminVO av = new AdminVO();
		av.setAdmin_id(admin_id);
		return adminDao.selectAdmin(av).get(0);
	}

	public int editAdmin(AdminVO av) {
		int resultCnt = adminDao.updateAdmin(av);

		return resultCnt;
	}
}
