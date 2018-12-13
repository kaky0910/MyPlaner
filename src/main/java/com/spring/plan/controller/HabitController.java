package com.spring.plan.controller;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthSeparatorUI;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.HabitService;
import com.spring.plan.model.vo.Habit;

@Controller
public class HabitController {
	
	@Resource
	private HabitService habitService;
	
	@RequestMapping("checkHabit.do")
	public ModelAndView checkHabit(Habit habit, String day) throws Exception{
		System.out.println("habit :::::::: "+habit);
		System.out.println("day :::::::::: "+day);
		int result = habitService.checkHabit(habit, day);
		if(result == 11) return new ModelAndView("JsonView","flag","check");
		else if(result == 1) return new ModelAndView("JsonView","flag","uncheck");
		else return new ModelAndView("JsonView","flag","fail");
	}
	
	@RequestMapping("addHabit.do")
	public ModelAndView addHabit(Habit habit,String day) throws Exception{
		
		habitService.addHabit(habit);
		habitService.addCheckHabit(habit, day);
		return new ModelAndView();
	}
	
	@RequestMapping("deleteHabit.do")
	public ModelAndView deleteHabit(Habit habit) throws Exception{
		
		return new ModelAndView();
	}
}
