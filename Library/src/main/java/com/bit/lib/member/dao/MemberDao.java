package com.bit.lib.member.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.lib.member.model.MemberVO;

@Repository
public class MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String mapperPath = "mappers.MemberMapper.";

	public int insertMember(MemberVO mv) {
		return sqlSessionTemplate.update(mapperPath + "insertMember", mv);
	}

	public MemberVO selectOneMember(String member_id) {
		return sqlSessionTemplate.selectOne(mapperPath + "selectOneMember", member_id);
	}

	// 확인
	public List<MemberVO> selectAllMember() {
		return sqlSessionTemplate.selectList(mapperPath + "selectAllMember");
	}

	public int updateMember(MemberVO mv) {
		return sqlSessionTemplate.update(mapperPath + "updateMember", mv);
	}

	public int deleteMember(String member_id) {
		return sqlSessionTemplate.update(mapperPath + "deleteMember", member_id);
	}

	public boolean matchPassword(String member_id, String password) {
		if (selectOneMember(member_id) != null) {
			return password.equals(selectOneMember(member_id).getPassword());
		}
		return false;
	}

	// 대여 요구사항
	public List<MemberVO> selecAlltByPossible() {
		return sqlSessionTemplate.selectList(mapperPath + "selecAlltByPossible");
	}

	public int updateByPossible(MemberVO mv) {
		return sqlSessionTemplate.update(mapperPath + "updateByPossible", mv);
	}

	public int updateAvailAmount(MemberVO mv) {
		return sqlSessionTemplate.update(mapperPath + "updateAvailAmount", mv);
	}

	public List<MemberVO> selectSearchMember(String member_id) {
		return sqlSessionTemplate.selectList(mapperPath + "selectSearchMember", "%" + member_id + "%");
	}

}
