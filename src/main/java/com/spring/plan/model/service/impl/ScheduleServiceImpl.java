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
		int length = scheduleDao.getScheduleLength(schedule);
		StringBuffer sb = new StringBuffer();
		for (int i=0; i<length;i++) 
			sb.append("0");
		schedule.setScheduleCheck(sb.toString());
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

	@Override
	public int checkSchedule(Schedule schedule,String day) throws Exception {
		//////////////////////////////////schedule check
		int dayCount = scheduleDao.getScheduleLength(new Schedule(schedule.getScheduleStartDate(), day));
		
		char[] arr = schedule.getScheduleCheck().toCharArray();
		if(arr[dayCount-1]=='0') arr[dayCount-1] = '1';
		else arr[dayCount-1] ='0';
		
		int result = scheduleDao.checkSchedule(schedule);
		return result;
	}


}