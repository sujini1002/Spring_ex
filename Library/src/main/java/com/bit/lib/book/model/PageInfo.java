package com.bit.lib.book.model;

public class PageInfo {
	private int totalRowNum;//전체 행 갯수
	private int totalPageNum;//전체 페이지 갯수
	private int startRowNum;//한페이지에서 시작할 행 번호
	private int endRowNum;//한페이지에서 끝날 행 번호
	private final int pagePerNum =10;//한페이지에 보여질 페이지 갯수
	private int nowPageNum;//현재페이지 번호
	private String keyword;//검색할 키워드
	
	public void setTotalRowNum(int totalRowNum) {
		this.totalRowNum = totalRowNum;
		setTotalPageNum();
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum() {
		if(totalRowNum%pagePerNum==0) {
			this.totalPageNum = totalRowNum/pagePerNum;
		}else {
			this.totalPageNum = totalRowNum/pagePerNum + 1;
		}
	}
	public int getStartRowNum() {
		return startRowNum;
	}
	public void setStartRowNum() {
		this.startRowNum = (nowPageNum-1)*pagePerNum ;
	}
	public int getEndRowNum() {
		return endRowNum;
	}
	public void setEndRowNum() {
		this.endRowNum = startRowNum+pagePerNum-1;
	}
	public int getPagePerNum() {
		return pagePerNum;
	}
	public int getNowPageNum() {
		return nowPageNum;
	}
	public void setNowPageNum(int nowPageNum) {
		this.nowPageNum = nowPageNum;
		setStartRowNum();
		setEndRowNum();
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getTotalRowNum() {
		return totalRowNum;
	}
	@Override
	public String toString() {
		return "PageInfo [totalRowNum=" + totalRowNum + ", totalPageNum=" + totalPageNum + ", startRowNum="
				+ startRowNum + ", endRowNum=" + endRowNum + ", pagePerNum=" + pagePerNum + ", nowPageNum=" + nowPageNum
				+ ", keyword=" + keyword + "]";
	}	
	
}
//주석