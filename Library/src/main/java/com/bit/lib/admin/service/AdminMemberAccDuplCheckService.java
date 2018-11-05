package com.bit.lib.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;

@Service
public class AdminMemberAccDuplCheckService {

	@Autowired
	MemberDao memberDao;

	public boolean isExistID(String member_id) {
		return (memberDao.selectOneMember(member_id) != null);
	}
}
