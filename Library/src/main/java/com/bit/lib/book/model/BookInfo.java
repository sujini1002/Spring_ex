package com.bit.lib.book.model;

public class BookInfo {

	private String book_code; // 북코드 사용자가 지정
	private String book_name; // 책제목
	private String book_image; // 이미지 (url형식이라 file로 저장할 필요 없다)
	private String book_writer;// 작가
	private int book_price;// 가격
	private String book_publisher;// 출판사
	private String book_isbn;// 도서번호 isbn
	private String description;// 상세정보
	private int book_exist;
	
	public String getBook_code() {
		return book_code;
	}

	public void setBook_code(String book_code) {
		this.book_code = book_code;
	}

	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}

	public String getBook_image() {
		return book_image;
	}

	public void setBook_image(String book_image) {
		this.book_image = book_image;
	}

	public String getBook_writer() {
		return book_writer;
	}

	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}

	public int getBook_price() {
		return book_price;
	}

	public void setBook_price(int book_price) {
		this.book_price = book_price;
	}

	public String getBook_publisher() {
		return book_publisher;
	}

	public void setBook_publisher(String book_publisher) {
		this.book_publisher = book_publisher;
	}

	public String getBook_isbn() {
		return book_isbn;
	}

	public void setBook_isbn(String book_isbn) {
		this.book_isbn = book_isbn;
	}

	public int getBook_exist() {
		return book_exist;
	}

	public void setBook_exist(int book_exist) {
		this.book_exist = book_exist;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "BookInfo [book_code=" + book_code + ", book_name=" + book_name + ", book_image=" + book_image
				+ ", book_writer=" + book_writer + ", book_price=" + book_price + ", book_publisher=" + book_publisher
				+ ", book_isbn=" + book_isbn + ", exist=" + book_exist + "]";
	}

}
