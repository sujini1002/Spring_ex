package com.bitcamp.mvc1015;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//세부 컨트롤러 등록
@Controller
public class HelloController {
	
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		ModelAndView modelAndView = new ModelAndView();
		//view name 반환해야 한다.
		modelAndView.setViewName("hello"); //web-INF/views/hello.jsp 로 붙여짐
		
		//결과 데이터를 Model에 저장후 공유
		 modelAndView.addObject("greeting", getGreeting());
		
		return modelAndView;
	}
	private Object getGreeting() {
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		String str = "";
		if(hour >= 6 && hour <=10) {
			str = "내자리로와";
		}else if(hour > 12 && hour <=15) {
			str = "도시락먹자";
		}else {
			str = "야자해야지";
		}
		return str;
	}
}
