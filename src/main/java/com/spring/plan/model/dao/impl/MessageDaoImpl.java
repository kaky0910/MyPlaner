package com.spring.plan.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.MessageDao;
import com.spring.plan.model.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	@Resource
	SqlSession sqlSession;

	@Override
	public List<Message> getSendMessageList(String nickname) throws Exception {

		return sqlSession.selectList("message-mapper.getSendMessageList", nickname);
	}

	@Override
	public List<Message> getMessageList(String nickname) throws Exception {
		return sqlSession.selectList("message-mapper.getMessageList", nickname);
	}

	@Override
	public int deleteMessage(int messageNo) throws Exception {
		return sqlSession.delete("message-mapper.deleteMessage", messageNo);
	}

	@Override
	public Message getMessage(int messageNo) throws Exception {
		return sqlSession.selectOne("message-mapper.getMessage", messageNo);
	}

	@Override
	public int sendMessage(Message message) throws Exception {
		return sqlSession.insert("message-mapper.sendMessage", message);
	}

}
