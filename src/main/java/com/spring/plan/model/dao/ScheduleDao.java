package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Schedule;

public interface ScheduleDao {

	// 당일 Schedule return 
	List<Schedule> getScheduleByDay(String day) throws Exception;
	
	// 당월 Schedule return
	List<Schedule> getScheduleByMonth(String month) throws Exception;
	
	// schedule 추가
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule 삭제
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule 수정
	int updateSchedule(Schedule schedule) throws Exception;
}
