package com.javalec.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.ex.member.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("board/confirmId")
	public String confirmId(HttpServletRequest httpServletRequest, Model model) {
		String id = httpServletRequest.getParameter("id");
		String pw = httpServletRequest.getParameter("pw");
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}

	// @RequestParam에 해당하는 값이 들어오지 않으면 HTTP 400(잘못된 요청) ERROR페이지가 뜬다.
	@RequestMapping("board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("identity", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}

	//주의사항, Member클래스의 필드 변수명과 일치시켜야만 작동한다.
//	@RequestMapping("/join/formOk")
//	public String join(@RequestParam("name") String name, @RequestParam("id") String id, @RequestParam("pw") String pw,
//			@RequestParam("email") String email, Model model) {
//		Member member = new Member();
//		member.setName(name);
//		member.setId(id);
//		member.setPw(pw);
//		member.setEmail(email);
//
//		model.addAttribute(member);
//		return "join/formOk";
//	}

	@RequestMapping("/join/formOk")
	public String join(Member member) {
		return "join/formOk";
	}
	
	@RequestMapping("/join/memberId/{memberId}")
	public String getMember(@PathVariable String memberId, Model model) {
		model.addAttribute("memberId", memberId);
		return "/join/memberId";
	}
}
