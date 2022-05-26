package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.CommentVo;

public interface CommentDao {
	
	public boolean insertComment(CommentVo commentVo);

	public List<CommentVo> commentList(int bno);

	public boolean updateComment(CommentVo commentVo);

	public boolean deleteComment(int cno);
}
