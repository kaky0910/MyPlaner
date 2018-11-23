package com.spring.plan.model.dao;

public interface MemoDao {

	// memo ¹Þ±â
	String getMemo(String nickname, String memo) throws Exception;
	
	// memo update
	int updateMemo(String nickname, String memo) throws Exception;
}
