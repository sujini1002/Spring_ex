package com.bitcamp.mvc1016;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GameSearchController {
	@RequestMapping("/game/search")
	public String viewPage() {
		
		return "game/search";
	}
	
	@ModelAttribute("searchType") //searchType()의 반환값을 속성에 저장하는 역할
	public List<String> searchType(){
		List<String> option = new ArrayList<String>();
		
		option.add("전체");
		option.add("아이템");
		option.add("캐릭터");
		
		return option;
	}
	@ModelAttribute("gameList") //응답할 view에서 데이터를 공유할 수 있다.
	public String[] getGameList() {
		
		String[] games = {"배그","롤","쿠키런"};
		
		return games;
	}
}
