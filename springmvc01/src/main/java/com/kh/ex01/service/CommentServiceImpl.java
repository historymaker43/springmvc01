package com.kh.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.ex01.dao.CommentDao;
import com.kh.ex01.vo.CommentVo;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao; 
	
	@Override
	public boolean insertComment(CommentVo commentVo) {
		return commentDao.insertComment(commentVo);
	}

	@Override
	public List<CommentVo> commentList(int bno) {
		return commentDao.commentList(bno);
	}

	@Override
	public boolean updateComment(CommentVo commentVo) {
		return commentDao.updateComment(commentVo);
	}

	@Override
	public boolean deleteComment(int cno) {
		return commentDao.deleteComment(cno);
	}

}
