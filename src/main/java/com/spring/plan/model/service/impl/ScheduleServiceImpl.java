package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.ScheduleDao;
import com.spring.plan.model.service.ScheduleService;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Schedule;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Resource
	ScheduleDao scheduleDao;
	@Override
	public int addSchedule(Schedule schedule) throws Exception {
		String sd = schedule.getScheduleStartDate();
		String ed = schedule.getScheduleEndDate();
		
		return scheduleDao.addSchedule(schedule);
	}

	@Override
	public int deleteSchedule(int scheduleNo) throws Exception {
		return scheduleDao.deleteSchedule(scheduleNo);
	}

	@Override
	public int updateSchedule(Schedule schedule) throws Exception {
		return scheduleDao.updateSchedule(schedule);
	}

	@Override
	public List<Schedule> getScheduleByDay(Daily daily) throws Exception {
		return scheduleDao.getScheduleByDay(daily);
	}

	@Override
	public List<Schedule> getScheduleByMonth(Daily daily) throws Exception {
		return scheduleDao.getScheduleByMonth(daily);
	}

	@Override
	public Schedule getScheduleDetail(int scheduleNo) throws Exception {
		return scheduleDao.getScheduleDetail(scheduleNo);
	}

}