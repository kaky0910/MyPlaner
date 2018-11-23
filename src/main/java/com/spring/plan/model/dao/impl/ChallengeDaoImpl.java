package com.spring.plan.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.ChallengeDao;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeLog;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	@Override
	public List<Challenge> getAllChallengeList() throws Exception {
		return null;
	}

	@Override
	public Challenge getChallengeByNo(int challengeNo) throws Exception {
		return null;
	}

	@Override
	public Challenge getChallengeByNickname(String nickname) throws Exception {
		return null;
	}

	@Override
	public Challenge getChallengeByCategory(String category) throws Exception {
		return null;
	}

	@Override
	public Challenge getChallengeByMonth(String month, String nickname) throws Exception {
		return null;
	}

	@Override
	public Challenge getChallengeByDay(String day, String nickname) throws Exception {
		return null;
	}

	@Override
	public int checkChallenge(int challengeNo) throws Exception {
		return 0;
	}

	@Override
	public int addChallenge(Challenge challenge) throws Exception {
		return 0;
	}

	@Override
	public int deleteChallenge(int challengeNo) throws Exception {
		return 0;
	}

	@Override
	public int addChallengeContent(String challengeContent) throws Exception {
		return 0;
	}

	@Override
	public int deleteChallengeContent(String challengeContent) throws Exception {
		return 0;
	}

	@Override
	public int updateChallengeLog(ChallengeLog challengeLog) throws Exception {
		return 0;
	}

	@Override
	public int writeChallengeComment(ChallengeComment challengeComment) throws Exception {
		return 0;
	}

	@Override
	public int deleteChallengeComment(ChallengeComment challengeComment) throws Exception {
		return 0;
	}

}
