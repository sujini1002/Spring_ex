package com.bit.lib.aladin.dao;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;

@Repository
public class AladinDAO {

	// 알라딘 책 가져오기
	private String baseURL = "http://www.aladin.co.kr/ttb/api/ItemLookUp.aspx?";
	private String ttbkey = "ttbkey=" + "ttbbombstar1951001";
	private String itemIdType = "&itemIdType=" + "ISBN13";
	private String ItemId = "&ItemId="; // + isbn13;
	private String output = "&output=" + "xml";
	private String version = "&Version=" + "20131101";
	private String cover = "&Cover=" + "Big";
	private String optResult = "&OptResult=ebookList,usedList";

	private Document doc;

	public Document getBookList(String book_isbn13) throws Exception {

		String apiURL = baseURL + ttbkey + itemIdType + ItemId + book_isbn13 + output + version + cover + optResult;
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");

		// api 응답 처리 결과 받음
		int responseCode = con.getResponseCode();
		// BufferedReader br = null;

		if (responseCode == 200) { // 정상 호출
			// 결과 값을 xml 형식의 Document 형식을 반환
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
			doc = dbBuilder.parse(con.getInputStream());
		}

		System.out.println(apiURL);
		return doc;
	}

}
