package com.spring.plan.model.dao;

import com.spring.plan.model.vo.BlockMember;
import com.spring.plan.model.vo.Member;

public interface MemberDao {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// kakao login
	Member kakaoLogin(Member mvo) throws Exception;
	
	// 회원 가입
	int regist(Member mvo) throws Exception;
	
	// 카카오 회원 등록 체크하고
	int registKakao(Member mvo) throws Exception;
	
	// id 중복체크
	int idCheck(String id) throws Exception;
	
/*	// nickname 중복체크
	int nicknameCheck(String nickname) throws Exception;
	*/
	// 쪽지 차단
	int blockMember(BlockMember blockMember) throws Exception;
	
	// 카카오 회원 체크
	int checkKakao(Member member) throws Exception;
}
