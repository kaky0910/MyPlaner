package com.spring.plan.controller;

import javax.annotation.Resource;
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
	public ModelAndView addChallenge(HttpSession session, Challenge challenge) {

		JSONObject jsonObject = new JSONObject();

		challenge.setMemberNo(((Member) session.getAttribute("member")).getMemberNo());

		try {
			service.addChallenge(challenge);
		} catch (Exception e) {
			e.printStackTrace();
		}
		jsonObject.put("challenge", challenge);
		return new ModelAndView("JsonView", "json", jsonObject);
	}
}
