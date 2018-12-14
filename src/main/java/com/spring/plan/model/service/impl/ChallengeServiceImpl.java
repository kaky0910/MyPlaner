package com.spring.plan.model.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.SubLogics;
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
		return challengeDao.addChallenge(challenge);
	}

	@Override
	public int deleteChallenge(int challengeNo) throws Exception {
		return challengeDao.deleteChallenge(challengeNo);
	}

	@Override
	public int addChallengeContent(Challenge challenge, List<ChallengeContent> challengeContent) throws Exception {
		List<ChallengeContent> list;
		if(challengeContent.size()==0 || challengeContent==null) {
			list = new ArrayList<ChallengeContent>();
			
			ChallengeContent cc = new ChallengeContent();
			
			cc.setChallengeNo(challenge.getChallengeNo());
			cc.setChallengeContent(challenge.getChallengeTitle());
			
			cc.setChallengeContentCheck(SubLogics.getCheckString(challenge.getChallengeStartDate(), challenge.getChallengeEndDate()));
			list.add(cc);
		}
		else {
			for(ChallengeContent cc : challengeContent) cc.setChallengeContentCheck(SubLogics.getCheckString(challenge.getChallengeStartDate(), challenge.getChallengeEndDate()));
			list = challengeContent;
		}
		return challengeDao.addChallengeContent(list);
	}

	@Override
	public int deleteChallengeContent(String challengeContent) throws Exception {
		return challengeDao.deleteChallengeContent(challengeContent);
	}

	@Override
	public int updateChallengeLog(ChallengeLog challengeLog) throws Exception {
		return challengeDao.updateChallengeLog(challengeLog);
	}

	@Override
	public int writeChallengeComment(ChallengeComment challengeComment) throws Exception {
		return challengeDao.writeChallengeComment(challengeComment);
	}

	@Override
	public int deleteChallengeComment(ChallengeComment challengeComment) throws Exception {
		return challengeDao.deleteChallengeComment(challengeComment);
	}

	@Override
	public int checkChallengeContent(ChallengeContent challengeContent,String day) throws Exception {

		Challenge challenge = challengeDao.getChallengeByNo(challengeContent.getChallengeNo());
		int dayCount = SubLogics.getDuration(challenge.getChallengeStartDate(), day)-1;
		
		String ccc = challengeDao.getChallengeContentCheck(challengeContent);
		System.out.println("challengeContent :::::: "+challengeContent);
		char[] arr = challengeContent.getChallengeContentCheck().toCharArray();
		if(arr[dayCount]=='0') arr[dayCount]='1';
		else arr[dayCount] = '0';
		challengeContent.setChallengeContentCheck(new String(arr)); 		//check setting
		System.out.println("challenge check result : : :  "+challengeDao.checkChallengeContent(challengeContent));
		return 1;
	}

	@Override
	public String getChallengeContentCheck(ChallengeContent challengeContent) throws Exception {
		return challengeDao.getChallengeContentCheck(challengeContent);
	}

}
