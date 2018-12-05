package com.spring.plan.model.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.plan.model.dao.ChallengeDao;
import com.spring.plan.model.service.ChallengeService;
import com.spring.plan.model.vo.Challenge;
import com.spring.plan.model.vo.ChallengeComment;
import com.spring.plan.model.vo.ChallengeLog;

@Service
public class ChallengeServiceImpl implements ChallengeService {

   @Resource
   ChallengeDao challengeDao;
   
   @Override
   public List<Challenge> getAllChallengeList() throws Exception {
      return challengeDao.getAllChallengeList();
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
   public int checkChallenge(int challengeNo, String challengeContent) throws Exception {
      if(challengeDao.checkChallenge(challengeNo, challengeContent)==0)
         System.out.println("★ checkChallenge 실패");
      return challengeDao.checkChallenge(challengeNo, challengeContent);
   }

   @Override
   public int addChallenge(Challenge challenge) throws Exception {
      if(challengeDao.addChallenge(challenge)==0) {
         System.out.println("★ addChallenge  실패");
         return 0;
      }
      System.out.println(challenge);
      return 1;
   }

   @Override
   public int deleteChallenge(int challengeNo) throws Exception {
      if(challengeDao.deleteChallenge(challengeNo)==0)
         System.out.println("★ deleteChallenge  실패");
      
      return challengeDao.deleteChallenge(challengeNo);
   }

   @Override
   public int addChallengeContent(int challengeNo, List<String> challengeContent) throws Exception {
      if(challengeDao.addChallengeContent(challengeNo, challengeContent)==0)
         System.out.println("★ addChallengeContent  실패");
      
      return challengeDao.addChallengeContent(challengeNo, challengeContent);
   }

   @Override
   public int deleteChallengeContent(String challengeContent) throws Exception {
      if(challengeDao.deleteChallengeContent(challengeContent)==0)
         System.out.println("★ deleteChallengeContent  실패");
      
      return challengeDao.deleteChallengeContent(challengeContent);
   }

   @Override
   public int updateChallengeLog(ChallengeLog challengeLog) throws Exception {
      if(challengeDao.updateChallengeLog(challengeLog)==0)
         System.out.println("★ updateChallengeLog  실패");
      
      return challengeDao.updateChallengeLog(challengeLog);
   }

   @Override
   public int writeChallengeComment(ChallengeComment challengeComment) throws Exception {
      if(challengeDao.writeChallengeComment(challengeComment)==0)
         System.out.println("★ writeChallengeComment  실패");
      
      return challengeDao.writeChallengeComment(challengeComment);
   }

   @Override
   public int deleteChallengeComment(ChallengeComment challengeComment) throws Exception {
      if(challengeDao.deleteChallengeComment(challengeComment)==0)
         System.out.println("★ deleteChallengeComment  실패");
      
      return challengeDao.deleteChallengeComment(challengeComment);
   }

}