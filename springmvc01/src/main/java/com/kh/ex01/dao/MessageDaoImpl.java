package com.kh.ex01.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.MessageVo;

@Repository
public class MessageDaoImpl implements MessageDao {
	
	private String NAMESPACE = "com.kh.ex01.mappers.message.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean insertMessage(MessageVo messageVo) {
		int count = sqlSession.insert(NAMESPACE + "insertMessage", messageVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public MessageVo readMessage(int mid) {
		MessageVo messageVo = sqlSession.selectOne(NAMESPACE + "readMessage", mid);
		return messageVo;
	}

	@Override
	public boolean updateOpenDate(int mid) {
		int count = sqlSession.update(NAMESPACE + "updateOpenDate", mid);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteMessage(int mid) {
		int count = sqlSession.delete(NAMESPACE + "deleteMessage", mid);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MessageVo> listMessage(String userid, String mType) {
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("mType", mType);
		List<MessageVo> messageList = sqlSession.selectList(NAMESPACE + "listMessage", map);
		return messageList;
	}

}
