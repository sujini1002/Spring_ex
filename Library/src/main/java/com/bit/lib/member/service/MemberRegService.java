package com.bit.lib.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;

@Service
public class MemberRegService {

	@Autowired
	MemberDao memberDao;

	public int insertMember(MemberVO mv) {
		int resultCnt = memberDao.insertMember(mv);
		return resultCnt;
	}
}
