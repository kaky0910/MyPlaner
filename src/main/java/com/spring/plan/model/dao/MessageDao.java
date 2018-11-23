package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.vo.Message;

public interface MessageDao {
	
	// 보낸 메세지 list (paging)
	List<Message> getSendMessageList(String nickname) throws Exception;
	
	// 받은 메세지 list (paging)
	List<Message> getMessageList(String nickname) throws Exception;
	
	// 메세지 삭제
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo을 가진 메세지 정보 return 
	Message getMessage(int messageNo) throws Exception;
	
	// 메세지 보내기 :: db에 등록
	int sendMessage(Message message) throws Exception;		
} 
