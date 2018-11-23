package com.spring.plan.model.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.HabitDao;
import com.spring.plan.model.vo.Habit;

@Repository
public class HabitDaoImpl implements HabitDao{

	@Override
	public int addHabit(Habit habit) throws Exception {
		return 0;
	}

	@Override
	public int deleteHabit(Habit habit) throws Exception {
		return 0;
	}

	@Override
	public int checkHabit(Habit habit, String day) throws Exception {
		return 0;
	}

	@Override
	public String getHabitCheckByMonth(Habit habit, String month) throws Exception {
		return null;
	}

}
