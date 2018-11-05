package com.bit.lib.book.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.javassist.NotFoundException;
import org.w3c.dom.Document;

public class BookSearchInsertDao {

	// api를 이용하기 위한 서비스 id와 키값
	private String clientId = "qvhMuqYuJq4SeEm57GII";// 애플리케이션 클라이언트 아이디값";
	private String clientSecret = "wf0W2PkHsX";// 애플리케이션 클라이언트 시크릿값";
	private Document doc;

	public Document bookSearchList(String option, String keyword,int listCnt) throws Exception {

			// 검색 값 인코딩
			String text = URLEncoder.encode(keyword, "utf-8");
			//int cnt = URLEncoder.encode(listCnt, "utf-8");
			String apiURL = "https://openapi.naver.com/v1/search/book_adv.xml?"+option+"="+text+"&display="+listCnt;
			// api 결과 요청
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			// api 응답 처리 결과 받음
			int responseCode = con.getResponseCode();
			//BufferedReader br = null;

			if (responseCode == 200) { // 정상 호출
				//결과 값을 xml 형식의 Document 형식을 반환
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
				doc = dbBuilder.parse(con.getInputStream());
			}

		return doc;
	}// end bookSearchList()
}
