package com.spring.plan.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.ScheduleDao;
import com.spring.plan.model.service.ScheduleService;
import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;
import com.spring.plan.model.vo.Schedule;

@Controller
public class ScheduleController {

	@Resource
	private ScheduleService scheduleService;
	@Resource
	private ScheduleDao scheduleDao;
	
	@RequestMapping("addSchedule.do")
	public ModelAndView addSchedule(Schedule schedule) throws Exception{			//schedule 길이 계산해서 set 후 add
		StringBuffer scheduleCheck = new StringBuffer();
		int length = scheduleDao.getScheduleLength(schedule);
		for(int i=0;i<length+1;i++) {
			scheduleCheck.append("0");
		}
		schedule.setScheduleCheck(scheduleCheck.toString());
		scheduleService.addSchedule(schedule);
		
		return new ModelAndView();
	}
	
	@RequestMapping("getScheduleByMonth.do")
	public ModelAndView getScheduleByMonth(HttpSession session, String month) throws Exception{
		Daily daily = new Daily();
		daily.setMemberNo(((Member)session.getAttribute("member")).getMemberNo());
		System.out.println(month);
		daily.setMonth(month);
		daily.setDay(month+"01");
		List<Schedule> list = scheduleService.getScheduleByMonth(daily);
		daily.setScheduleList(list);
		return new ModelAndView("JsonView","daily",daily);
	}
	
	@RequestMapping("getScheduleByDay.do")
	public ModelAndView getScheduleByDay(String d,String month,HttpSession session) throws Exception{
		String day;
		if(d.substring(3).length()==1)
			day = month+"0"+d.substring(3);
		else day = month+d.substring(3);
		
		System.out.println(day);
		Daily daily = new Daily();
		daily.setDay(day);
		daily.setMemberNo(((Member)session.getAttribute("member")).getMemberNo());
		List<Schedule> list = scheduleService.getScheduleByDay(daily); 
		
		System.out.println(list);
		return new ModelAndView("JsonView","json",list);
	}
	
	@RequestMapping("deleteSchedule.do")
	public ModelAndView deleteSchedule(int scheduleNo) throws Exception{
		scheduleService.deleteSchedule(scheduleNo);
		return new ModelAndView();		//index?
	}
	
	@RequestMapping("updateSchedule.do")
	public ModelAndView updateSchedule(Schedule schedule) throws Exception{
		scheduleService.updateSchedule(schedule);
		return new ModelAndView(); 		//index?
	}
	
	@RequestMapping("checkSchedule*.do")
	   public ModelAndView checkChallenge(int scheduleNo) throws Exception{
			Schedule schedule = scheduleService.getScheduleDetail(scheduleNo);
		    String day = Daily.getDayByDate();
		    int result = scheduleService.checkSchedule(schedule, day);
		    if(result == 1) {		// 성공
		    	
		    }else {					// 실패
		    	
		    }
		    return new ModelAndView();
	   }
	
}
