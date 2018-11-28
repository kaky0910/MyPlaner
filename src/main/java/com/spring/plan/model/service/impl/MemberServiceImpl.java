package com.spring.plan.model.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.MemberDao;
import com.spring.plan.model.service.MemberService;
import com.spring.plan.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Resource
	MemberDao memberDao;
	
	@Override
	public Member login(Member mvo) throws Exception {
		return null;
	}

	@Override
	public void logout(Member mvo) throws Exception {
	}

	@Override
	public int regist(Member mvo) throws Exception {
		return 0;
	}

	@Override
	public int idCheck(String id) throws Exception {
		return 0;
	}

	@Override
	public int blockMember(String nickname, String blockNickname) throws Exception {
		return 0;
	}

	@Override
	public boolean checkKakao(Member member) throws Exception {
		if(memberDao.checkKakao(member)==0) return false;
		else return true;
	}

}
