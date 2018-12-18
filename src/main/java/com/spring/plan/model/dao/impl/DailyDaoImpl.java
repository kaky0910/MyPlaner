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
	public int insertinsertDailyInfo(Daily daily) throws Exception {
		return sqlSession.insert("daily-mapper.insertDailyInfo",daily);
	}

	@Override
	public int updateEmotion(Daily daily) throws Exception {
		return sqlSession.insert("daily-mapper.updateEmotion",daily);
	}

	@Override
	public List<Daily> selectEmotionByYear(int year) throws Exception {
		return sqlSession.selectList("daily-mapper.selectEmotionByYear",year);
	}

	@Override
	public String getMemo(int memberNo) throws Exception {
		return sqlSession.selectOne("daily-mapper.getMemo",memberNo);
	}

	@Override
	public int updateMemo(Member member) throws Exception {
		return sqlSession.update("daily-mapper.updateMemo",member);
	}

	@Override
	public int insertMemo(Member member) throws Exception {
		return sqlSession.insert("daily-mapper.insertMemo",member);
	}

	@Override
	public String getTodayEmotion(Daily daily) throws Exception {
		return sqlSession.selectOne("daily-mapper.getTodayEmotion",daily);
	}

	@Override
	public int isExist(Daily daily) throws Exception {
		return sqlSession.selectOne("daily-mapper.getDailyInfo",daily);
	}

}

