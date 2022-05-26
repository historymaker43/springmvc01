package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.MemberVo;

public interface MemberService {
	
public void insertMember(MemberVo memberVo); // 회원 추가
	
	// 회원 목록 조회
	public List<MemberVo> getMemberList();
	
	// 아이디로 조회
	public MemberVo getMemberById(String userid);
	
	// 회원 수정
	public boolean modifyMember(MemberVo memberVo);
	
	// 회원 삭제
	public boolean deleteMember(String userid);
	
	// 로그인
	public MemberVo getMemberByIdAndPw(String userid, String userpw);
}
