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

	public List<BookInfo> bookList(String option, String keyword,int listCnt) throws Exception {
		
		List<BookInfo> bookList = new ArrayList<BookInfo>();

		String optionCode = findOptionCode(option);
		Document result = bookDao.bookSearchList(optionCode, keyword,listCnt);
		
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
				bookInfo.setBook_name(getTagValue("title", eElement));
				bookInfo.setBook_image(getTagValue("image", eElement));
				bookInfo.setBook_writer(getTagValue("author", eElement));
				bookInfo.setBook_price(Integer.parseInt(getTagValue("price", eElement)));
				bookInfo.setBook_publisher(getTagValue("publisher", eElement));
				bookInfo.setBook_isbn(getTagValue("isbn", eElement));
				bookInfo.setDescription(getTagValue("description", eElement));
				
				//리스트에 저장
				bookList.add(bookInfo);
			}
		}

		return bookList;
	}//end bookList()


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

}// end class
