package com.spring.plan.model.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
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
		Period p = Period.between(LocalDate.of(Integer.parseInt(sd.substring(0, 4)), Integer.parseInt(sd.substring(4, 6)), Integer.parseInt(sd.substring(6)))
				, LocalDate.of(Integer.parseInt(ed.substring(0, 4)), Integer.parseInt(ed.substring(4,6)), Integer.parseInt(ed.substring(6))));
		int length = p.getDays()+1;

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
		String sd = schedule.getScheduleStartDate();
		Period p = Period.between(LocalDate.of(Integer.parseInt(sd.substring(0, 4)), Integer.parseInt(sd.substring(4, 6)), Integer.parseInt(sd.substring(6)))
				, LocalDate.of(Integer.parseInt(day.substring(0, 4)), Integer.parseInt(day.substring(4,6)), Integer.parseInt(day.substring(6))));
		int dayCount = p.getDays();
		Schedule s = scheduleDao.getScheduleDetail(schedule.getScheduleNo());
		char[] arr = s.getScheduleCheck().toCharArray();
		if(arr[dayCount]=='0') arr[dayCount] = '1';
		else arr[dayCount] ='0';
		s.setScheduleCheck(new String(arr));
		
		int result = scheduleDao.checkSchedule(s);
		return result;
	}


}