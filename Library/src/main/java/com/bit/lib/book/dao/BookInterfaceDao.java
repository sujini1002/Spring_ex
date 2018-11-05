package com.bit.lib.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.lib.book.model.BookInfo;
import com.bit.lib.book.model.OrderParam;
import com.bit.lib.book.model.PageInfo;

public interface BookInterfaceDao {
	
	public int insertBook(BookInfo bookInfo);
	public List<BookInfo> selectAllBook(@Param("searchWord")String searchWord,@Param("keyword")String keyword);
	public int updateBook_exist(BookInfo bookInfo);
	public int deleteBook(@Param("book_code")String book_code);
	public List<BookInfo> selectUserBook(PageInfo pageInfo);
	public int bookBorrowOK(@Param("book_isbn")String book_isbn);
	public List<BookInfo> selectBookOrder(OrderParam orderParam);
	public List<BookInfo> afterDelete();
	public List<BookInfo> selectNewTopTen();
	public List<BookInfo> selectAllBookList(PageInfo pageInfo);
	public int bookCodeCheck(@Param("book_code")String book_code);
	public List<BookInfo> bookCodeSelect(@Param("book_isbn")String book_isbn);
	public int bookCountAll();
	public int bookCountGroupByAll(@Param("keyword")String keyword);
}
