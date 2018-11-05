package com.bit.lib.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;

@Service
public class MemberDeleteService {

	@Autowired
	MemberDao memberDao;

	public int deleteMember(String member_id) {
		int resultCnt = memberDao.deleteMember(member_id);
		return resultCnt;
	}
}
