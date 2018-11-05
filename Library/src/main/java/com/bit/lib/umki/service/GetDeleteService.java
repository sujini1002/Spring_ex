package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;

public class GetDeleteService {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	int check = 0;
	@Transactional
	public void delete(int idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
			try {
				dao.delete(idx);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@Transactional
	public int replyDelete(int r_idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			check = dao.replyDelete(r_idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}
}
