package com.kh.ex01;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kh.ex01.dao.MemberDao;
import com.kh.ex01.vo.MemberVo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/*.xml")
public class MemberDaoTest {

	@Autowired // 자동주입
	// -> @Inject(자바가 제공해준것), @Autowired(스프링이 제공해준것)
	
	@Qualifier("impl") // 한정자
	private MemberDao memberDao;
	
	@Test
	public void testGetTime() {
		String time = memberDao.getTime();
		System.out.println("time : " + time);
	}
	
	@Test
	public void testInsertMember() {
		MemberVo memberVo = new MemberVo("user02", "1234", "유저02", "user02@email.com");
		memberDao.insertMember(memberVo);
	}
	
	@Test
	public void testGetMemberList() {
		List<MemberVo> memberList = memberDao.getMemberList();
		System.out.println("memberList : " + memberList);
	}
	
	@Test
	public void testGetMemberById() {
		MemberVo memberVo = memberDao.getMemberById("user01");
		System.out.println("memberVo : " + memberVo);
	}
	
	@Test
	public void testMemberDao() {
		System.out.println("memberDao : " + memberDao);
	}

	@Test
	public void testModifyMember() {
		MemberVo memberVo = new MemberVo("user01", "5678", "유우저01", "uuser01.email.com");
		boolean result = memberDao.modifyMember(memberVo);
		System.out.println("result : " + result);
	}
	
	@Test
	public void testDeleteMember() {
		boolean result = memberDao.deleteMember("user01");
		System.out.println("result : " + result);
	}
}
