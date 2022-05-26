package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.MessageVo;

public interface MessageDao {
	
	public boolean insertMessage(MessageVo messageVo);

	public MessageVo readMessage(int mid);

	public boolean updateOpenDate(int mid);

	public boolean deleteMessage(int mid);

	public List<MessageVo> listMessage(String userid, String mType);
}
