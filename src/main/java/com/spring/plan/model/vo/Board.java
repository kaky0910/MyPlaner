package com.spring.plan.model.vo;

import java.util.List;

public class Board {
	private String title;							
	private String writeDate;
	private String content;
	private int likes;
	private int hits;
	private int boardNo;
	private List<String> pictures;
	private List<BoardComment> boardCommentList;
	
	public Board(){}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getHits() {
		return hits;
	}
	public void setHits(int hits) {
		this.hits = hits;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public List<String> getPictures() {
		return pictures;
	}
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	public List<BoardComment> getBoardCommentList() {
		return boardCommentList;
	}
	public void setBoardCommentList(List<BoardComment> boardCommentList) {
		this.boardCommentList = boardCommentList;
	}
	
	
}
