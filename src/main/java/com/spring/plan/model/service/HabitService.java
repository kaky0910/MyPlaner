package com.spring.plan.model.service;

import com.spring.plan.model.vo.Habit;

public interface HabitService {
	// habit 추가 :: index.jsp 에서
	int addHabit(Habit habit) throws Exception;

	// habit 삭제
	int deleteHabit(Habit habit) throws Exception;

	// 체크 and 체크 해제 (tracker에서)
	int checkHabit(Habit habit, String day) throws Exception;

	// 해당 월의 habit 체크한 기록 return
	String getHabitCheckByMonth(Habit habit, String month) throws Exception; // getHabitCheckByWeek는 이 method로
}
