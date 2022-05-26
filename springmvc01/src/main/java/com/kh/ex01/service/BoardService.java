package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

public interface BoardService {

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
	
	// 
	public int getCount(PagingDto pagingDto);
	
	public boolean insertReply(BoardVo boardVo);

}
