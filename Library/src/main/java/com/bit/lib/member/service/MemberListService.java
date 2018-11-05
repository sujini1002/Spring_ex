package com.bit.lib.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.lib.member.dao.MemberDao;
import com.bit.lib.member.model.MemberVO;

@Service
public class MemberListService {

	@Autowired
	MemberDao memberDao;

	public List<MemberVO> getAllmember() {
		return memberDao.selectAllMember();
	}

}
