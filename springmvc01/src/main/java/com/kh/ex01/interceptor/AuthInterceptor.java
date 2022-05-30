package com.kh.ex01.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.kh.ex01.vo.MemberVo;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	// 로그인 되어 있지 않다면, 로그인창으로 이동(session-loginVo)
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("로그인 상태 체크");
		HttpSession session = request.getSession();
		MemberVo memberVo = (MemberVo)session.getAttribute("loginVo");
		if (memberVo == null) {
			response.sendRedirect("/");
			return false; // 실제 요청 처리하지 않음
		}
		return true; // 실제 요청을 처리함
	}
	
}
