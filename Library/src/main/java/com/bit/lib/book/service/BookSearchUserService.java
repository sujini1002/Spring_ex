package com.bit.lib.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.model.PageInfo;

public class BookSearchUserService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BookInterfaceDao bookDao;
	
	private PageInfo pageInfo;
	
	public List<BookInfo> searchBook(String keyword,int nowPageNum){
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		
		int totalRowNum = bookDao.bookCountGroupByAll(keyword);
		pageInfo = new PageInfo();
		
		pageInfo.setNowPageNum(nowPageNum);
		pageInfo.setTotalRowNum(totalRowNum);
		pageInfo.setKeyword(keyword);
		System.out.println(pageInfo);
		
		List<BookInfo> list = bookDao.selectUserBook(pageInfo);
		
		return list;
	}
	public int bookCountAll() {
		
		return pageInfo.getTotalPageNum();
	}
}
//주석