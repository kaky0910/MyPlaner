package com.spring.plan.model.vo;

public class Message {
	private int messageNo;
	private String senderNickname;
	private String destinationNickname;
	private String messageSendDate;
	private String messageContents;
	private String messageTitle;
	
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

	public String getMessageSendDate() {
		return messageSendDate;
	}

	public void setMessageSendDate(String messageSendDate) {
		this.messageSendDate = messageSendDate;
	}

	public String getMessageContents() {
		return messageContents;
	}

	public void setMessageContents(String messageContents) {
		this.messageContents = messageContents;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}

	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", senderNickname=" + senderNickname + ", destinationNickname="
				+ destinationNickname + ", messageSendDate=" + messageSendDate + ", messageContents=" + messageContents
				+ ", messageTitle=" + messageTitle + "]";
	}
	
}
