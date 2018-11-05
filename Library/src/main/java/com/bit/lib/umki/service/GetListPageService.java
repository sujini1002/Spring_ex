package com.bit.lib.umki.service;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ViewInfo;

public class GetListPageService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	ViewInfo viewInfo = null;

	int totalCnt = 0;
	private static final int MESSAGE_COUNT_PER_PAGE = 15;

	@Transactional
	public ViewInfo getPageTotalNum(int pageNum) {
		
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);

		try {
			totalCnt = dao.count();
		} catch (Exception e) {
			e.printStackTrace();
		}

		viewInfo = new ViewInfo(totalCnt, pageNum, MESSAGE_COUNT_PER_PAGE);

		return viewInfo;
	}

	public ViewInfo getSearchPageTotalNum(int pageNum) {
		try {
			totalCnt = dao.searchCount();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		viewInfo = new ViewInfo(totalCnt, pageNum, MESSAGE_COUNT_PER_PAGE);
		return viewInfo;
	}
	
	
	
}
