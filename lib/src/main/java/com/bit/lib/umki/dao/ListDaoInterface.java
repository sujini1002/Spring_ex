package com.bit.lib.umki.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.lib.umki.model.ListInfo;

public interface ListDaoInterface {
	public ListInfo test();
//
//	public void create(ListInfo listInfo) throws Exception;
//
//	public ListInfo read(int idx) throws Exception;
//
//	public void update(ListInfo listInfo) throws Exception;
//
//	public void delete(int idx) throws Exception;
//
//	public List<ListInfo> listAll() throws Exception;
//
//	public List<ListInfo> listPage(int page); 

	public int count() throws Exception;
	
	public List<ListInfo> getList(@Param("num1") int num1, @Param("num2") int num2) throws Exception;

}
