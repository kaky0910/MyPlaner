package com.spring.plan.controller;

import java.util.List;

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
   private ChallengeService challengeService;
   
   @RequestMapping("/addChallenge.do")
   public ModelAndView addChallenge(HttpSession session,Challenge challenge,String month) throws Exception{
      
      JSONObject jsonObject = new JSONObject();
      int memberNo = ((Member)session.getAttribute("member")).getMemberNo();
      challenge.setMemberNo(memberNo);
      
      try {
    	  challengeService.addChallenge(challenge);
      }catch(Exception e) {
    	  e.printStackTrace();
      }
      List<Challenge> challengeList = challengeService.getChallengeByMonth(month, memberNo);
      jsonObject.put("challenge", challengeList);
      return new ModelAndView("JsonView","json",jsonObject);
   }
   
}

