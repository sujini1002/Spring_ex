package com.bit.lib.book.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.model.OrderParam;

public class BookSearchUserOrderService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BookInterfaceDao bookDao;
	
	public List<BookInfo> bookList(OrderParam orderParam){
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		
		bookList = bookDao.selectBookOrder(orderParam);
		
		return bookList;
	}
}
