package com.spring.plan.model.vo;

public class CheckHabit {
	private Habit habit;
	private String month;
	private String checkHabit;
	public Habit getHabit() {
		return habit;
	}
	public void setHabit(Habit habit) {
		this.habit = habit;
	}
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
	@Override
	public String toString() {
		return "CheckHabit [habit=" + habit + ", month=" + month + ", checkHabit=" + checkHabit + "]";
	}
	
	
}
