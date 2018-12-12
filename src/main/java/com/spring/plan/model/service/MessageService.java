package com.spring.plan.model.service;

import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Message;

public interface MessageService {
	
	// 보낸 메세지 list (paging)
	MessageListVO getSendMessageList(int memberNo, int spageNo) throws Exception;
	
	// 받은 메세지 list (paging)
	MessageListVO getMessageList(int memberNo, int rpageNo) throws Exception;
	
	// 메세지 삭제
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo을 가진 메세지 정보 return 
	Message getMessage(int messageNo) throws Exception;
	
	// 메세지 보내기 :: db에 등록
	int sendMessage(Message message) throws Exception;		
	
	
} 
