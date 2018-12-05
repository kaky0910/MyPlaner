package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.HabitDao;
import com.spring.plan.model.service.HabitService;
import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

@Service
public class HabitServiceImpl implements HabitService {
	
	@Resource
	private HabitDao habitDao;

	@Override
	public int addHabit(Habit habit) throws Exception {
		int result = habitDao.addHabit(habit);
		CheckHabit checkHabit = new CheckHabit();
		checkHabit.setMemberNo(habit.getMemberNo());
		checkHabit.setHabit(habit.getHabit());
		checkHabit.setMonth(habit.getHabitStartDate().substring(0, 6));
		result += habitDao.addCheckHabit(checkHabit)*10;
		return result;
	}

	@Override
	public int deleteHabit(Habit habit) throws Exception {
		return habitDao.deleteHabit(habit);
	}

	@Override
	public int checkHabit(Habit habit, String day) throws Exception {
		CheckHabit checkHabit = new CheckHabit();
		checkHabit.setMemberNo(habit.getMemberNo());
		checkHabit.setHabit(habit.getHabit());
		checkHabit.setMonth(day.substring(0, 6));
		CheckHabit getCheck = habitDao.getCheckHabitByMonth(checkHabit);
		char[] arr = getCheck.getCheckHabit().toCharArray();
		if(arr[Integer.parseInt(day.substring(6,8))+5]==0)					////////////////////////////陥獣びびびびびびびびびびびびびびびびび
			arr[Integer.parseInt(day.substring(6,8))+5]=1;
		else arr[Integer.parseInt(day.substring(6,8))+5]=0;
		checkHabit.setCheckHabit(new String(arr));

		return habitDao.checkHabit(checkHabit);
	}

	@Override
	public CheckHabit getCheckHabitByMonth(CheckHabit checkHabit) throws Exception {
		return habitDao.getCheckHabitByMonth(checkHabit);
	}

	@Override
	public List<Habit> getHabitList(int memberNo) throws Exception {
		return habitDao.getHabitList(memberNo);
	}

}
