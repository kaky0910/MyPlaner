package com.spring.plan.model.dao.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.spring.plan.model.dao.HabitDao;
import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

@Repository
public class HabitDaoImpl implements HabitDao{

   @Resource
   SqlSession sqlSession;
   
   @Override
   public int addHabit(Habit habit) throws Exception {
      return sqlSession.insert("habit-mapper.addHabit",habit);
   }

   @Override
   public int deleteHabit(Habit habit) throws Exception {
      return sqlSession.delete("habit-mapper.deleteHabit",habit);
   }

   @Override
   public int checkHabit(CheckHabit checkHabit) throws Exception {         //service로 옮길까
      return sqlSession.update("habit-mapper.checkHabit",checkHabit);
   }

   @Override
   public String getCheckHabitByMonth(CheckHabit checkHabit) throws Exception {
      return sqlSession.selectOne("habit-mapper.getCheckHabit",checkHabit);
   }

   @Override
   public List<Habit> getHabitList(int memberNo) throws Exception {
      return sqlSession.selectList("habit-mapper.getHabit",memberNo);
   }

}