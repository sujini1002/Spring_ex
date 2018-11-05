package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;

public class GetUpdateService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	int check = 0;
	
	@Transactional
	public void update(ListInfo listInfo) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			dao.update(listInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public int replyUpdate(int r_idx, String val) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			
			check = dao.replyUpdate(r_idx, val);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}


}
