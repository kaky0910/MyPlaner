package com.spring.plan.model.vo;

import java.util.List;

public class Board {
	private String boardTitle;							
	private String boardWriteDate;
	private String boardContent;
	private int boardLikes;
	private int boardHits;
	private int boardNo;
	private List<String> boardPictures;
	private List<BoardComment> boardCommentList;
	
	public Board(){}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriteDate() {
		return boardWriteDate;
	}

	public void setBoardWriteDate(String boardWriteDate) {
		this.boardWriteDate = boardWriteDate;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public int getBoardLikes() {
		return boardLikes;
	}

	public void setBoardLikes(int boardLikes) {
		this.boardLikes = boardLikes;
	}

	public int getBoardHits() {
		return boardHits;
	}

	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public List<String> getBoardPictures() {
		return boardPictures;
	}

	public void setBoardPictures(List<String> boardPictures) {
		this.boardPictures = boardPictures;
	}

	public List<BoardComment> getBoardCommentList() {
		return boardCommentList;
	}

	public void setBoardCommentList(List<BoardComment> boardCommentList) {
		this.boardCommentList = boardCommentList;
	}

	@Override
	public String toString() {
		return "Board [boardTitle=" + boardTitle + ", boardWriteDate=" + boardWriteDate + ", boardContent="
				+ boardContent + ", boardLikes=" + boardLikes + ", boardHits=" + boardHits + ", boardNo=" + boardNo
				+ ", boardPictures=" + boardPictures + ", boardCommentList=" + boardCommentList + "]";
	}
	
	
}
