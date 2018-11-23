package com.spring.plan.model.service.impl;

import org.springframework.stereotype.Service;

import com.spring.plan.model.service.HabitService;
import com.spring.plan.model.vo.Habit;

@Service
public class HabitServiceImpl implements HabitService {

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
