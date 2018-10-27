package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;

public class TestService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	ListDaoInterface dao;
	
	public ListInfo test() {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		return dao.test();
	}
	
	
}
