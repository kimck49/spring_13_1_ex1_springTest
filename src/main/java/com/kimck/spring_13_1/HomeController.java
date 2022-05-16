package com.kimck.spring_13_1;

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
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		
		return "login";
	}	
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model) {
		
		String pid = request.getParameter("id");
		String ppw = request.getParameter("pw");
		
		model.addAttribute("pid", pid);
		model.addAttribute("ppw", ppw);
		
		return "loginOk";
	}
	
	@RequestMapping(value = "/login2")
	public String login2() {
		
		return "login2";
	}
	
	@RequestMapping(value = "/loginCheck")
	public String loginCheck(@RequestParam("id") String pid, @RequestParam("pw") String ppw, Model model) {
		
		model.addAttribute("pid", pid);
		model.addAttribute("ppw", ppw);
		
		return "loginCheck";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(MemberDto member, Model model) {
		
		model.addAttribute("member", member);
		
		return "joinOk";
	}
	
	@RequestMapping(value = "/studentNum/{studentNum}")
	public String getStudentNum(@PathVariable String studentNum, Model model) {
		
		model.addAttribute("studentNum", studentNum);
		
		return "paramTest";
	}
	
	
}
