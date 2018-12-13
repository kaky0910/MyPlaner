package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.ChallengeDao;
import com.spring.plan.model.service.ChallengeService;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.ChallengeLog;

@Service
public class ChallengeServiceImpl implements ChallengeService {

	@Resource
	private ChallengeDao challengeDao;

	@Override
	public List<Challenge> getAllChallengeList() throws Exception {
		return challengeDao.getAllChallengeList();
	}

	@Override
	public List<Challenge> searchChallengeList(Challenge challenge) throws Exception {
		return challengeDao.searchChallengeList(challenge);
	}

	@Override
	public Challenge getChallengeByNo(int challengeNo) throws Exception {
		return challengeDao.getChallengeByNo(challengeNo);
	}

	@Override
	public List<Challenge> getChallengeByMonth(String month, int memberNo) throws Exception {
		return challengeDao.getChallengeByMonth(month, memberNo);
	}

	@Override
	public List<Challenge> getChallengeByDay(String day, int memberNo) throws Exception {
		return challengeDao.getChallengeByDay(day, memberNo);
	}

	@Override
	public int addChallenge(Challenge challenge) throws Exception {
		if (challengeDao.addChallenge(challenge) == 0) {
			System.out.println("★ addChallenge  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteChallenge(int challengeNo) throws Exception {
		if (challengeDao.deleteChallenge(challengeNo) == 0) {
			System.out.println("★ deleteChallenge  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int addChallengeContent(int challengeNo, List<String> challengeContent) throws Exception {
		
		if (challengeDao.addChallengeContent(challengeNo, challengeContent) == 0) {
			System.out.println("★ addChallengeContent  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteChallengeContent(String challengeContent) throws Exception {
		if (challengeDao.deleteChallengeContent(challengeContent) == 0) {
			System.out.println("★ deleteChallengeContent  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int updateChallengeLog(ChallengeLog challengeLog) throws Exception {
		if (challengeDao.updateChallengeLog(challengeLog) == 0) {
			System.out.println("★ updateChallengeLog  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int writeChallengeComment(ChallengeComment challengeComment) throws Exception {
		if (challengeDao.writeChallengeComment(challengeComment) == 0) {
			System.out.println("★ writeChallengeComment  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int deleteChallengeComment(ChallengeComment challengeComment) throws Exception {
		if (challengeDao.deleteChallengeComment(challengeComment) == 0) {
			System.out.println("★ deleteChallengeComment  실패");
			return 0;
		}
		return 1;
	}

	@Override
	public int checkChallengeContent(ChallengeContent challengeContent,String day) throws Exception {

		Challenge challenge = new Challenge();
		challenge.setChallengeEndDate(day);
		challenge.setChallengeStartDate(challengeDao.getChallengeByNo(challengeContent.getChallengeNo()).getChallengeStartDate());
		int dayCount = challengeDao.getChallengeLength(challenge);
		
		char[] arr = challengeContent.getChallengeContentCheck().toCharArray();
		if(arr[dayCount-1]=='0') arr[dayCount-1]='1';
		else arr[dayCount-1] = '0';
		challengeContent.setChallengeContentCheck(new String(arr)); 		//check setting
		
		return challengeDao.checkChallengeContent(challengeContent);
	}

}
