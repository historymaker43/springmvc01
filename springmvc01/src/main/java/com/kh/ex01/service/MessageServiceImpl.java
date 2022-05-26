package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.ex01.dao.MessageDao;
import com.kh.ex01.dao.PointDao;
import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	@Autowired
	private PointDao pointDao;
	
	@Override
	@Transactional
	public boolean sendMessage(MessageVo messageVo) {
		
		// tbl_message : insert
		boolean result1 = messageDao.insertMessage(messageVo);
		
		// tbl_member : update
		PointVo pointVo = new PointVo(messageVo.getSender(), pointDao.SEND_MESSAGE_POINT, PointDao.SEND_MESSAGE_CODE);
		boolean result2 = pointDao.updatePoint(pointVo);
		
		// tbl_point : insert
		boolean result3 = pointDao.insertPoint(pointVo);
		
		if (result1 && result2 && result3) {
			return true;
		}
		return false;
	}

	@Override
	@Transactional
	public MessageVo readMessage(int mid, PointVo pointVo) {
		// tbl_message : opendate - update
		boolean result1 = messageDao.updateOpenDate(mid);
		
		// tbl_member : point - update  
		boolean result2 = pointDao.updatePoint(pointVo);
		
		// tbl_point : insert
		boolean result3 = pointDao.insertPoint(pointVo);
		
		if (result1 && result2 && result3) {
			MessageVo messageVo = messageDao.readMessage(mid);
			return messageVo;
		}
		return null;
	}

	@Override
	public List<MessageVo> listMessage(String userid, String mType) {
		List<MessageVo> messageList = messageDao.listMessage(userid, mType);
		return messageList;
	}

}
