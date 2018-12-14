package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.ChallengeLog;

public interface ChallengeService {

	//challenge 검색
	List<Challenge> searchChallengeList(Challenge challenge) throws Exception;
	
	// challenge 전체 목록
	List<Challenge> getAllChallengeList() throws Exception;

	// challenge 정보 return (challenge detail 페이지에서)
	Challenge getChallengeByNo(int challengeNo) throws Exception;

	// 해당 아이디, 월의 challenge return (index page. paging)
	List<Challenge> getChallengeByMonth(String month,  int memberNo) throws Exception;

	// 해당 아이디, 날짜의 challenge return (index page. )
	List<Challenge> getChallengeByDay(String day,  int memberNo) throws Exception;

	// challenge를 추가 (index page)
	int addChallenge(Challenge challenge) throws Exception;

	// challenge 삭제
	int deleteChallenge(int challengeNo) throws Exception;

	// challenge에 항목 추가
	int addChallengeContent(Challenge challenge, List<ChallengeContent> challengeContent) throws Exception;

	// challenge에 항목 삭제
	int deleteChallengeContent(String challengeContent) throws Exception;

	// challenge 일지 업데이트 :: 작성이기도 함
	int updateChallengeLog(ChallengeLog challengeLog) throws Exception;

	// challenge에 댓글 달기
	int writeChallengeComment(ChallengeComment challengeComment) throws Exception;

	// challenge 댓글 삭제
	int deleteChallengeComment(ChallengeComment challengeComment) throws Exception;
	
	// check ChallengeContent
	int checkChallengeContent(ChallengeContent challengeContent,String day) throws Exception;
	
	//return challengeContentCheck
	String getChallengeContentCheck(ChallengeContent challengeContent) throws Exception;
}
