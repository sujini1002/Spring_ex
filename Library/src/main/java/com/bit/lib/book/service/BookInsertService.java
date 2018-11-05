package com.bit.lib.book.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.bit.lib.book.dao.BookInterfaceDao;
import com.bit.lib.book.model.BookInfo;

public class BookInsertService {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	private BookInterfaceDao bookDao;
	
	@Transactional
	public int bookInsert(BookInfo bookInfo) {
		
		//html요소 제거
		cleanHtml(bookInfo);
		System.out.println(bookInfo);
		
		bookDao = sqlSessionTemplate.getMapper(BookInterfaceDao.class);
		
		return bookDao.insertBook(bookInfo);
	}

	private void cleanHtml(BookInfo bookInfo) {
		System.out.println(bookInfo);
		//book_name,book_writer,book_publisher의 html요소 제거
		bookInfo.setBook_name(bookInfo.getBook_name().replaceAll("<b>",""));
		bookInfo.setBook_name(bookInfo.getBook_name().replaceAll("</b>",""));
		bookInfo.setBook_name(bookInfo.getBook_name().replaceAll(" ",""));
		
		bookInfo.setBook_writer(bookInfo.getBook_writer().replaceAll("<b>",""));
		bookInfo.setBook_writer(bookInfo.getBook_writer().replaceAll("</b>",""));
		bookInfo.setBook_writer(bookInfo.getBook_writer().replaceAll(" ",""));
		
		bookInfo.setBook_publisher(bookInfo.getBook_publisher().replaceAll("<b>",""));
		bookInfo.setBook_publisher(bookInfo.getBook_publisher().replaceAll("</b>",""));
		
		
	}
	
}
