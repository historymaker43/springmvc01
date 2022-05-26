package com.kh.ex01.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.ex01.vo.PointVo;

@Repository
public class PointDaoImpl implements PointDao {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.kh.ex01.mappers.point.";

	@Override
	public boolean insertPoint(PointVo pointVo) {
		int count = sqlSession.insert(NAMESPACE + "insertPoint", pointVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<PointVo> pointList(String userid) {
		List<PointVo> pointList = sqlSession.selectList(NAMESPACE + "pointList", userid);
		return pointList;
	}

	@Override
	public boolean updatePoint(PointVo pointVo) {
		int count = sqlSession.update(NAMESPACE + "updatePoint", pointVo);
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deletePoint(int pid) {
		int count = sqlSession.delete(NAMESPACE + "deletePoint", pid);
		if (count > 0) {
			return true;
		}
		return false;
	}

}