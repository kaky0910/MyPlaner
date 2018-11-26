package com.spring.plan.model.vo;

import java.util.Map;

public class Habit {
	private String nickname;
	private String checkHabit;
	private String habitStartDate;
	private String habitEndDate;
	private Map<String, String> habitCheckByMonth; //YYYY.MM 로 Habit 체크여부 넣는 Field
	
	public Habit() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	
	public String getCheckHabit() {
		return checkHabit;
	}

	public void setCheckHabit(String checkHabit) {
		this.checkHabit = checkHabit;
	}

	public String getHabitStartDate() {
		return habitStartDate;
	}

	public void setHabitStartDate(String habitStartDate) {
		this.habitStartDate = habitStartDate;
	}

	public String getHabitEndDate() {
		return habitEndDate;
	}

	public void setHabitEndDate(String habitEndDate) {
		this.habitEndDate = habitEndDate;
	}

	public Map<String, String> getHabitCheckByMonth() {
		return habitCheckByMonth;
	}
	public void setHabitCheckByMonth(Map<String, String> habitCheckByMonth) {
		this.habitCheckByMonth = habitCheckByMonth;
	}

	@Override
	public String toString() {
		return "Habit [nickname=" + nickname + ", checkHabit=" + checkHabit + ", habitStartDate=" + habitStartDate
				+ ", habitEndDate=" + habitEndDate + ", habitCheckByMonth=" + habitCheckByMonth + "]";
	}
	
}
