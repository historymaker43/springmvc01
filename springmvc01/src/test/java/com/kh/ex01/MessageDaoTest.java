package com.kh.ex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.MessageDao;
import com.kh.ex01.vo.MessageVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MessageDaoTest {

	@Autowired
	private MessageDao messageDao;
	
	@Test
	public void testInsertMessage() {
		for (int i = 1; i < 10; i++) {
			MessageVo messageVo = new MessageVo("user02", "user01", "Hi-" + i);
			boolean result = messageDao.insertMessage(messageVo);
			System.out.println("result : " + result);
		}
	}
	
	@Test
	public void testReadMessage() {
		MessageVo messageVo = messageDao.readMessage(2);
		System.out.println("messageVo : " + messageVo);
	}
	
	@Test
	public void testUpdateOpenDate() {
		boolean result = messageDao.updateOpenDate(1);
		System.out.println("result : " + result);
	}
	
	@Test
	public void testDeleteMessage() {
		boolean result = messageDao.deleteMessage(1);
		System.out.println("result : " + result);
	}
	
	@Test
	public void testListMessage() {
		List<MessageVo> listMessage = messageDao.listMessage("user01", "receiver");
		System.out.println("listMessage : " + listMessage);
	}
}
