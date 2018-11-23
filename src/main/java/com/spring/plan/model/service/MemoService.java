package com.spring.plan.model.service;

public interface MemoService {

	// memo ¹Þ±â
	String getMemo(String nickname, String memo) throws Exception;
	
	// memo update
	int updateMemo(String nickname, String memo) throws Exception;
}
