package com.kh.ex01;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.PointDao;
import com.kh.ex01.service.MessageService;
import com.kh.ex01.vo.MessageVo;
import com.kh.ex01.vo.PointVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MessageServiceTest {
	
	@Autowired
	private MessageService messageService;
	
	@Test
	public void testSendMesseage() {
		MessageVo messageVo = new MessageVo("user01", "user02", "Hello1~!");
		boolean result = messageService.sendMessage(messageVo);
		System.out.println("result : " + result);
	}
	
	@Test
	public void testReadMessage() {
		int mid = 31; // user01 -> user02 - Hello
		PointVo pointVo = new PointVo();
		pointVo.setUserid("user02");
		pointVo.setPoint(PointDao.READ_MESSAGE_POINT);
		pointVo.setPcode(PointDao.READ_MESSAGE_CODE);
		MessageVo messageVo = messageService.readMessage(mid, pointVo);
		System.out.println("messageVo : " + messageVo);
	}
	
}
