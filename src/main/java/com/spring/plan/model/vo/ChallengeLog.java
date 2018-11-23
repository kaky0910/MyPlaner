package com.spring.plan.model.vo;

public class ChallengeLog {
	private int challengeNo;
	private String content;
	private int dayCount;
	
	public ChallengeLog() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getDayCount() {
		return dayCount;
	}
	public void setDayCount(int dayCount) {
		this.dayCount = dayCount;
	}
	
	
	
}
