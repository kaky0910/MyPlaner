package com.spring.plan.model.vo;

import java.util.List;

public class Daily {				// 한 회원의 index page 정보들을 가지고 있음.
	private int memberNo;
	private String day; // YYYY.MM.DD
	private String memo;
	private String emotion;
	private String month;
	
	private List<Challenge> challengeList;
	private List<Schedule> scheduleList;
	private List<Habit> habitList;
	
	public Daily() {}
	
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

	@Override
	public String toString() {
		return "Daily [memberNo=" + memberNo + ", day=" + day + ", memo=" + memo + ", emotion=" + emotion + ", month="
				+ month + ", challengeList=" + challengeList + ", scheduleList=" + scheduleList + ", habitList="
				+ habitList + "]";
	}

	
}
