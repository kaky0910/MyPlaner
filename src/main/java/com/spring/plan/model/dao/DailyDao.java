package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Daily;
import com.spring.plan.model.vo.Member;

public interface DailyDao {
	
	//감정 체크
	int insertEmotion(Daily daily) throws Exception;
	
	//다른거 체크
	int updateEmotion(Daily daily) throws Exception;
	
	//한해 감정 정보 리턴
	List<Daily> selectEmotionByYear(int year) throws Exception;
	
	// memo 받기
	String getMemo(int memberNo) throws Exception;
		
	// memo update
	int updateMemo(Member member) throws Exception;
	
	// insert memo 회원가입할때 추가
	int insertMemo(Member member) throws Exception;
	
	// 오늘 emotion return
	String getTodayEmotion(Daily daily) throws Exception;
	
	//////////통    계~~~~~~~~~~~~~~~~~~~~~
}
