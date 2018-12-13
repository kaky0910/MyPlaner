package com.spring.plan.model.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.MessageDao;
import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Message;

@Repository
public class MessageDaoImpl implements MessageDao {
	@Resource
	SqlSession sqlSession;

	@Override
	public List<Message> getSendMessageList(MessageListVO listVO) throws Exception {

		return sqlSession.selectList("message-mapper.getSendMessageList", listVO);
	}

	@Override
	public List<Message> getMessageList(MessageListVO listVO) throws Exception {
		return sqlSession.selectList("message-mapper.getMessageList", listVO);
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

	@Override
	public int totalSendMessageNumber(int memberNo) throws Exception {
		return sqlSession.selectOne("message-mapper.totalSendMessageNumber", memberNo);
	}

	@Override
	public int totalRecvMessageNumber(int memberNo) throws Exception {
		return sqlSession.selectOne("message-mapper.totalRecvMessageNumber", memberNo);
	}
}
