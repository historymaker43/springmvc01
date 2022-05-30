package com.kh.ex01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {
	
	// 가로채기 전(요청 처리 전 : 인터셉트)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle() 실행됨");
		return super.preHandle(request, response, handler);
	}
	
	// 요청처리 - 얘가 하는게 아니라 컨트롤러가 할 일
	
	// 요청 처리 후
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle() 실행됨");
		super.postHandle(request, response, handler, modelAndView);
	}

}
