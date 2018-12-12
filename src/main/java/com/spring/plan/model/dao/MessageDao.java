package com.spring.plan.model.dao;

import java.util.List;

import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Message;

public interface MessageDao {
	
	// 보낸 메세지 list (paging)
	List<Message> getSendMessageList(MessageListVO listVO) throws Exception;
	
	// 받은 메세지 list (paging)
	List<Message> getMessageList(MessageListVO listVO) throws Exception;
	
	// 메세지 삭제
	int deleteMessage(int messageNo) throws Exception;
	
	// messageNo을 가진 메세지 정보 return 
	Message getMessage(int messageNo) throws Exception;
	
	// 메세지 보내기 :: db에 등록
	int sendMessage(Message message) throws Exception;
	
	int totalSendMessageNumber(int memberNo) throws Exception;
	
	int totalRecvMessageNumber(int memberNo) throws Exception;
} 
