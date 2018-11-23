package com.spring.plan.model.service.impl;

import org.springframework.stereotype.Service;

import com.spring.plan.model.service.MemberService;
import com.spring.plan.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

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
	public int nicknameCheck(String nickname) throws Exception {
		return 0;
	}

	@Override
	public int blockMember(String nickname, String blockNickname) throws Exception {
		return 0;
	}

}
