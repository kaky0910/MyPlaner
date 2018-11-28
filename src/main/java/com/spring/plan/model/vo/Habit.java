package com.spring.plan.model.vo;

import java.util.Map;

public class Habit {
	private int memberNo;
	private String checkHabit;
	private String habitStartDate;
	private String habitEndDate;
	private Map<String, String> habitCheckByMonth; //YYYY.MM 로 Habit 체크여부 넣는 Field
	
	public Habit() {}
	
	//////여기에 생성자 추가(어따쓰는지도  *주*석*)

	
	public String getCheckHabit() {
		return checkHabit;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
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
		return "Habit [memberNo=" + memberNo + ", checkHabit=" + checkHabit + ", habitStartDate=" + habitStartDate
				+ ", habitEndDate=" + habitEndDate + ", habitCheckByMonth=" + habitCheckByMonth + ", getCheckHabit()="
				+ getCheckHabit() + ", getMemberNo()=" + getMemberNo() + ", getHabitStartDate()=" + getHabitStartDate()
				+ ", getHabitEndDate()=" + getHabitEndDate() + ", getHabitCheckByMonth()=" + getHabitCheckByMonth()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
