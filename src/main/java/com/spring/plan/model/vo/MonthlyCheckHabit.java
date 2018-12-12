package com.spring.plan.model.vo;

import java.util.Arrays;

public class MonthlyCheckHabit {
	private String month;
	private char[] checkHabit;
	private String habit;
	
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public char[] getCheckHabit() {
		return checkHabit;
	}
	public void setCheckHabit(char[] checkHabit) {
		this.checkHabit = checkHabit;
	}
	@Override
	public String toString() {
		return "MonthlyCheckHabit [month=" + month + ", checkHabit=" + Arrays.toString(checkHabit) + ", habit=" + habit
				+ "]";
	}
	
	
}
