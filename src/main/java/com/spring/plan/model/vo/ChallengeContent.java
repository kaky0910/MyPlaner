package com.spring.plan.model.vo;

import com.spring.plan.model.SubLogics;

public class ChallengeContent {
	private int challengeNo;
	private String challengeContent;
	private String challengeContentCheck;
	private String challengeStartDate;
	
	public ChallengeContent() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	public ChallengeContent(int challengeNo, String challengeContent) {
		super();
		this.challengeNo = challengeNo;
		this.challengeContent = challengeContent;
	}//희정 /addChallengeContent

	public ChallengeContent(int challengeNo, String challengeContent, String challengeContentCheck) {
		super();
		this.challengeNo = challengeNo;
		this.challengeContent = challengeContent;
		this.challengeContentCheck = challengeContentCheck;
	}//addChallengeContent

	public int getChallengeNo() {
		return challengeNo;
	}
	
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public String getChallengeContent() {
		return challengeContent;
	}
	public void setChallengeContent(String challengeContent) {
		this.challengeContent = challengeContent;
	}
	public String getChallengeContentCheck() {
		
		return challengeContentCheck;
	}
	public void setChallengeContentCheck(String challengeContentCheck) {
		this.challengeContentCheck = challengeContentCheck;
	}
	
	public String getChallengeStartDate() {
		return challengeStartDate;
	}

	public void setChallengeStartDate(String challengeStartDate) {
		this.challengeStartDate = challengeStartDate;
	}

	public boolean isCheck() {
		String day = Daily.getDayByDate();
		int count = SubLogics.getDuration(challengeStartDate, day);
		if(challengeContentCheck!=null) {
			System.out.println("Challenge :::::::::: "+toString());
			char[] arr = challengeContentCheck.toCharArray();
			if(arr[count-1]=='0') return false;
			else return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return "ChallengeContent [challengeNo=" + challengeNo + ", challengeContent=" + challengeContent
				+ ", challengeContentCheck=" + challengeContentCheck + "]";
	}
}
