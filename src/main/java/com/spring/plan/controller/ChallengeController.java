package com.spring.plan.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.service.ChallengeService;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.Member;

@Controller
public class ChallengeController {

	@Resource
	ChallengeService service;

	@RequestMapping("/addChallenge.do")
	public ModelAndView addChallenge(HttpSession session, Challenge challenge) throws Exception{

		JSONObject jsonObject = new JSONObject();

		challenge.setMemberNo(((Member) session.getAttribute("member")).getMemberNo());

		service.addChallenge(challenge);
		
		jsonObject.put("challenge", challenge);
		return new ModelAndView("JsonView", "json", jsonObject);
	}
	
	@RequestMapping("/searchChallenge.do")
	public ModelAndView searchChallenge(HttpServletRequest request, Challenge challenge) throws Exception{
		List<Challenge> challList = new ArrayList<Challenge>();
		System.out.println("controller ::::::::::: "+challenge);
		
		challList = service.searchChallengeList(challenge);
		System.out.println("contoller " + challList);
		return new ModelAndView("challenge/searchResultChallengeData","challList",challList);
	}
	
	@RequestMapping("/detailChallenge.do")
	public ModelAndView detailChallenge(HttpServletRequest request, Challenge challenge) throws Exception{
		System.out.println("★ 디테일챌린지 테스트 : "+challenge);
		
		Challenge rchallenge = service.getChallengeByNo(challenge.getChallengeNo());
		
		return new ModelAndView("challenge/detailchallenge","challenge",rchallenge);
	}
}
