package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.ex01.dao.BoardDao;
import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDao boardDao;
	
	@Override
	public boolean create(BoardVo boardVo) {
		boolean result = boardDao.create(boardVo);
		return result;
	}

	@Override
	public BoardVo read(int bno) {
		boardDao.updateViewCnt(bno);
		BoardVo boardVo = boardDao.read(bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		boolean result = boardDao.update(boardVo);
		return result;
	}

	@Override
	public boolean delete(int bno) {
		boolean result =  boardDao.delete(bno);
		return result;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		List<BoardVo> list = boardDao.list(pagingDto);
		return list;
	}

	@Override
	public int getCount(PagingDto pagingDto) {
		int count = boardDao.getCount(pagingDto);
		if (count > 0) {
			return count;
		}
		return 0;
	}

	@Override
	@Transactional
	public boolean insertReply(BoardVo boardVo) {
		boardDao.updateReSeq(boardVo);
		boolean result = boardDao.insertReply(boardVo);
		return result;
	}

}
