package com.spring.plan.model.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.plan.model.service.MessageService;
import com.spring.plan.model.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Override
	public List<Message> getSendMessageList(String nickname) throws Exception {
		return null;
	}

	@Override
	public List<Message> getMessageList(String nickname) throws Exception {
		return null;
	}

	@Override
	public int deleteMessage(int messageNo) throws Exception {
		return 0;
	}

	@Override
	public Message getMessage(int messageNo) throws Exception {
		return null;
	}

	@Override
	public int sendMessage(Message message) throws Exception {
		return 0;
	}

}
