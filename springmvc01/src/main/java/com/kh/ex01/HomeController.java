package com.kh.ex01;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ex01.service.MemberService;
import com.kh.ex01.vo.MemberVo;

@Controller
public class HomeController {
	
	@Autowired
	private MemberService memberService;
	
	// http://localhost/
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(/*HttpSession session*/) {
//		String userid = "user01";
//		MemberVo loginVo = memberService.getMemberById(userid);
//		System.out.println("loginVo : " + loginVo);
//		session.setAttribute("loginVo", loginVo);
		
		return "home";
	}
	
}
