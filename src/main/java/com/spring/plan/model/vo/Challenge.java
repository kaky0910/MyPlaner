package com.spring.plan.model.vo;

import java.util.List;

public class Challenge {
	private int challengeNo;
	private String title;
	private String startDate;
	private String endDate;
	private String nickname;
	private String category;
	private int likes;
	private List<ChallengeLog> challengeLogList;
	private List<ChallengeComment> challengeCommentList;
	private List<ChallengeContent> challengeContentList;
	
	public Challenge() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	
	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
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
	
	
}
