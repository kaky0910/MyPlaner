package com.spring.plan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.MessageService;
import com.spring.plan.model.service.paging.MessageListVO;
import com.spring.plan.model.vo.Member;
import com.spring.plan.model.vo.Message;

@Controller
public class MessageController {
	
	@Resource
	MessageService service;
	
	@RequestMapping("getSendMessageList.do")
	public ModelAndView getSendMessageList(HttpServletRequest request) throws Exception{
		Member member = (Member) request.getSession().getAttribute("member");
		
		String spageNo = request.getParameter("spageNo");
		MessageListVO sendMSGList = null; //보낸 쪽지 리스트
		
		
		if(member!=null) {
			if(spageNo==null  )
				spageNo = "1";
			sendMSGList = service.getSendMessageList(member.getMemberNo(), Integer.parseInt(spageNo));
			
		}
		return new ModelAndView("message/sendmessagelist","sendList",sendMSGList);
	}
	
	@RequestMapping("getMessageList.do")
	public ModelAndView getMessageList(HttpServletRequest request) throws Exception{
		Member member = (Member) request.getSession().getAttribute("member");
		
		String rpageNo = request.getParameter("rpageNo");
		
		MessageListVO recvMSGList = null; //받은 쪽지 리스트
		
		if(member!=null) {
			if(rpageNo==null ||rpageNo.equals(""))
				rpageNo = "1";
			recvMSGList = service.getMessageList(member.getMemberNo(), Integer.parseInt(rpageNo));
		}
	
		return new ModelAndView("message/recvmessagelist","recvList",recvMSGList);
	}
	
	@RequestMapping("deleteMessage.do")
	public ModelAndView deleteMessage(int messageNo,HttpServletRequest request, HttpSession session) throws Exception{
		service.deleteMessage(messageNo);
		return getMessageList(request);
	}
	
	@RequestMapping("getMessage.do")
	public ModelAndView getMessage(int messageNo) throws Exception{
		Message message = service.getMessage(messageNo);
		return new ModelAndView("message/messageview","message",message);
	}
	
	@RequestMapping("sendMessage.do")
	public ModelAndView sendMessage(Message message, HttpSession session) throws Exception{
		if(session.getAttribute("member")!=null)
			service.sendMessage(message);
		
		Member member = (Member)session.getAttribute("member");
		return new ModelAndView("redirect:getMessageList.do");
	}
}
