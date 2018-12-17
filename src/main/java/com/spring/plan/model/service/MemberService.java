package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Member;

public interface MemberService {
	
	// log in
	Member login(Member mvo) throws Exception;
	
	// 카카오 회원 등록 체크하고
	int registKakao(Member mvo) throws Exception;
	
	// 회원 가입
	int regist(Member mvo) throws Exception;
	
	// id 중복체크
	boolean idCheck(String id) throws Exception;
	
/*	// nickname 중복체크
	int nicknameCheck(String nickname) throws Exception;
*/	
	// 쪽지 차단
	public int blockMember(int memberNo, int blockMemberNo) throws Exception;
	
	// kakao 계정 등록되어있는지 확인
	boolean checkKakao(Member member) throws Exception;
	
	// kakao login
	Member kakaoLogin(Member mvo) throws Exception;
	
	// 차단 list return 
	List<Integer> getBlockList(int memberNo) throws Exception;


}