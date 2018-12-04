package com.spring.plan.model.vo;

import java.util.ArrayList;
import java.util.List;

public class Challenge {
	private int challengeNo;
	private String challengeTitle;
	private String challengeStartDate;
	private String challengeEndDate;
	private int memberNo;
	private String challengeCategory;
	private int challengeLikes;
	private boolean challengeSharing;
	private List<ChallengeLog> challengeLogList;
	private List<ChallengeComment> challengeCommentList;
	private List<ChallengeContent> challengeContentList;
	
	public Challenge() {
		challengeLogList = new ArrayList<ChallengeLog>();
		challengeCommentList = new ArrayList<ChallengeComment>();
		challengeContentList = new ArrayList<ChallengeContent>();
	}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	public Challenge(int challengeNo, String challengeTitle, String challengeStartDate, String challengeEndDate,
			int memberNo, String challengeCategory, boolean challengeSharing) {
		this();
		this.challengeNo = challengeNo;
		this.challengeTitle = challengeTitle;
		this.challengeStartDate = challengeStartDate;
		this.challengeEndDate = challengeEndDate;
		this.memberNo = memberNo;
		this.challengeCategory = challengeCategory;
		this.challengeSharing = challengeSharing;

	}//희정... addChallenge... 코멘트랑 일지, like 빠짐..

	
	public Challenge(int memberNo, String challengeCategory) {
		this();
		this.memberNo = memberNo;
		this.challengeCategory = challengeCategory;
	}//희정... searchChallenge 

	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getChallengeTitle() {
		return challengeTitle;
	}

	public void setChallengeTitle(String challengeTitle) {
		this.challengeTitle = challengeTitle;
	}

	public String getChallengeStartDate() {
		return challengeStartDate;
	}

	public void setChallengeStartDate(String challengeStartDate) {
		this.challengeStartDate = challengeStartDate;
	}

	public String getChallengeEndDate() {
		return challengeEndDate;
	}

	public void setChallengeEndDate(String challengeEndDate) {
		this.challengeEndDate = challengeEndDate;
	}

	public String getChallengeCategory() {
		return challengeCategory;
	}

	public void setChallengeCategory(String challengeCategory) {
		this.challengeCategory = challengeCategory;
	}

	public int getChallengeLikes() {
		return challengeLikes;
	}

	public void setChallengeLikes(int challengeLikes) {
		this.challengeLikes = challengeLikes;
	}


	public boolean isChallengeSharing() {
		return challengeSharing;
	}

	public void setChallengeSharing(boolean challengeSharing) {
		this.challengeSharing = challengeSharing;
	}

	public List<ChallengeLog> getChallengeLogList() {
		return challengeLogList;
	}
	public void setChallengeLogList(List<ChallengeLog> challengeLogList) {
		this.challengeLogList = challengeLogList;
	}
	public List<ChallengeComment> getChallengeCommentList() {
		return challengeCommentList;
	}
	public void setChallengeCommentList(List<ChallengeComment> challengeCommentList) {
		this.challengeCommentList = challengeCommentList;
	}
	public List<ChallengeContent> getChallengeContentList() {
		return challengeContentList;
	}
	public void setChallengeContentList(List<ChallengeContent> challengeContentList) {
		this.challengeContentList = challengeContentList;
	}

	@Override
	public String toString() {
		return "Challenge [challengeNo=" + challengeNo + ", challengeTitle=" + challengeTitle + ", challengeStartDate="
				+ challengeStartDate + ", challengeEndDate=" + challengeEndDate + ", memberNo=" + memberNo
				+ ", challengeCategory=" + challengeCategory + ", challengeLikes=" + challengeLikes
				+ ", challengeSharing=" + challengeSharing + ", challengeLogList=" + challengeLogList
				+ ", challengeCommentList=" + challengeCommentList + ", challengeContentList=" + challengeContentList
				+ "]";
	}

}
