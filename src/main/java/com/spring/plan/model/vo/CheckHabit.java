package com.spring.plan.model.vo;

public class CheckHabit {
	private int memberNo;
	private String habit;
	private String month;
	private String checkHabit;
	private String color;
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getCheckHabit() {
		return checkHabit;
	}
	public void setCheckHabit(String checkHabit) {
		this.checkHabit = checkHabit;
	}
	
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	
	public String getColor() {
		String[] colors = {"red","yellow","green","blue","pink","orange"};
		int r = (int)(Math.random()*6);
		return colors[r];
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "CheckHabit [memberNo=" + memberNo + ", habit=" + habit + ", month=" + month + ", checkHabit="
				+ checkHabit + "]";
	}
	
	
}
