package com.spring.plan.model.vo;

public class BoardComment {
	private String commentNickname;
	private String boardComment;
	private String boardReplyComment;
	private String boardCommentWriteDate;
	
	public BoardComment() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	
	public BoardComment(String commentNickname, String boardComment, String boardReplyComment,
			String boardCommentWriteDate) {
		super();
		this.commentNickname = commentNickname;
		this.boardComment = boardComment;
		this.boardReplyComment = boardReplyComment;
		this.boardCommentWriteDate = boardCommentWriteDate;
	}
	

	public BoardComment(String commentNickname, String boardComment, String boardReplyComment,
			String boardCommentWriteDate, Board board) {
		super();
		this.commentNickname = commentNickname;
		this.boardComment = boardComment;
		this.boardReplyComment = boardReplyComment;
		this.boardCommentWriteDate = boardCommentWriteDate;
		this.board = board;
	}
	
	public BoardComment(String commentNickname, String boardComment, String boardReplyComment,
			String boardCommentWriteDate, Board board, Member member) {
		super();
		this.commentNickname = commentNickname;
		this.boardComment = boardComment;
		this.boardReplyComment = boardReplyComment;
		this.boardCommentWriteDate = boardCommentWriteDate;
		this.board = board;
		this.member = member;
	}
	private Board board;
	
	private Member member;


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
