package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

public interface MessageService {
	
	public static final String TYPE_SENDER = "sender";
	public static final String TYPE_RECEIVER = "receiver";
	
	public boolean sendMessage(MessageVo messageVo);
	
	public MessageVo readMessage(int mid, PointVo pointVo);
	
	public List<MessageVo> listMessage(String userid, String mType);
	
}
