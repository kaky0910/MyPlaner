package com.spring.plan.model.vo;

import java.util.Map;

public class Statics {
	private int memberNo;
	private Map<String, Integer> emotionCount;
	
	
	public int getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}
	public Map<String, Integer> getEmotionCount() {
		return emotionCount;
	}
	public void setEmotionCount(Map<String, Integer> emotionCount) {
		this.emotionCount = emotionCount;
	}
	@Override
	public String toString() {
		return "Statics [memberNo=" + memberNo + ", emotionCount=" + emotionCount + "]";
	}
	
	
}
