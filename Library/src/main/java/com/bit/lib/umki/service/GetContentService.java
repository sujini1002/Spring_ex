package com.bit.lib.umki.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.umki.dao.ListDaoInterface;
import com.bit.lib.umki.model.ListInfo;

public class GetContentService {

	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	ListDaoInterface dao;
	ListInfo listInfo = null;
	
	@Transactional
	public ListInfo getContentIdx(int idx) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
				
		try {
			listInfo = dao.getContentIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listInfo;
	}
	
	@Transactional
	public ListInfo getContentIdxNext(int idx, String check) {
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		if(check != null) {
			try {
				idx = dao.getIdx(idx, check);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			listInfo = dao.getContentIdx(idx);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listInfo;
	}

	public String getNextPreInfo(int idx) {
		String next = "n";
		String prev = "p";
		String check = "yy";
		dao = sqlSessionTemplate.getMapper(ListDaoInterface.class);
		
		try {
			next = dao.getIdxNP(idx, "n");
			prev = dao.getIdxNP(idx, "p");
			
			if(next==null) {
				check = "nn";
			} else if (prev ==null) {
				check = "pn";
			}
			System.out.println(check);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

}
