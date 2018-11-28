package com.spring.plan.model.dao;

import com.spring.plan.model.vo.Daily;

public interface DailyDao {
	
	int insertEmotion(Daily daily) throws Exception;
	String selectEmotionByYear(int year) throws Exception;
	
	
	//////////Ελ    °θ~~~~~~~~~~~~~~~~~~~~~
}
