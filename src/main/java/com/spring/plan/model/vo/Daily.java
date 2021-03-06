package com.spring.plan.model.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Daily {				// 한 회원의 index page 정보들을 가지고 있음.
	private int memberNo;
	private String day; // YYYYMMDD
	private String memo;
	private String emotion;
	private String month;
	
	private List<Challenge> challengeList;
	private List<Schedule> scheduleList;
	private List<Habit> habitList;
	
	public Daily() {}
	
	public Daily(int memberNo, String month, String day) {
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

	public String getDay() {
		return day;
	}
	
	public void setMonth(String month) {
		this.month = month;
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
	public String getYear() {
		return month.substring(0,4);
	}
	
	public List<List<Integer>> getScheduleFormattedArray() {
		List<Schedule> list = getScheduleList();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for(Schedule s : list) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(Integer.parseInt(roundDay(s.getScheduleStartDate(),month).substring(6)));
			temp.add(Integer.parseInt(roundDay(s.getScheduleEndDate(),month).substring(6)));
			System.out.println(s.getScheduleStartDate()+ ":::::::::::::::::" +s.getScheduleEndDate());
			System.out.println("추가~~~~~~~~~~~("+temp.get(0)+","+temp.get(1)+")");
			result.add(temp);
		}
		
		return result;
	}
	
	public String roundDay(String day, String month) {
		int d = Integer.parseInt(day);
		int m = Integer.parseInt(month);
		if(Integer.parseInt(day.substring(0, 6))>m) {
			return month+""+getLastDate(month);
		}else if(Integer.parseInt(day.substring(0, 6))<m) {
			return month+"01";
		}
		
		return d+"";
	}
	
	public List<Schedule> getTodaySchedule() {
		ArrayList<Schedule> list = new ArrayList<Schedule>();
		if(scheduleList!=null) {	
			for(Schedule s : scheduleList) {
				System.out.println(s);
				if(Integer.parseInt(s.getScheduleStartDate())<=Integer.parseInt(day) && 
						Integer.parseInt(s.getScheduleEndDate())>=Integer.parseInt(day))
					list.add(s);
			}
		}
		return list;
	}
	
	public List<Challenge> getTodayChallenge(){
		ArrayList<Challenge> list = new ArrayList<Challenge>();
		if(challengeList!=null) {
			for(Challenge c : challengeList) {
				if(Integer.parseInt(c.getChallengeStartDate())<=Integer.parseInt(day) && 
						Integer.parseInt(c.getChallengeEndDate())>=Integer.parseInt(day))
					list.add(c);
			}
		}
		System.out.println("getTodayChallenge ::: "+list);
		return list;
	}
	
	public List<CheckHabit> getCheckHabit(){
		ArrayList<CheckHabit> list = new ArrayList<CheckHabit>();
		if(habitList!=null) {
			for(Habit h : habitList) {
				for(CheckHabit ch : h.getCheckHabitList()) {
					if(ch.getMonth().equals(month))
						list.add(ch);
				}
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
	
	public int getLastDate() {
		return getLastDate(month.substring(4));
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
	
	public List<CheckHabit> getCheckHabitByMonth(){
		List<CheckHabit> result = new ArrayList<CheckHabit>();
		Date date = new Date();
		String year = (date.getYear()+1900)+"";
		String month = year+(date.getMonth()+1);
		if(habitList!=null && habitList.size()!=0) {
			for(Habit h : habitList) {
				if(h.getHabitEndDate()==null) {
					for(CheckHabit ch : h.getCheckHabitList()) {
						if(ch.getMonth().equals(month)) result.add(ch);
					}
				}
			}
		}
		
		return result;
	}
	
	public List<MonthlyCheckHabit> getMonthlyCheckHabit(){ // tracker용
		List<CheckHabit> list = getCheckHabitByMonth();
		List<MonthlyCheckHabit> result = new ArrayList<MonthlyCheckHabit>();
		char[] arr = new char[getLastDate()];
		for(CheckHabit ch : list) {
			MonthlyCheckHabit mch = new MonthlyCheckHabit();
			mch.setMonth(month);
			arr = ch.getCheckHabit().substring(6, getLastDate()+6).toCharArray();
			mch.setCheckHabit(arr);
			mch.setHabit(ch.getHabit());
			result.add(mch);
		}
		return result;
	}
	
	public List<WeeklyCheckHabit> getWeeklyCheckHabit(){
		List<WeeklyCheckHabit> result = new ArrayList<WeeklyCheckHabit>();
		Date d = new Date();
		int day = d.getDay();
		int date = d.getDate();
		int num = date-day+5;
		for(CheckHabit ch : getCheckHabitByMonth()) {
			if(isExist(result, ch)) continue;
			char[] temp = new char[7];
			char[] arr = ch.getCheckHabit().toCharArray();
			WeeklyCheckHabit wch = new WeeklyCheckHabit();
			for(int i=0; i<7;i++) {
				temp[i] = arr[num+i];
			}
			wch.setHabitCheck(Arrays.toString(temp));
			wch.setHabit(ch.getHabit());
			
			result.add(wch);
		}
		return result;
	}
	
	public boolean isExist(List<WeeklyCheckHabit> list,CheckHabit ch) {
		boolean flag = false;
		for(WeeklyCheckHabit w : list) {
			if(w.getHabit().equals(ch.getHabit()))
				flag = true;
		}
		return flag;
	}

	
}
