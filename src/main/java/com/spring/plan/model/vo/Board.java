package com.spring.plan.model.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


public class Board {
	private String boardTitle;							
	private String boardWriteDate;
	private String boardContent;
	private int boardLikes;
	private int boardHits;
	private int boardNo;
	private int memberNo;
	private List<String> boardPictures;
	private List<BoardComment> boardCommentList;
	
	// 추가되는 컬럼
	private String orgfilename;
	private String newfilename;

	// upload 파일의 정보를 담는 필드를 선언
	private MultipartFile uploadFile;
			
	public Board(){}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	
		
	public Board(String boardTitle, String boardWriteDate, String boardContent, int boardLikes, int boardHits,
			int boardNo, List<String> boardPictures, List<BoardComment> boardCommentList) {
		super();
		this.boardTitle = boardTitle;
		this.boardWriteDate = boardWriteDate;
		this.boardContent = boardContent;
		this.boardLikes = boardLikes;
		this.boardHits = boardHits;
		this.boardNo = boardNo;
		this.boardPictures = boardPictures;
		this.boardCommentList = boardCommentList;
		
	}
	
	public String getBoardTitle() {
		return boardTitle;
	}
	
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriteDate() {
		return boardWriteDate;
	}
	
	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
	
	

	public String getOrgfilename() {
		return orgfilename;
	}

	public void setOrgfilename(String orgfilename) {
		this.orgfilename = orgfilename;
	}

	public String getNewfilename() {
		return newfilename;
	}

	public void setNewfilename(String newfilename) {
		this.newfilename = newfilename;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	@Override
	public String toString() {
		return "Board [boardTitle=" + boardTitle + ", boardWriteDate=" + boardWriteDate + ", boardContent="
				+ boardContent + ", boardLikes=" + boardLikes + ", boardHits=" + boardHits + ", boardNo=" + boardNo
				+ ", memberNo=" + memberNo + ", boardPictures=" + boardPictures + ", boardCommentList="
				+ boardCommentList + "]";
	}
	
}
