package com.spring.plan.model.vo;

public class BoardComment {
	private String commentNickname;
	private String boardComment;
	private String boardReplyComment;
	private String boardCommentWriteDate;
	
	public BoardComment() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getCommentNickname() {
		return commentNickname;
	}

	public void setCommentNickname(String commentNickname) {
		this.commentNickname = commentNickname;
	}

	public String getBoardComment() {
		return boardComment;
	}

	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}

	public String getBoardReplyComment() {
		return boardReplyComment;
	}

	public void setBoardReplyComment(String boardReplyComment) {
		this.boardReplyComment = boardReplyComment;
	}

	public String getBoardCommentWriteDate() {
		return boardCommentWriteDate;
	}

	public void setBoardCommentWriteDate(String boardCommentWriteDate) {
		this.boardCommentWriteDate = boardCommentWriteDate;
	}

	@Override
	public String toString() {
		return "BoardComment [commentNickname=" + commentNickname + ", boardComment=" + boardComment
				+ ", boardReplyComment=" + boardReplyComment + ", boardCommentWriteDate=" + boardCommentWriteDate + "]";
	}
	
	
	
}
