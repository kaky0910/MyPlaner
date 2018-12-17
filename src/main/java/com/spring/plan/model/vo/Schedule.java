package com.spring.plan.model.vo;

import java.time.LocalDate;
import java.time.Period;

public class Schedule {
	private int scheduleNo;
	private String scheduleTitle;
	private String scheduleStartDate;			//YYYYMMDD
	private String scheduleEndDate;				//YYYYMMDD
	private String scheduleContent;
	private String scheduleTag;
	private String scheduleCheck;
	private String scheduleColor;
	private int memberNo;
	
	public Schedule() {}
	
	public Schedule(String scheduleStartDate,String scheduleEndDate) {
		this.scheduleStartDate = scheduleStartDate;
		this.scheduleEndDate = scheduleEndDate;
	}
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

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	
	public String getStartDay() {			//날짜만
		return getScheduleStartDate().substring(6);
	}
	public String getEndDay() {				//날짜만
		return getScheduleEndDate().substring(6);
	}
	
	public boolean isCheck() {
		String day = Daily.getDayByDate();
		Period p = Period.between(LocalDate.of(Integer.parseInt(scheduleStartDate.substring(0,4)), Integer.parseInt(scheduleStartDate.substring(4,6)),Integer.parseInt(scheduleStartDate.substring(6)))
				, LocalDate.of(Integer.parseInt(day.substring(0, 4)), Integer.parseInt(day.substring(4, 6)), Integer.parseInt(day.substring(6))));
		
		if(p.getDays()>=0 && p.getDays()<scheduleCheck.length()) {
			System.out.println(scheduleTitle+" -- schedule CHECK :: "+scheduleCheck+"       , p.getDay() ::: "+p.getDays());
			char[] arr = scheduleCheck.toCharArray();
			if(arr[p.getDays()]=='0') {
				System.out.println("return false ");
				return false;
			}
			else {
				System.out.println("return true ");
				return true;
			}
		}
		return false;
	}
	
	

	@Override
	public String toString() {
		return "Schedule [scheduleNo=" + scheduleNo + ", scheduleTitle=" + scheduleTitle + ", scheduleStartDate="
				+ scheduleStartDate + ", scheduleEndDate=" + scheduleEndDate + ", scheduleContent=" + scheduleContent
				+ ", scheduleTag=" + scheduleTag + ", scheduleCheck=" + scheduleCheck + ", scheduleColor="
				+ scheduleColor + ", memberNo=" + memberNo + "]";
	}
	
	
}
