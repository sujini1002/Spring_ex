package com.bit.lib.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;
import com.bit.lib.admin.model.AdminVO;

@Service
public class AdminRegService {

	@Autowired
	AdminDao adminDao;

	public int insertAdmin(AdminVO av) {
		int resultCnt = adminDao.insertAdmin(av);
		return resultCnt;
	}
}
