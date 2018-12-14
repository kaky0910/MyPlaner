package com.spring.plan.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.ChallengeDao;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeContent;
import com.spring.plan.model.vo.ChallengeLog;
import com.spring.plan.model.vo.Daily;

@Repository
public class ChallengeDaoImpl implements ChallengeDao {

	@Resource
	SqlSession sqlSession;
	
	@Override
	public List<Challenge> getAllChallengeList() throws Exception {
		return sqlSession.selectList("challenge-mapper.getAllChallengeList");
	}

	@Override
	public Challenge getChallengeByNo(int challengeNo) throws Exception {
		return sqlSession.selectOne("challenge-mapper.getChallengeByNo", challengeNo);
	}

	@Override
	public List<Challenge> getChallengeByMonth(String month, int memberNo) throws Exception {
		Daily challengeByMonth = new Daily(memberNo, month, "");
		return sqlSession.selectList("challenge-mapper.getChallengeByMonth",challengeByMonth);
	}

	@Override
	public List<Challenge> getChallengeByDay(String day, int memberNo) throws Exception {
		System.out.println("¡Ú ChallengeDaoImpl__ getChallengeByDay ::::::: " + day);
		Daily challengeByDay = new Daily(0, "", day);
		return sqlSession.selectList("challenge-mapper.getChallengeByDay",challengeByDay);
	}

	@Override
	public int addChallenge(Challenge challenge) throws Exception {
		return sqlSession.insert("challenge-mapper.addChallenge", challenge);
	}

	@Override
	public int deleteChallenge(int challengeNo) throws Exception {
		return sqlSession.delete("challenge-mapper.deleteChallenge", challengeNo);
	}

	@Override
	public int addChallengeContent(List<ChallengeContent> challengeContentList) throws Exception {
		return sqlSession.insert("challenge-mapper.addChallengeContent", challengeContentList);
	}

	@Override
	public int deleteChallengeContent(String challengeContent) throws Exception {
		return sqlSession.delete("challenge-mapper.deleteChallengeContent", challengeContent);
	}

	@Override
	public int updateChallengeLog(ChallengeLog challengeLog) throws Exception {
		return sqlSession.insert("challenge-mapper.updateChallengeLog", challengeLog);
	}

	@Override
	public int writeChallengeComment(ChallengeComment challengeComment) throws Exception {
		return sqlSession.insert("challenge-mapper.writeChallengeComment", challengeComment);
	}

	@Override
	public int deleteChallengeComment(ChallengeComment challengeComment) throws Exception {
		return sqlSession.delete("challenge-mapper.deleteChallengeComment", challengeComment);
	}

	@Override
	public int checkChallengeContent(ChallengeContent challengeContent) throws Exception {
		return sqlSession.update("challenge-mapper.checkChallenge",challengeContent);
	}
		
	public List<Challenge> searchChallengeList(Challenge challenge) throws Exception {
		return sqlSession.selectList("challenge-mapper.searchChallengeList", challenge);
	}

	@Override
	public String getChallengeContentCheck(ChallengeContent challengeContent) throws Exception {
		return sqlSession.selectOne("challenge-mapper.getChallengeContentCheck",challengeContent);
	}

}
