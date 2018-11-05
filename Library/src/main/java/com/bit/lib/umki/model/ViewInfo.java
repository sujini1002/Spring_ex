package com.bit.lib.umki.model;

import java.util.List;


public class ViewInfo {
	private int messageTotalCount;
	private int currentPageNumber;
	private List<ListInfo> messageList;
	private int pageTotalCount;
	private int messageCountPerPage;
	private int startPageNum;
	private int lastPageNum;
	
	public ViewInfo(int messageTotalCount, int currentPageNumber,  int messageCountPerPage) {
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		calculatePageTotalCnt();
	}
	private void calculatePageTotalCnt() {
		if (messageTotalCount == 0) {
			pageTotalCount = 0;
		} else {
			pageTotalCount = messageTotalCount / messageCountPerPage;
			if (messageTotalCount % messageCountPerPage > 0) {
				pageTotalCount++;
			}
		}
		
		startPageNum = (currentPageNumber / 10) * 10 + 1;
		if(currentPageNumber % 10 == 0) {
			startPageNum-=10;
		}
		lastPageNum = startPageNum + 9;
		if(lastPageNum>pageTotalCount) {
			lastPageNum = pageTotalCount;
		}
		
		
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getLastPageNum() {
		return lastPageNum;
	}
	public void setLastPageNum(int lastPageNum) {
		this.lastPageNum = lastPageNum;
	}
	public int getMessageTotalCount() {
		return messageTotalCount;
	}
	public void setMessageTotalCount(int messageTotalCount) {
		this.messageTotalCount = messageTotalCount;
	}
	public int getCurrentPageNumber() {
		return currentPageNumber;
	}
	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}
	public List<ListInfo> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<ListInfo> messageList) {
		this.messageList = messageList;
	}
	public int getPageTotalCount() {
		return pageTotalCount;
	}
	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}
	public int getMessageCountPerPage() {
		return messageCountPerPage;
	}
	public void setMessageCountPerPage(int messageCountPerPage) {
		this.messageCountPerPage = messageCountPerPage;
	}

	
}
