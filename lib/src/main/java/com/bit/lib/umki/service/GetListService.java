package com.bit.lib.umki.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;

public class GetListService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	private static final int MESSAGE_COUNT_PER_PAGE = 15;
	int num1 = 0;
	int num2 = 0;
	List<ListInfo> list = null;

	public List<ListInfo> getList(int page) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		num1 = ( page -1 ) * MESSAGE_COUNT_PER_PAGE;
		num2 = 15;
		
		try {
			list = dao.getList(num1, num2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
