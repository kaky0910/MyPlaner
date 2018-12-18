package com.spring.plan.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.spring.plan.model.dao.DailyDao;
import com.spring.plan.model.vo.Member;

@Controller
public class MemoController {
	
	@Resource
	private DailyDao dailyDao;
	
	@RequestMapping("updateMemo.do")
	public ModelAndView updateMemo(String memo,HttpSession session) throws Exception{
		Member member = (Member)session.getAttribute("member");
		System.out.println("memo :: "+memo);
		member.setMemo(memo);
		boolean flag = false;
		int result = dailyDao.updateMemo(member);
		System.out.println("result ::: "+result);
		if(result==1) flag = true;
		else flag = false;
		
		return new ModelAndView("JsonView","flag",flag);
	}

}
