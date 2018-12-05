package com.spring.plan.model.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.MemberDao;
import com.spring.plan.model.service.MemberService;
import com.spring.plan.model.vo.BlockMember;
import com.spring.plan.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {

	@Resource
	MemberDao memberDao;
	
	@Override
	public Member login(Member mvo) throws Exception {
		return memberDao.login(mvo);
	}

	@Override
	public int regist(Member mvo) throws Exception {
		return memberDao.regist(mvo);
	}

	@Override
	public int idCheck(String id) throws Exception {
		return memberDao.idCheck(id);
	}

	@Override
	public int blockMember(int memberNo, int blockMemberNo) throws Exception {
		BlockMember blockMember = new BlockMember();
		blockMember.setMemberNo(memberNo);
		blockMember.setBlockMemberNo(blockMemberNo);
		return memberDao.blockMember(blockMember);
		
	}

	@Override
	public boolean checkKakao(Member member) throws Exception {
		if(memberDao.checkKakao(member)==0) return false;
		else return true;
	}

	@Override
	public int registKakao(Member mvo) throws Exception {
		return memberDao.registKakao(mvo);
	}

	@Override
	public Member kakaoLogin(Member mvo) throws Exception {
		return memberDao.kakaoLogin(mvo);
	}

}
