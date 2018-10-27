package com.bit.lib.admin.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.lib.admin.model.AdminVO;

@Repository
public class AdminDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private String mapperPath = "mappers.AdminMapper.";

	public int insertAdmin(AdminVO av) {
		return sqlSessionTemplate.update(mapperPath + "insertAdmin", av);
	}
	// 확인
	public AdminVO selectOneAdmin(String admin_id) {
		return sqlSessionTemplate.selectOne(mapperPath + "selectOneAdmin", admin_id);
	}
	// 확인
	public List<AdminVO> selectAllAdmin() {
		return sqlSessionTemplate.selectList(mapperPath + "selectAllAdmin");
	}
	// 확인
	public List<String> selectAllAdminId() {
		return sqlSessionTemplate.selectList(mapperPath + "selectAllAdminId");
	}
	
	public int updateAdmin(AdminVO av) {
		return sqlSessionTemplate.update(mapperPath + "updateAdmin");
	}

	public int deleteAdmin(String admin_id) {
		return sqlSessionTemplate.update(mapperPath + "deleteAdmin");
	}
	// 확인
	public boolean matchPassword(String admin_id, String password) {
		return password.equals(selectOneAdmin(admin_id).getPassword());
	}
}
