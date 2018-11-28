package com.spring.plan.model.vo;

import java.util.List;

public class Member {
	private String id;
	private String kakaoId;
	private String password;
	private String token;
	private String nickname;
	private String gender;
	private String mail;
	private String registDate;
	private String memo;
	private List<Challenge> challengeList;
	private List<Schedule> ScheduleList;
	private List<Board> boardList;
	private List<Habit> habitList;
	private List<Message> messageList;
	private List<String> colorList;
	
	public Member() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getKakaoId() {
		return kakaoId;
	}
	public void setKakaoId(String kakaoId) {
		this.kakaoId = kakaoId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public List<Challenge> getChallengeList() {
		return challengeList;
	}
	public void setChallengeList(List<Challenge> challengeList) {
		this.challengeList = challengeList;
	}
	public List<Schedule> getScheduleList() {
		return ScheduleList;
	}
	public void setScheduleList(List<Schedule> scheduleList) {
		ScheduleList = scheduleList;
	}
	public List<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<Board> boardList) {
		this.boardList = boardList;
	}
	public List<Habit> getHabitList() {
		return habitList;
	}
	public void setHabitList(List<Habit> habitList) {
		this.habitList = habitList;
	}
	public List<Message> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}
	public List<String> getColorList() {
		return colorList;
	}
	public void setColorList(List<String> colorList) {
		this.colorList = colorList;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", kakaoId=" + kakaoId + ", password=" + password + ", token=" + token
				+ ", nickname=" + nickname + ", gender=" + gender + ", mail=" + mail + ", registDate=" + registDate
				+ ", memo=" + memo + ", challengeList=" + challengeList + ", ScheduleList=" + ScheduleList
				+ ", boardList=" + boardList + ", habitList=" + habitList + ", messageList=" + messageList
				+ ", colorList=" + colorList + "]";
	}
	
	
}
