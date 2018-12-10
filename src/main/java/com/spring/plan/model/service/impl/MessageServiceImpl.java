package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.MessageDao;
import com.spring.plan.model.service.MessageService;
import com.spring.plan.model.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	MessageDao messageDao;

	@Override
	public List<Message> getSendMessageList(String nickname) throws Exception {
		return messageDao.getSendMessageList(nickname);
	}

	@Override
	public List<Message> getMessageList(String nickname) throws Exception {
		return messageDao.getMessageList(nickname);
	}

	@Override
	public int deleteMessage(int messageNo) throws Exception {
		if (messageDao.deleteMessage(messageNo) == 0) {
			System.out.println("★ deleteMessage 실패");
			return 0;
		}
		return 1;
	}

	@Override
	public Message getMessage(int messageNo) throws Exception {
		return messageDao.getMessage(messageNo);
	}

	@Override
	public int sendMessage(Message message) throws Exception {
		if (messageDao.sendMessage(message) == 0) {
			System.out.println("★ sendMessage 실패");
			return 0;
		}
		return 1;
	}

}
