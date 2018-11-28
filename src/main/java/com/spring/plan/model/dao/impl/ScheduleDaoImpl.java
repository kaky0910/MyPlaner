package com.spring.plan.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.ScheduleDao;
import com.spring.plan.model.vo.Schedule;

@Repository
public class ScheduleDaoImpl implements ScheduleDao {

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

	@Override
	public List<Schedule> getScheduleByDay(String day) throws Exception {
		return null;
	}

	@Override
	public List<Schedule> getScheduleByMonth(String month) throws Exception {
		return null;
	}

}
