package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

public interface BoardDao {
	
	// 글쓰기 (Create)
	public boolean create(BoardVo boardVo);
	
	// 글읽기(Read) - 글 1개
	public BoardVo read(int bno);
	
	// 글 수정(Update)
	public boolean update(BoardVo boardVo);
	
	// 글삭제(Delete)
	public boolean delete(int bno);
	
	// 글목록 (Read)
	public List<BoardVo> list(PagingDto pagingDto);
	
	// 갯수 구하기(page)
	public int getCount(PagingDto pagingDto);
	
	// 답글 쓰기
	public boolean insertReply(BoardVo boardVo);
	
	// 답글 순서 조정
	public void updateReSeq(BoardVo boardVo);
	
	// 조회수 증가
	public void updateViewCnt(int bno);
}
