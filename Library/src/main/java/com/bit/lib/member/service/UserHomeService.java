package com.bit.lib.member.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;

public class UserHomeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BookInterfaceDao bookDao;
	
	public List<BookInfo> bookNewList(){
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		List<BookInfo> list = new ArrayList<BookInfo>();
		list = bookDao.selectNewTopTen();
		return list;
	}
	
}
