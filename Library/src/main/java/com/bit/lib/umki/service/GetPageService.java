package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;

public class GetPageService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	int rank = 1;
	int page = 1;

	@Transactional
	public String getPage(int idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		try {
			rank = dao.page(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		page = rank / 15;
		if(rank % 15 > 0) {
			page++;
		}
		String pageStr = String.valueOf(page);
		
		return pageStr;
	}

}
