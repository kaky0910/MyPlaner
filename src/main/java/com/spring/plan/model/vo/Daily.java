package com.spring.plan.model.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Daily {            // 한 회원의 index page 정보들을 가지고 있음.
   private int memberNo;
   private String day; // YYYYMMDD
   private String memo;
   private String emotion;
   private String month;
   
   private List<Challenge> challengeList;
   private List<Schedule> scheduleList;
   private List<Habit> habitList;
   
   public Daily() {
	   challengeList = new ArrayList<Challenge>();
	   scheduleList = new ArrayList<Schedule>();
	   habitList = new ArrayList<Habit>();
   }
   
   public Daily(int memberNo, String month, String day) {
	   this();
      this.memberNo = memberNo;
      this.month = month;
      this.day = day;
   }

   //////여기에 생성자 추가(어따쓰는지도  *주*석*)
   public int getMemberNo() {
      return memberNo;
   }

   public void setMemberNo(int memberNo) {
      this.memberNo = memberNo;
   }

   public String getMonth() {
      return month;
   }

   public void setMonth(String month) {
      this.month = month;
   }

   public String getDay() {
      return day;
   }
   
   public void setDay(String day) {
      this.day = day;
      this.month = day.substring(0, 6);
   }
   public String getMemo() {
      return memo;
   }
   public void setMemo(String memo) {
      this.memo = memo;
   }
   public String getEmotion() {
      return emotion;
   }
   public void setEmotion(String emotion) {
      this.emotion = emotion;
   }
   public List<Challenge> getChallengeList() {
      return challengeList;
   }
   public void setChallengeList(List<Challenge> challengeList) {
      this.challengeList = challengeList;
   }
   public List<Schedule> getScheduleList() {
      return scheduleList;
   }
   public void setScheduleList(List<Schedule> scheduleList) {
      this.scheduleList = scheduleList;
   }

   public List<Habit> getHabitList() {
      return habitList;
   }

   public void setHabitList(List<Habit> habitList) {
      this.habitList = habitList;
   }
   
   public List<List<Integer>> getScheduleFormattedArray() {
      List<Schedule> list = getScheduleList();
      List<List<Integer>> result = new ArrayList<List<Integer>>();
      for(Schedule s : list) {
         List<Integer> temp = new ArrayList<Integer>();
         temp.add(Integer.parseInt(s.getScheduleStartDate().substring(6)));
         temp.add(Integer.parseInt(s.getScheduleEndDate().substring(6)));
         System.out.println(s.getScheduleStartDate()+ ":::::::::::::::::" +s.getScheduleEndDate());
         System.out.println("추가~~~~~~~~~~~("+temp.get(0)+","+temp.get(1)+")");
         result.add(temp);
      }
      
      return result;
   }
   
   public List<Schedule> getTodaySchedule() {
      ArrayList<Schedule> list = new ArrayList<Schedule>();
      for(Schedule s : scheduleList) {
         if(Integer.parseInt(s.getScheduleStartDate())<=Integer.parseInt(day) && 
               Integer.parseInt(s.getScheduleEndDate())>=Integer.parseInt(day))
            list.add(s);
      }
      return list;
   }
   
   public List<Challenge> getTodayChallenge(){
      ArrayList<Challenge> list = new ArrayList<Challenge>();
      for(Challenge c : challengeList) {
         if(Integer.parseInt(c.getChallengeStartDate())<=Integer.parseInt(day) && 
               Integer.parseInt(c.getChallengeEndDate())>=Integer.parseInt(day))
            list.add(c);
      }
      return list;
   }
   
   public List<CheckHabit> getCheckHabit(){
      ArrayList<CheckHabit> list = new ArrayList<CheckHabit>();
      for(Habit h : habitList) {
         for(CheckHabit ch : h.getCheckHabitList()) {
            if(ch.getMonth().equals(month))
               list.add(ch);
         }
      }
      return list;
   }
   
   public int getLastDate(String month) {
      if(month.equals("02")) return 28;
      else if(month.equals("04")||month.equals("06")||month.equals("09")||month.equals("11"))
         return 30;
      else return 31;
   }

   @Override
   public String toString() {
      return "Daily [memberNo=" + memberNo + ", day=" + day + ", memo=" + memo + ", emotion=" + emotion + ", month="
            + month + ", challengeList=" + challengeList + ", scheduleList=" + scheduleList + ", habitList="
            + habitList + "]";
   }
   
   public static String getDayByDate() {
      Date date = new Date();
      String year = (date.getYear()+1900)+"";
      String month = (date.getMonth()+1)+"";
      if(date.getMonth()+1<10) month = "0"+(date.getMonth()+1);
      String day = date.getDate()+"";
      if(date.getDate()<10) day = "0"+date.getDate();
      
      return year+month+day;
   }

   
}