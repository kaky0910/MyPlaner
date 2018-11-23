package com.spring.plan.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.plan.model.service.ScheduleService;
import com.spring.plan.model.vo.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Override
	public List<Schedule> getScheduleBy() throws Exception {
		return null;
	}

	@Override
	public int addSchedule(Schedule schedule) throws Exception {
		return 0;
	}

	@Override
	public int deleteSchedule(int scheduleNo) throws Exception {
		return 0;
	}

	@Override
	public int updateSchedule(Schedule schedule) throws Exception {
		return 0;
	}

}
