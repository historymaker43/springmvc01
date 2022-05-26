package com.kh.ex01.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.ex01.service.MessageService;
import com.kh.ex01.vo.MemberVo;
import com.kh.ex01.vo.MessageVo;

@Controller
@RequestMapping("/message")
public class MessageController {
	
	@Autowired
	private MessageService messageService;
	
	@RequestMapping(value = "/receive", method = RequestMethod.GET)
	public String receiveList(HttpSession session, Model model) {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		String userid = loginVo.getUserid();
		List<MessageVo> messageList = messageService.listMessage(userid, messageService.TYPE_RECEIVER);
		model.addAttribute("messageList", messageList);
		
		return "message/receiveList";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String sendList(HttpSession session, Model model) {
		MemberVo loginVo = (MemberVo)session.getAttribute("loginVo");
		String userid = loginVo.getUserid();
		List<MessageVo> messageList = messageService.listMessage(userid, messageService.TYPE_SENDER);
		model.addAttribute("messageList", messageList);
		
		return "message/sendList";
	}
}
