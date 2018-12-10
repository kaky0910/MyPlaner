package com.spring.plan.model.service;

import java.util.List;

import com.spring.plan.model.vo.CheckHabit;
import com.spring.plan.model.vo.Habit;

public interface HabitService {
   // habit 추가 :: index.jsp 에서
   int addHabit(Habit habit) throws Exception;

   // habit 삭제
   int deleteHabit(Habit habit) throws Exception;

   // 체크 and 체크 해제 (tracker에서)
   int checkHabit(Habit habit, String day) throws Exception;

   // 해당 월의 habit 체크한 기록 return
   CheckHabit getCheckHabitByMonth(CheckHabit checkHabit) throws Exception; // getHabitCheckByWeek는 이 method로
   
   // 멤버의 habit 가져옴
   List<Habit> getHabitList(int memberNo) throws Exception;

}
