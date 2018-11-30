package com.spring.plan.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.DailyDao;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;

@Repository
public class DailyDaoImpl implements DailyDao {

	@Resource
	private SqlSession sqlSession;
	
	@Override
	public int insertEmotion(Daily daily) throws Exception {
		return sqlSession.insert("daily-mapper.insertEmotion",daily);
	}

	@Override
	public int updateEmotion(Daily daily) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<String> selectEmotionByYear(int year) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMemo(int memberNo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMemo(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertMemo(Member member) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
