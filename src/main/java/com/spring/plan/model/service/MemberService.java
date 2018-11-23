package com.spring.plan.model.service;

import com.spring.plan.model.vo.Member;

public interface MemberService {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// log out
	void logout(Member mvo) throws Exception;
	
	// 회원 가입
	int regist(Member mvo) throws Exception;
	
	// id 중복체크
	int idCheck(String id) throws Exception;
	
	// nickname 중복체크
	int nicknameCheck(String nickname) throws Exception;
	
	// 쪽지 차단
	int blockMember(String nickname, String blockNickname) throws Exception;
}
