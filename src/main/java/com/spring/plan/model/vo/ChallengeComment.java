package com.spring.plan.model.vo;

public class ChallengeComment {

	private int challengeCommentNo;
	private String replyComment;
	private int challengeNo;
	private String nickname;
	private String comment;
	private String writeDate;
	
	public ChallengeComment() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	
	public int getChallengeCommentNo() {
		return challengeCommentNo;
	}
	public void setChallengeCommentNo(int challengeCommentNo) {
		this.challengeCommentNo = challengeCommentNo;
	}
	public String getReplyComment() {
		return replyComment;
	}
	public void setReplyComment(String replyComment) {
		this.replyComment = replyComment;
	}
	public int getChallengeNo() {
		return challengeNo;
	}
	public void setChallengeNo(int challengeNo) {
		this.challengeNo = challengeNo;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	
	
}
