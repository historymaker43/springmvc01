package com.kh.ex01.service;

import java.util.List;

import com.kh.ex01.vo.CommentVo;

public interface CommentService {

	public boolean insertComment(CommentVo commentVo);

	public List<CommentVo> commentList(int bno);

	public boolean updateComment(CommentVo commentVo);

	public boolean deleteComment(int cno);
	
}
