package com.spring.plan.model.vo;

import java.util.List;

public class Daily {
	private String nickname;
	private String day; // YYYY.MM.DD
	private String memo;
	private String emotion;
	
	private List<Challenge> challengeList;
	private List<Schedule> scheduleList;
	
	public Daily() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	@Override
	public String toString() {
		return "Daily [nickname=" + nickname + ", day=" + day + ", memo=" + memo + ", emotion=" + emotion
				+ ", challengeList=" + challengeList + ", scheduleList=" + scheduleList + "]";
	}
	
	
	
}
