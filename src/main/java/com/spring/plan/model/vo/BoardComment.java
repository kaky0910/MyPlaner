package com.spring.plan.model.vo;

public class BoardComment {
	private int boardNo;
	private int boardCommentNo;
	private int boardCommentMemberNo;
	private int boardReplyComment;
	private String boardComment;
	private String boardCommentWriteDate;
	
	public BoardComment() {}
	
	public BoardComment(int boardCommentMemberNo, String boardComment, int boardReplyComment,
			String boardCommentWriteDate) {
		super();
		this.boardCommentMemberNo = boardCommentMemberNo;
		this.boardComment = boardComment;
		this.boardReplyComment = boardReplyComment;
		this.boardCommentWriteDate = boardCommentWriteDate;
	}

	public BoardComment(int boardCommentMemberNo, String boardComment, int boardReplyComment,
			String boardCommentWriteDate, int boardNo) {
		super();
		this.boardCommentMemberNo = boardCommentMemberNo;
		this.boardComment = boardComment;
		this.boardReplyComment = boardReplyComment;
		this.boardCommentWriteDate = boardCommentWriteDate;
		this.boardNo = boardNo;
	}
	
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	
	public String getBoardComment() {
		return boardComment;
	}
	

	public int getBoardCommentNo() {
		return boardCommentNo;
	}

	public void setBoardCommentNo(int boardCommentNo) {
		this.boardCommentNo = boardCommentNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public int getBoardCommentMemberNo() {
		return boardCommentMemberNo;
	}

	public void setBoardCommentMemberNo(int boardCommentMemberNo) {
		this.boardCommentMemberNo = boardCommentMemberNo;
	}

	public void setBoardComment(String boardComment) {
		this.boardComment = boardComment;
	}

	public int getBoardReplyComment() {
		return boardReplyComment;
	}

	public void setBoardReplyComment(int boardReplyComment) {
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
		return "BoardComment [boardNo=" + boardNo + ", boardCommentNo=" + boardCommentNo + ", boardCommentMemberNo="
				+ boardCommentMemberNo + ", boardReplyComment=" + boardReplyComment + ", boardComment=" + boardComment
				+ ", boardCommentWriteDate=" + boardCommentWriteDate + "]";
	}
}
