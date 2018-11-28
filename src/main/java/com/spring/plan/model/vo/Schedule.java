package com.spring.plan.model.vo;

public class Schedule {
	private int scheduleNo;
	private String scheduleTitle;
	private String scheduleStartDate;
	private String scheduleEndDate;
	private String scheduleContent;
	private String scheduleTag;
	private String scheduleCheck;
	private String scheduleColor;
	private String nickname;
	
	public Schedule() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)
	
	public String getScheduleTitle() {
		return scheduleTitle;
	}

	public int getScheduleNo() {
		return scheduleNo;
	}

	public void setScheduleNo(int scheduleNo) {
		this.scheduleNo = scheduleNo;
	}

	public void setScheduleTitle(String scheduleTitle) {
		this.scheduleTitle = scheduleTitle;
	}

	public String getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(String scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public String getScheduleEndDate() {
		return scheduleEndDate;
	}

	public void setScheduleEndDate(String scheduleEndDate) {
		this.scheduleEndDate = scheduleEndDate;
	}

	public String getScheduleContent() {
		return scheduleContent;
	}

	public void setScheduleContent(String scheduleContent) {
		this.scheduleContent = scheduleContent;
	}

	public String getScheduleTag() {
		return scheduleTag;
	}

	public void setScheduleTag(String scheduleTag) {
		this.scheduleTag = scheduleTag;
	}

	public String getScheduleCheck() {
		return scheduleCheck;
	}

	public void setScheduleCheck(String scheduleCheck) {
		this.scheduleCheck = scheduleCheck;
	}

	public String getScheduleColor() {
		return scheduleColor;
	}

	public void setScheduleColor(String scheduleColor) {
		this.scheduleColor = scheduleColor;
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", scheduleTitle=" + scheduleTitle + ", scheduleStartDate="
				+ scheduleStartDate + ", scheduleEndDate=" + scheduleEndDate + ", scheduleContent=" + scheduleContent
				+ ", scheduleTag=" + scheduleTag + ", scheduleCheck=" + scheduleCheck + ", scheduleColor="
				+ scheduleColor + ", nickname=" + nickname + "]";
	}
	
}
