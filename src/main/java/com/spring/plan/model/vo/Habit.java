package com.spring.plan.model.vo;

import java.util.Map;

public class Habit {
	private String nickname;
	private String habit;
	private String startDate;
	private String endDate;
	private Map<String, String> habitCheckByMonth; //YYYY.MM 로 Habit 체크여부 넣는 Field
	
	public Habit() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Map<String, String> getHabitCheckByMonth() {
		return habitCheckByMonth;
	}
	public void setHabitCheckByMonth(Map<String, String> habitCheckByMonth) {
		this.habitCheckByMonth = habitCheckByMonth;
	}
	
	
	
}
