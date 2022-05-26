package com.kh.ex01.dao;

import java.util.List;

import com.kh.ex01.vo.PointVo;

public interface PointDao {
	
	public static final int SEND_MESSAGE_POINT = 10;
	public static final int READ_MESSAGE_POINT = 5;
	
	public static final int SEND_MESSAGE_CODE = 1001;
	public static final int READ_MESSAGE_CODE = 1002;
	
	public boolean insertPoint(PointVo pointVo);
	
	public List<PointVo> pointList(String userid);
	
	public boolean updatePoint(PointVo pointVo);
	
	public boolean deletePoint(int pid);
	
}
