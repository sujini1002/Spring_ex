package com.bit.lib.notice.model;

import java.sql.Timestamp;

public class NoticeModel {
	
	int bId;
	String bName;
	String bTitle;
	String bContent;
	Timestamp bDate;
	

	public NoticeModel() {
		// TODO Auto-generated constructor stub
	}

/*	public NoticeModel(int bId, String bName, String bTitle, String bContent, Timestamp bDate, int bHit, int bGroup,
			int bStep, int bIndent) {
		// TODO Auto-generated constructor stub
		this.bId = bId;
		this.bName = bName;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}*/

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbTitle() {
		return bTitle;
	}

	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}

	public String getbContent() {
		return bContent;
	}

	public void setbContent(String bContent) {
		this.bContent = bContent;
	}

	public Timestamp getbDate() {
		return bDate;
	}

	public void setbDate(Timestamp bDate) {
		this.bDate = bDate;
	}

	@Override
	public String toString() {
		return "NoticeModel [bId=" + bId + ", bName=" + bName + ", bTitle=" + bTitle + ", bContent=" + bContent
				+ ", bDate=" + bDate + "]";
	}

	

}
