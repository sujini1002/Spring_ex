package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ReplyInfo;


public class GetWriteService {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	ListDaoInterface dao;
	
	int check = 0;
	
	@Transactional
	public void write(ListInfo listInfo) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			dao.write(listInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	public int replyWrite(ReplyInfo replyInfo) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			check = dao.replyWrite(replyInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
