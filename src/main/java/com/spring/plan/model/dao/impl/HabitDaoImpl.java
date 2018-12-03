package com.spring.plan.model.dao.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.HabitDao;
import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

@Repository
public class HabitDaoImpl implements HabitDao{

	@Resource
	SqlSession sqlSession;
	
	@Override
	public int addHabit(Habit habit) throws Exception {
		return sqlSession.insert("habit-mapper.addHabit",habit);
	}

	@Override
	public int deleteHabit(Habit habit) throws Exception {
		return sqlSession.delete("habit-mapper.deleteHabit",habit);
	}

	@Override
	public int checkHabit(Habit habit, String day) throws Exception {			//service로 옮길까
		CheckHabit checkHabit = new CheckHabit();
		checkHabit.setHabit(habit);
		checkHabit.setMonth(day.substring(0, 6));
		String getCheck = sqlSession.selectOne("habit-mapper.getCheckHabit",checkHabit);
		char[] arr = getCheck.toCharArray();
		arr[Integer.parseInt(day.substring(6,8))-1]=1;
		checkHabit.setCheckHabit(new String(arr));
		return sqlSession.update("habit-mapper.checkHabit",checkHabit);
	}

	@Override
	public String getHabitCheckByMonth(Habit habit, String month) throws Exception {
		return null;
	}

}
