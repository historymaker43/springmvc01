package com.kh.ex01.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;

import org.apache.catalina.valves.rewrite.RewriteRule;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.ex01.service.MemberService;
import com.kh.ex01.util.MyFileUploader;
import com.kh.ex01.vo.MemberVo;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	// value = "", 
	@RequestMapping(value = "/getMemberById", method = RequestMethod.GET)
	public String getMemberById(String userid, Model model) {
		MemberVo memberVo = memberService.getMemberById(userid);
		model.addAttribute("memberVo", memberVo);
		return "member/info";
	};
	
	@RequestMapping(value = "/join_form", method = RequestMethod.GET)
	public String joinForm() {
		
		return "member/join_form";
	}
	
	@RequestMapping(value = "/join_run", method = RequestMethod.POST)
	public String joinRun(MemberVo memberVo, MultipartFile file) {
		
		System.out.println("MemberController, join_run, MultipartFile : " + file);
		String originalFilename = file.getOriginalFilename();
		System.out.println("origin file name : " + originalFilename);
		long size = file.getSize();
		System.out.println("size : " + size);
		// file.getBytes(); // 실제 바이너리 파일
		try {
			String m_pic = MyFileUploader.uploadFile("C:/m_pic", originalFilename, file.getBytes());
			memberVo.setM_pic(m_pic);
			System.out.println("MemberController, join_run, memberVo : " + memberVo);
			memberService.insertMember(memberVo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userid, String userpw, HttpSession session, RedirectAttributes rttr) {
		System.out.println("userid : " + userid);
		System.out.println("userpw : " + userpw);
		MemberVo memberVo = memberService.getMemberByIdAndPw(userid, userpw);
		if (memberVo == null) {
			rttr.addFlashAttribute("login_result", "fail");
			return "redirect:/";
		} else {
			session.setAttribute("loginVo", memberVo);
			return "redirect:/board/list?page=1";
		}
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate(); // 세션 전체 데이터 무효화
		//session.setAttribute("a", xxx); -> session.removeAttribute("a"); // 세션 값 하나만 무효화
		//session.setAttribute("b", xxx);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/displayImage", method = RequestMethod.GET)
	@ResponseBody
	public byte[] displayImage(String filename) throws Exception {
		FileInputStream fis;
		fis = new FileInputStream(filename);
		byte[] data = IOUtils.toByteArray(fis);
		fis.close();
		return data;
	}
}
