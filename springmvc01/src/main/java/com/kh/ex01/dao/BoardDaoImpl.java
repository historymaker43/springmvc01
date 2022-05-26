package com.kh.ex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.BoardVo;
import com.kh.ex01.vo.PagingDto;

@Repository
public class BoardDaoImpl implements BoardDao {

	@Autowired
	private SqlSession sqlSession;
	
	private final String NAMESPACE = "com.kh.ex01.mappers.board.";
	
	@Override
	public boolean create(BoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "create", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public BoardVo read(int bno) {
		BoardVo boardVo = sqlSession.selectOne(NAMESPACE + "read", bno);
		return boardVo;
	}

	@Override
	public boolean update(BoardVo boardVo) {
		int result = sqlSession.update(NAMESPACE + "update", boardVo);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(int bno) {
		int count = sqlSession.delete(NAMESPACE + "delete", bno);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<BoardVo> list(PagingDto pagingDto) {
		List<BoardVo> list = sqlSession.selectList(
				NAMESPACE + "list", pagingDto);
		return list;
	}
	
	@Override
	public int getCount(PagingDto pagingDto) {
		int count = sqlSession.selectOne(NAMESPACE + "getCount", pagingDto);
		if (count > 0) {
			return count;
		}
		return 0;
	}

	@Override
	public boolean insertReply(BoardVo boardVo) {
		int count = sqlSession.insert(NAMESPACE + "insertReply", boardVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public void updateReSeq(BoardVo boardVo) {
		sqlSession.update(NAMESPACE + "updateReSeq", boardVo);
	}

	@Override
	public void updateViewCnt(int bno) {
		sqlSession.update(NAMESPACE + "updateViewCnt", bno);
		
	}

}
