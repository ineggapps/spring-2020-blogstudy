package com.javalec.ex;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect")
public class RedirectController {
	@RequestMapping("/confirm")
	public String redirectConfirm(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		if (id.equals("abc")) {
			return "redirect:redirectOk";
		}
		return "redirect:redirectNg";
	}

	@RequestMapping("/redirectOk")
	public String redirectOk(Model model) {
		return "redirect/redirectOk";
	}

	@RequestMapping("/redirectNg")
	public String redirectNg(Model model) {
		return "redirect/redirectNg";
	}

	@RequestMapping("/redirectURL1")
	public String redirectURL1(Model model) {
		return "redirect:http://localhost:8181/ex/redirect/redirectURL1.jsp";
	}
}
