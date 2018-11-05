package com.bit.lib.umki.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ReplyInfo;

public class GetWriteContentService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	ListInfo listInfo = null;
	List<ReplyInfo> replyInfo = null;
	
	@Transactional
	public ListInfo getContent(String list_name) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			listInfo = dao.getContent(list_name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listInfo;
	}

	@Transactional
	public List<ReplyInfo> getReplyContent(int idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			replyInfo = dao.getReplyList(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return replyInfo;
	}

}
