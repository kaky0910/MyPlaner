package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Schedule;

public interface ScheduleDao {

	// 당일 Schedule return index 1-2
	List<Schedule> getScheduleByDay(Daily daily) throws Exception;
	
	// 당월 Schedule return index 1-1
	List<Schedule> getScheduleByMonth(Daily daily) throws Exception;
	
	// index 1-1 에 detail 정보
	Schedule getScheduleDetail(int scheduleNo) throws Exception;
	
	// schedule 추가
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule 삭제
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule 수정
	int updateSchedule(Schedule schedule) throws Exception;
	
	// check schedule
	int checkSchedule(Schedule schedule) throws Exception;
}
