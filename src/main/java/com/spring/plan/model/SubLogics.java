package com.spring.plan.model;

import java.time.LocalDate;
import java.time.Period;

public class SubLogics {
	
	// YYYYMMDD , YYYYMMDD  사이 기간 리턴 
	// ex) 20181212, 20181213    return ::: 2
	public static int getDuration(String startDate, String endDate) {			
		
		LocalDate sd = LocalDate.of(Integer.parseInt(startDate.substring(0, 4)), 
									Integer.parseInt(startDate.substring(4, 6)), 
									Integer.parseInt(startDate.substring(6)));
		LocalDate ed = LocalDate.of(Integer.parseInt(endDate.substring(0, 4)), 
									Integer.parseInt(endDate.substring(4,6)), 
									Integer.parseInt(endDate.substring(6)));
		
		Period p = Period.between(sd, ed);
		return p.getDays()+1;
	}
	
	// 날짜수를 통해 check String을 만듬  
	// input 3 ------> return "000"
	public static String getCheckString(int count) {
		StringBuffer sb = new StringBuffer();
		
		for(int i=0;i<count;i++) sb.append("0");
		
		return sb.toString();
	}
	
	// overloading :::: 위에 두개 합
	public static String getCheckString(String startDate, String endDate) {	
		return getCheckString(getDuration(startDate, endDate));
	}

}
