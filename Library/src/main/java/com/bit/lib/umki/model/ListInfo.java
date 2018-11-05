package com.bit.lib.umki.model;

public class ListInfo {
	int idx;
	int cnt;
	String list_title;
	String list_content;
	String list_date;
	String list_name;
	
	
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getList_title() {
		return list_title;
	}
	public void setList_title(String list_title) {
		this.list_title = list_title;
	}
	public String getList_content() {
		return list_content;
	}
	public void setList_content(String list_content) {
		this.list_content = list_content;
	}
	public String getList_date() {
		return list_date;
	}
	public void setList_date(String list_date) {
		this.list_date = list_date;
	}
	public String getList_name() {
		return list_name;
	}
	public void setList_name(String list_name) {
		this.list_name = list_name;
	}
	@Override
	public String toString() {
		return "ListInfo [idx=" + idx + ", cnt=" + cnt + ", list_title=" + list_title + ", list_content=" + list_content
				+ ", list_date=" + list_date + ", list_name=" + list_name + "]";
	}
	
	
	
}
