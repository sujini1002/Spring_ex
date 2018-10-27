package com.bit.lib.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.bit.lib.book.dao.BookSearchInsertDao;
import com.bit.lib.book.model.BookInfo;

public class BookSearchInsertService {
	
	@Autowired
	private BookSearchInsertDao bookDao;
	
	//api에서 받아온 xml문서를 List<BookInfo>로 변환 하는 메서드
	public List<BookInfo> bookList(String option, String keyword) throws Exception {
		
		List<BookInfo> bookList = new ArrayList<BookInfo>();

		String optionCode = findOptionCode(option);
		Document result = bookDao.bookSearchList(optionCode, keyword);
		
		//root tag
		result.getDocumentElement().normalize();
		//System.out.println("Root Element : "+result.getDocumentElement().getNodeName());
		
		//파싱할 tag
		NodeList nList = result.getElementsByTagName("item");
		
		for(int tmp = 0; tmp < nList.getLength();tmp++) {
			Node node = nList.item(tmp);
			if(node.getNodeType()== Node.ELEMENT_NODE) {
				Element eElement = (Element) node;
				BookInfo bookInfo = new BookInfo();
				bookInfo.setTitle(getTagValue("title", eElement));
				bookInfo.setImage(getTagValue("image", eElement));
				bookInfo.setAuthor(getTagValue("author", eElement));
				bookInfo.setPrice(Integer.parseInt(getTagValue("price", eElement)));
				bookInfo.setPublisher(getTagValue("publisher", eElement));
				bookInfo.setIsbn(getTagValue("isbn", eElement));
				bookInfo.setDescription(getTagValue("description", eElement));
				
				//리스트에 저장
				bookList.add(bookInfo);
				System.out.println(bookInfo);
			}
		}

		return bookList;
	}//end bookList()
	
	//받아온 api 값의 html 코드를 제거해주는 메서드
/*	public List<BookInfo> bookRemoveHtml(List<BookInfo> bookList) {
		
		List<BookInfo> bookInsertDB = new ArrayList<>();
		
		for(int i = 0 ;i<bookList.size();i++) {
			BookInfo book = bookList.get(i);
			book.setTitle(book.getTitle().replaceAll("<b>", ""));
			book.setTitle(book.getTitle().replaceAll("</b>", ""));
			book.setAuthor(book.getAuthor().replaceAll("<b>", ""));
			book.setAuthor(book.getAuthor().replaceAll("</b>", ""));
			book.setPublisher(book.getPublisher().replaceAll("<b>", ""));
			book.setPublisher(book.getPublisher().replaceAll("</b>", ""));
			
			System.out.println("html태그없는 :"+book);
			bookInsertDB.add(book);
		}
		
		return bookInsertDB;
	}*/

	// 검색할 범위 구하는 메서드
	private String findOptionCode(String option) {
		option = option.trim();
		String code = "";

		if (option.equals("publisher")) {
			code = "d_publ";
		} else if (option.equals("author")) {
			code = "d_auth";
		} else {
			code = "d_titl";
		}
		return code;
	}//end findOptionCode

	// tag값의 정보를 가져오는 메서드
	public String getTagValue(String tag, Element eElement) {
		NodeList nList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
		Node nValue = (Node)nList.item(0);
		if(nValue == null) {
			return null;
		}
		return nValue.getNodeValue();
	}//end getTagValue()
}
