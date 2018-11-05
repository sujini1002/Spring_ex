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

	public List<AdminVO> selectAdmin(AdminVO av){
		return sqlSessionTemplate.selectList(mapperPath + "selectAdmin", av);
	}
	// 비밀번호 찾기
	public boolean matchPassword(AdminVO av, String password) {
		return password.equals(selectAdmin(av).get(0).getPassword());
	}
	// 확인
//	public AdminVO selectOneAdmin(String admin_id) {
//		return sqlSessionTemplate.selectOne(mapperPath + "selectOneAdmin", admin_id);
//	}

	// 확인
//	public List<AdminVO> selectAllAdmin() {
//		return sqlSessionTemplate.selectList(mapperPath + "selectAllAdmin");
//	}

	// 확인
	public List<String> selectAllAdminId() {
		return sqlSessionTemplate.selectList(mapperPath + "selectAllAdminId");
	}

	public int updateAdmin(AdminVO av) {
		return sqlSessionTemplate.update(mapperPath + "updateAdmin", av);
	}

	public int deleteAdmin(String admin_id) {
		return sqlSessionTemplate.update(mapperPath + "deleteAdmin", admin_id);
	}

	// 확인
//	public boolean matchPassword(String admin_id, String password) {
//		return password.equals(selectOneAdmin(admin_id).getPassword());
//	}
	
	public List<String> selectPermissionDetail() {
		return sqlSessionTemplate.selectList(mapperPath + "selectPermissionDetail");
	}

}
