package com.spring.plan.model.vo;

public class WeeklyCheckHabit {
	private String habit;
	private String habitCheck;		// 7자리 ex)  0010001 일~토
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getHabitCheck() {
		return habitCheck;
	}
	public void setHabitCheck(String habitCheck) {
		this.habitCheck = habitCheck;
	}
	@Override
	public String toString() {
		return "WeeklyCheckHabit [habit=" + habit + ", habitCheck=" + habitCheck + "]";
	}
	
	
}
