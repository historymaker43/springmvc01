package com.kh.ex01.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.ex01.vo.ProductVo;

@Controller
public class SampleController3 {
	
	// 컨트롤러에서 ajax (Data-send)의 역할을 담당한다.
	@RequestMapping(value = "/doH", method = RequestMethod.GET)
	@ResponseBody
	// -> 리턴하는 데이터 자체
	public String doH() {
		System.out.println("doH 실행됨");
		return "home"; // /WEB-INF/.../home.jsp 가 아니라 "home"이라는 문자열 데이터 자체를 리턴
	}
	
	@RequestMapping(value = "/doI", method = RequestMethod.GET)
	@ResponseBody
	public ProductVo doI() {
		// pom.xml 에 jackson-databind <dependency> 추가
		// JSON 데이터로 변환해서 리턴
		ProductVo productVo = new ProductVo("갤럭시", 50000);
		
		return productVo; 
	}
	
	@RequestMapping(value = "/doJ", method = RequestMethod.GET)
	@ResponseBody
	public List<ProductVo> doJ(){
		List<ProductVo> list = new ArrayList<ProductVo>();
		for(int i = 1; i <= 10; i++) {
			ProductVo productVo = new ProductVo("제품 - " + i, i * 10000);
			list.add(productVo);
		}
		return list;
	}
	
}
