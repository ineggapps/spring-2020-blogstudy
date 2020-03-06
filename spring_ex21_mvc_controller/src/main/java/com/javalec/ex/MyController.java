package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/view")
	public String view() {
		System.out.println("view() 메서드가 호출되었는가?");
		return "view";
	}

	@RequestMapping("/content/contentView")
	public String contentView(Model model) {
		// Model 데이터를 갖고 있는 객체
		model.addAttribute("id", "abcde");
		return "content/contentView";
	}
}
