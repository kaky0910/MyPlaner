package com.spring.plan.model.vo;

public class Message {
	private int messageNo;
	private String senderNickname;
	private String destinationNickname;
	private String sendDate;
	private String contents;
	private String title;
	
	public Message() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public int getMessageNo() {
		return messageNo;
	}
	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	public String getSenderNickname() {
		return senderNickname;
	}
	public void setSenderNickname(String senderNickname) {
		this.senderNickname = senderNickname;
	}
	public String getDestinationNickname() {
		return destinationNickname;
	}
	public void setDestinationNickname(String destinationNickname) {
		this.destinationNickname = destinationNickname;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
