package com.bit.lib.book.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.model.PageInfo;

public class BookSearchDeleteService {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	private BookInterfaceDao bookDao;
	
	private PageInfo pageInfo;

	public List<BookInfo> searchBook(String searchWord, String keyword) {

		System.out.println("서비스 :" + searchWord);
		List<BookInfo> list = new ArrayList<BookInfo>();

		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);

		list = bookDao.selectAllBook(searchWord, keyword);

		return list;
	}

	public List<BookInfo> searchBookAll(int page) {

		
		List<BookInfo> list = new ArrayList<BookInfo>();

		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		int totalRowNum = bookDao.bookCountAll();
		pageInfo = new PageInfo();
		
		pageInfo.setNowPageNum(page);
		pageInfo.setTotalRowNum(totalRowNum);
		System.out.println(pageInfo);

		list = bookDao.selectAllBookList(pageInfo);

		return list;
	}
	
	public int pageNumber() {	
	
		return pageInfo.getTotalPageNum();
	}

}
