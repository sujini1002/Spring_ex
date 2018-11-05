package com.bit.lib.umki.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ReplyInfo;

public class GetListService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	private static final int MESSAGE_COUNT_PER_PAGE = 15;
	int num1 = 0;
	int num2 = 0;
	int totalCnt = 0;
	List<ListInfo> list = null;
	List<ListInfo> searchList = null;
	List<ReplyInfo> replyInfo = null;

	@Transactional
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

	@Transactional
	public List<ReplyInfo> getReplyList(int idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		try {
			replyInfo = dao.getReplyList(idx);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return replyInfo;
	}

	@Transactional
	public List<ListInfo> getSearchList(String select, String content) {
		content="%"+content+"%";
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			searchList = dao.getSearchList(select, content);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchList;
	}
}
