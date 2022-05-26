package com.kh.ex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.CommentVo;

@Repository
public class CommetDaoImpl implements CommentDao {

	private final String NAMESPACE = "com.kh.ex01.mappers.comment.";
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public boolean insertComment(CommentVo commentVo) {
		int count = sqlSession.insert(NAMESPACE + "insertComment", commentVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<CommentVo> commentList(int bno) {
		List<CommentVo> commentList = sqlSession.selectList(NAMESPACE + "commentList", bno);
		return commentList;
	}

	@Override
	public boolean updateComment(CommentVo commentVo) {
		int count = sqlSession.update(NAMESPACE + "updateComment", commentVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteComment(int cno) {
		int count = sqlSession.delete(NAMESPACE + "deleteComment", cno);
		if (count > 0) {
			return true;
		}
		return false;
	}

}
