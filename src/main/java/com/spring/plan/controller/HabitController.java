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
	
	public ModelAndView sample() throws Exception{
		return new ModelAndView();
	}
	
	@RequestMapping("checkHabit.do")
	public ModelAndView checkHabit(Habit habit, String day) throws Exception{
		System.out.println("habit :::::::: "+habit);
		System.out.println("day :::::::::: "+day);
		habitService.checkHabit(habit, day);
		return new ModelAndView("JsonView","flag","success");
	}

}
