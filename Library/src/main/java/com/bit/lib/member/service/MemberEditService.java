package com.bit.lib.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;

@Service
public class MemberEditService {

	@Autowired
	MemberDao memberDao;

	public MemberVO getEditMember(String member_id) {
		return memberDao.selectOneMember(member_id);
	}

	public int editMember(MemberVO mv) {
		int resultCnt = memberDao.updateMember(mv);

		return resultCnt;
	}
}
