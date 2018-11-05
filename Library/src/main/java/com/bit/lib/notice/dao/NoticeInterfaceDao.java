package com.bit.lib.notice.dao;

import java.util.List;

import com.bit.lib.notice.model.NoticeModel;

public interface NoticeInterfaceDao {
	
  public int insertnotice(NoticeModel noticeModel);
   
  public List <NoticeModel> selectnotice();
  
  public NoticeModel selectviewLink (int bId);
  
  public void deleteLink(int bId);
  
  public void update(NoticeModel noticeModel);
  

}
