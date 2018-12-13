<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar cal = Calendar.getInstance();

	String strYear = request.getParameter("year");
	String strMonth = request.getParameter("month");

	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH);
	int date = cal.get(Calendar.DATE);

	if (strYear != null) {
		year = Integer.parseInt(strYear);
		month = Integer.parseInt(strMonth);

	} else {

	}
	//년도/월 셋팅
	cal.set(year, month, 1);

	int startday = cal.getMinimum(java.util.Calendar.DATE);
	int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
	int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
	int newLine = 0;

	//오늘 날짜 저장.
	Calendar todayCal = Calendar.getInstance();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
	int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>
<html lang="ko">
<head>
<TITLE>캘린더</TITLE>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<script type="text/javaScript" language="javascript"></script>

</head>
<body>
	<form name="calendarFrm" id="calendarFrm" action="" method="post">
		<div id="content" style="width: 712px;">
			<table width="100%" border="0" cellspacing="1" cellpadding="1">
				<tr>
					<td align="right"><input type="button"
						onclick="javascript:location.href='<c:url value='/callendar.jsp' />'"
						value="오늘" /></td>
				</tr>
			</table>
			<!--날짜 네비게이션  -->
			<table width="100%" border="0" cellspacing="1" cellpadding="1"
				bgcolor="#F3F9D7" style="border: 1px solid #e1e1e1">
				<tr>
					<td height="60">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td height="10"></td>
							</tr>
							<tr>
								<td align="center" style="font-weight: bold; font-size: 20px;">
								<a href="<c:url value='/callendar.jsp' />?year=<%=year - 1%>&amp;month=<%=month%>" target="_self"> 
								<b>&lt;&lt;</b> 
								<!-- 이전해 -->
								
								</a> 
								<% 
								if (month > 0) { %> 
								<a href="<c:url value='/callendar.jsp' />?year=<%=year%>&amp;month=<%=month - 1%>" target="_self"> 
								<b>&lt;</b> 
								<!-- 이전달 -->
								</a> 
								
								<% } 
								else { %> 
								<b>&lt;</b> 
								<% } %> &nbsp;&nbsp; 
								
								<%=year%>년 <%=month + 1%>월 &nbsp;&nbsp; 
								<% if (month < 11) { %> 
								<a href="<c:url value='/callendar.jsp' />?year=<%=year%>&amp;month=<%=month + 1%>" target="_self"> 
								<!-- 다음달 --> <b>&gt;</b>
								</a> 
								<%} else {%> 
								<b>&gt;</b> 
								<% 	} %> 
								<a href="<c:url value='/callendar.jsp' />?year=<%=year + 1%>&amp;month=<%=month%>" target="_self"> 
								<!-- 다음해 --> 
								<b>&gt;&gt;</b>
								</a>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
			<br>
			<!-- 날짜 네비게이션 끝 -->

			<table border="1" cellspacing="1" cellpadding="1" bgcolor="#FFFFFF">
				<thead>
					<tr bgcolor="#CECECE">
						<td width='100px'>
							<div align="center">
								<font color="red">sun</font>
							</div>
						</td>
						<td width='100px'>
							<div align="center">mon</div>
						</td>
						<td width='100px'>
							<div align="center">tue</div>
						</td>
						<td width='100px'>
							<div align="center">wed</div>
						</td>
						<td width='100px'>
							<div align="center">thu</div>
						</td>
						<td width='100px'>
							<div align="center">fri</div>
						</td>
						<td width='100px'>
							<div align="center">
								<font color="#529dbc">sat</font>
							</div>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<%
							//처음 빈공란 표시
							for (int index = 1; index < start; index++) {
								out.println("<td >&nbsp;</td>");
								newLine++;
							}

							for (int index = 1; index <= endDay; index++) {
								String color = "";

								if (newLine == 0) {
									color = "RED";
								} else if (newLine == 6) {
									color = "#529dbc";
								} else {
									color = "BLACK";
								}
								;

								String sUseDate = Integer.toString(year);

								sUseDate += Integer.toString(month + 1).length() == 1 ? "0" + Integer.toString(month + 1)
										: Integer.toString(month + 1);
								sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index)
										: Integer.toString(index);

								int iUseDate = Integer.parseInt(sUseDate);

								String backColor = "#FCFBFC";// "#EFEFEF";
								if (iUseDate == intToday) {
									backColor = "#e1e1e1";//"#A8B2B9";//"#c9c9c9";
								}

								out.println("<td valign='top' align='left' height='92px' bgcolor='" + backColor + "' nowrap>");
						%>
						<font color='<%=color%>'><a href="#" style="text-decoration: none;">&nbsp;<%=index%></a>
						</font>

						<%
							//out.println("<BR>");
								//out.println(iUseDate);
								//out.println("<BR>");

								//기능 제거	
								out.println("</td>");
								newLine++;

								if (newLine == 7) {
									out.println("</tr>");
									if (index <= endDay) {
										out.println("<tr>");
									}
									newLine = 0;
								}
							}
							//마지막 공란 LOOP
							while (newLine > 0 && newLine < 7) {
								out.println("<td>&nbsp;</td>");
								newLine++;
							}
						%>
					</tr>
				</tbody>
			</table>
		</div>
	</form>
</body>
</HTML>
