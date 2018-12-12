package com.spring.plan.model.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.MessageDao;
import com.spring.plan.model.service.MessageService;
import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.service.paging.PagingBean;
import com.spring.plan.model.vo.Message;

@Service
public class MessageServiceImpl implements MessageService {

	@Resource
	MessageDao messageDao;

	@Override
	public MessageListVO getSendMessageList(int memberNo, int spageNo) throws Exception {
		int pn = 0;
		if(spageNo == 0) pn=1;
		else pn = spageNo;
		
		int total = messageDao.totalSendMessageNumber(memberNo);
		
		PagingBean pb = new PagingBean(total, pn);
		
		MessageListVO param = new MessageListVO();
	
		param.setMemberNo(memberNo);
		param.setPageNo(spageNo);
		return new MessageListVO(messageDao.getSendMessageList(param), pb, memberNo);
	}
	
	@Override
	public MessageListVO getMessageList(int memberNo, int rpageNo) throws Exception {
		int pn = 0;
		if(rpageNo == 0) pn =1;
		else pn = rpageNo;
		
		int total = messageDao.totalRecvMessageNumber(memberNo);
		
		PagingBean pb = new PagingBean(total, pn);
		MessageListVO param = new MessageListVO();
		
		param.setMemberNo(memberNo);
		param.setPageNo(rpageNo);
		
		return new MessageListVO(messageDao.getMessageList(param), pb, memberNo);
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
