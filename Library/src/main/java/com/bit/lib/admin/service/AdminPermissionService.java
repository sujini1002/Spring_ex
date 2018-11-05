package com.bit.lib.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.admin.dao.AdminDao;

@Service
public class AdminPermissionService {

	@Autowired
	AdminDao adminDao;

	public List<String> getPermissionNames() {
		return adminDao.selectPermissionDetail();
	}
}
