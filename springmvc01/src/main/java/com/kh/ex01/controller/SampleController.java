package com.kh.ex01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {
	
	// localhost/ex01/doA 경로로 get 요청이 들어오면 실행됨
	// void : 요청경로(path = /WEB-INF/views/요청경로.jsp)로 포워드 (doA.jsp)
	@RequestMapping(value = "/doA", method = RequestMethod.GET)
	public void doA() {
		System.out.println("doA 실행됨");
	}
	
	@RequestMapping(value = "/doB", method = RequestMethod.GET)
	public void doB() {
		System.out.println("doB 실행됨");
	}
	
}
