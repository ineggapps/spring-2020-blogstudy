package com.javalec.ex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/view")
	public String view() {
		System.out.println("view() �޼��尡 ȣ��Ǿ��°�?");
		return "view";
	}

	@RequestMapping("/content/contentView")
	public String contentView(Model model) {
		// Model �����͸� ���� �ִ� ��ü
		model.addAttribute("id", "abcde");
		return "content/contentView";
	}
}
