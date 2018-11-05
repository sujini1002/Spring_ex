package com.bit.lib.book.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.bit.lib.book.dao.BookInterfaceDao;

public class BookCheckCodeService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BookInterfaceDao bookDao;
	
	public int bookCodeCheck(String book_code) {
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		
		//String result = "사용 가능한 북 코드 입니다.";
		int bookCheck = bookDao.bookCodeCheck(book_code);
		/*if(bookCheck>0) {
			result = "사용 불가능한 북코드 입니다!!!";
		}*/
		return bookCheck;
	}
	//주석
}
