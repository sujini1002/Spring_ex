package com.bit.lib.aladin.model;

public class AladinDataVO {

	private String ISBN13;
	private String link;
	private String cover;
	private int customerReviewRank;
	
	private int usedAladinUsedCount;
	private int usedAladinMinPrice;
	private String usedAladinLink;
	
	private int userUsedCount;
	private int userUsedMinPrice;
	private String userUsedLink;

	public String getISBN13() {
		return ISBN13;
	}

	public void setISBN13(String iSBN13) {
		ISBN13 = iSBN13;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public int getCustomerReviewRank() {
		return customerReviewRank;
	}

	public void setCustomerReviewRank(int customerReviewRank) {
		this.customerReviewRank = customerReviewRank;
	}

	public int getUsedAladinUsedCount() {
		return usedAladinUsedCount;
	}

	public void setUsedAladinUsedCount(int usedAladinUsedCount) {
		this.usedAladinUsedCount = usedAladinUsedCount;
	}

	public int getUsedAladinMinPrice() {
		return usedAladinMinPrice;
	}

	public void setUsedAladinMinPrice(int usedAladinMinPrice) {
		this.usedAladinMinPrice = usedAladinMinPrice;
	}

	public String getUsedAladinLink() {
		return usedAladinLink;
	}

	public void setUsedAladinLink(String usedAladinLink) {
		this.usedAladinLink = usedAladinLink;
	}

	public int getUserUsedCount() {
		return userUsedCount;
	}

	public void setUserUsedCount(int userUsedCount) {
		this.userUsedCount = userUsedCount;
	}

	public int getUserUsedMinPrice() {
		return userUsedMinPrice;
	}

	public void setUserUsedMinPrice(int userUsedMinPrice) {
		this.userUsedMinPrice = userUsedMinPrice;
	}

	public String getUserUsedLink() {
		return userUsedLink;
	}

	public void setUserUsedLink(String userUsedLink) {
		this.userUsedLink = userUsedLink;
	}

	@Override
	public String toString() {
		return "AladinDataVO [ISBN13=" + ISBN13 + ", link=" + link + ", cover=" + cover + ", customerReviewRank="
				+ customerReviewRank + ", usedAladinUsedCount=" + usedAladinUsedCount + ", usedAladinMinPrice="
				+ usedAladinMinPrice + ", usedAladinLink=" + usedAladinLink + ", userUsedCount=" + userUsedCount
				+ ", userUsedMinPrice=" + userUsedMinPrice + ", userUsedLink=" + userUsedLink + "]";
	}

}
