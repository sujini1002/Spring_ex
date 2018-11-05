package com.bit.lib.umki.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bit.lib.umki.model.ListInfo;
import com.bit.lib.umki.model.ReplyInfo;

public interface ListDaoInterface {
	public ListInfo test();

	public int count() throws Exception;

	public List<ListInfo> getList(@Param("num1") int num1, @Param("num2") int num2) throws Exception;

	public void write(ListInfo listInfo) throws Exception;

	public ListInfo getContent(String list_name) throws Exception;

	public ListInfo getContentIdx(int idx) throws Exception;

	public void update(ListInfo listInfo) throws Exception;

	public void delete(int idx) throws Exception;

	public int page(int idx) throws Exception;

	public int replyWrite(ReplyInfo replyInfo) throws Exception;

	public int replyDelete(int r_idx) throws Exception;
	
	public List<ReplyInfo> getReplyList(int idx) throws Exception;
	
	public int replyUpdate(@Param("r_idx") int r_idx, @Param("val") String val) throws Exception;

	public List<ListInfo> getSearchList(@Param("select") String select, @Param("con") String content) throws Exception;

	public int searchCount() throws Exception;

	public int getIdx(@Param("idx") int idx, @Param("check") String check) throws Exception;

	public String getIdxNP(@Param("idx") int idx, @Param("check") String check) throws Exception;

}
