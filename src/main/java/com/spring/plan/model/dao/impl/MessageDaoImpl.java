package com.spring.plan.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.MessageDao;
import com.spring.plan.model.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {

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
