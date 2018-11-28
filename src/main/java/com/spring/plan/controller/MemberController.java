package com.spring.plan.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.vo.Member;

@Controller
public class MemberController {
	
	@RequestMapping("kakaoLogin.do")
	public ModelAndView kakaoLogin(Member member) throws Exception{
		System.out.println(member);
		return new ModelAndView("index");
	}
	
	@RequestMapping("checkKakao.do")
	public ModelAndView checkKakao(String id) throws Exception{
		
		return new ModelAndView();
	}
}
