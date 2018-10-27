package com.bit.lib.book.model;

public class BookInfo {
	
	private String bookCode; // 북코드 사용자가 지정
	private String title; // 책제목
	private String image; // 이미지 (url형식이라 file로 저장할 필요 없다)
	private String author;// 작가
	private int price;// 가격
	private String publisher;// 출판사
	private String isbn;// 도서번호 isbn
	private String description;// 상세정보
	private int exist;

	public String getBookCode() {
		return bookCode;
	}

	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
	}

	public int getExist() {
		return exist;
	}

	public void setExist(int exist) {
		this.exist = exist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookInfo [title=" + title + ", image=" + image + ", author=" + author + ", price=" + price
				+ ", publisher=" + publisher + ", isbn=" + isbn + "]";
	}

}
