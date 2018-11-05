package com.bit.lib.book.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;

public class BookDeleteService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private BookInterfaceDao bookDao;
	
	@Transactional
	public int bookDelete(String book_code) {
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		
		return bookDao.deleteBook(book_code);
		
	}
	public List<BookInfo> afterDelete(){
		
		//bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		List<BookInfo> list = bookDao.afterDelete();
		System.out.println("서비스 :"+list);
		return list;
	}
	/*public int bookCountAll() {
		return bookDao.bookCountAll();
	}*/
}
