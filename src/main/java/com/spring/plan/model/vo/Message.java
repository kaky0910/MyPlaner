package com.spring.plan.model.vo;

public class Message {
	private int messageNo;
	private int senderMemberNo;
	private int destinationMemberNo;
	private String messageSendDate;
	private String messageContent;
	private String messageTitle;
	private boolean check;
	
	public Message() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	public Message(int messageNo, int senderMemberNo, int destinationMemberNo, String messageSendDate,
			String messageContent, String messageTitle) {
		super();
		this.messageNo = messageNo;
		this.senderMemberNo = senderMemberNo;
		this.destinationMemberNo = destinationMemberNo;
		this.messageSendDate = messageSendDate;
		this.messageContent = messageContent;
		this.messageTitle = messageTitle;
	}//희정 sendMessage
	
	
	public int getMessageNo() {
		return messageNo;
	}

	public void setMessageNo(int messageNo) {
		this.messageNo = messageNo;
	}
	
	public int getSenderMemberNo() {
		return senderMemberNo;
	}

	public void setSenderMemberNo(int senderMemberNo) {
		this.senderMemberNo = senderMemberNo;
	}

	public int getDestinationMemberNo() {
		return destinationMemberNo;
	}

	public void setDestinationMemberNo(int destinationMemberNo) {
		this.destinationMemberNo = destinationMemberNo;
	}

	public String getMessageSendDate() {
		return messageSendDate;
	}

	public void setMessageSendDate(String messageSendDate) {
		this.messageSendDate = messageSendDate;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageTitle() {
		return messageTitle;
	}

	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	
	public boolean isCheck() {
		return check;
	}

	public void setCheck(boolean check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Message [messageNo=" + messageNo + ", senderMemberNo=" + senderMemberNo + ", destinationMemberNo="
				+ destinationMemberNo + ", messageSendDate=" + messageSendDate + ", messageContent=" + messageContent
				+ ", messageTitle=" + messageTitle + ", check=" + check + "]";
	}

	
}
