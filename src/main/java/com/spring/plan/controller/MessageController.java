package com.spring.plan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.MessageService;
import com.spring.plan.model.vo.Member;
import com.spring.plan.model.vo.Message;

@Controller
public class MessageController {
	
	@Resource
	MessageService service;
	
	/*@RequestMapping("getSendMessageList.do")
	public ModelAndView getSendMessageList(HttpSession session) throws Exception{
		Member member = (Member) session.getAttribute("member");
		List<Message> msgList = new ArrayList<Message>();
		
		if(session.getAttribute("member")!=null)
			msgList = service.getMessageList(member.getMemberNo()+"");
		
		return new ModelAndView("messagelist","msgList",msgList);
	}*/
	
	@RequestMapping("getMessageList.do")
	public ModelAndView getMessageList(HttpServletRequest request, HttpSession session) throws Exception{
		Member member = (Member) session.getAttribute("member");
		
		List<Message> recvMSGList = new ArrayList<Message>(); //받은 쪽지 리스트
		List<Message> sendMSGList = new ArrayList<Message>(); //보낸 쪽지 리스트
		
		if(member!=null) {
			recvMSGList = service.getMessageList(member.getMemberNo()+"");
			sendMSGList = service.getSendMessageList(member.getMemberNo()+"");
			
			request.setAttribute("sendList", sendMSGList);
		}
		return new ModelAndView("messagelist","recvList",recvMSGList);
	}
	
	@RequestMapping("deleteMessage.do")
	public ModelAndView deleteMessage(int messageNo,HttpServletRequest request, HttpSession session) throws Exception{
		service.deleteMessage(messageNo);
		return getMessageList(request, session);
	}
	
	@RequestMapping("getMessage.do")
	public ModelAndView getMessage(int messageNo) throws Exception{
		Message message = service.getMessage(messageNo);
		return new ModelAndView("messageview","message",message);
	}
	
	@RequestMapping("sendMessage.do")
	public ModelAndView sendMessage(Message message, HttpSession session) throws Exception{
		if(session.getAttribute("member")!=null)
			service.sendMessage(message);
		
		Member member = (Member)session.getAttribute("member");
		return new ModelAndView("redirect:getMessageList.do");
	}
}
