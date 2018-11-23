package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Schedule;

public interface ScheduleService {

	// 조건에 따라 Schedule return 
	List<Schedule> getScheduleBy() throws Exception;
	
	// schedule 추가
	int addSchedule(Schedule schedule) throws Exception;
	
	// schedule 삭제
	int deleteSchedule(int scheduleNo) throws Exception;
	
	// schedule 수정
	int updateSchedule(Schedule schedule) throws Exception;
}
