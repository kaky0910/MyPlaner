package com.spring.plan.model.dao;

import org.springframework.stereotype.Repository;

public interface DailyDao {
	
	int setEmotion(String nickname, String emotion) throws Exception;
	String getEmotionByYear(String year) throws Exception;
	
	
	//////////Ελ    °θ~~~~~~~~~~~~~~~~~~~~~
}
