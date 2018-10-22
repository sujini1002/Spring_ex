package com.openproject.openproject.gb_service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;



import com.openproject.openproject.gb_dao.JdbcTemplateMessageDao;
import com.openproject.openproject.gb_model.Message;
import com.openproject.openproject.gb_model.MessageListView;

public class GuestBookListService {
	@Autowired
	JdbcTemplateMessageDao jdbcTemplateMessageDao;
	
	// 한 페이지에 보여줄 메시지의 수
		private static final int MESSAGE_COUNT_PER_PAGE = 5;

		public MessageListView getMessageList(int pageNumber) throws SQLException {
			
			int currentPageNumber = pageNumber;
			
				
				
				// 전체 메시지 구하기
				int messageTotalCount = jdbcTemplateMessageDao.selectCount();
				List<Message> messageList = null;
				int firstRow = 0;
				int endRow = 0;
				if (messageTotalCount > 0) {
					firstRow = (pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
					endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
					messageList = jdbcTemplateMessageDao.selectList(firstRow,endRow);
				} else {
					currentPageNumber = 0;
					messageList = Collections.emptyList();
				}
				return new MessageListView(messageList, messageTotalCount, currentPageNumber, MESSAGE_COUNT_PER_PAGE,
						firstRow, endRow);
			
		}
}
