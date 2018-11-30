<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<!-- <script type="text/javascript">
   var geo = navigator.geolocation;
   var lon;
   var lat;
   geo.getCurrentPosition(function(position){
      lon = position.coords.longitude;
      lat = position.coords.latitude;
      alert('lon :: '+lon);
      alert('lat :: '+lat);
      $.ajax({
         method : "get",
         url: 'http://api.openweathermap.org/data/2.5/weather?lat='+lat+'&lon='+lon+'&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
         success : function(data){
            alert(data.weather[0].main);
         }
      });
   });
</script> -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar.css">
<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/calendar.js"></script>
<script type="text/javascript">
var monthCount = moment().month();
var yearCount = moment().year();
$(function(){
	   //alert(moment().format());
	   calendarInit(yearCount,monthCount);
	   
	  
	   
});
</script>
</head>
<body>

	<h1>index</h1>
	${data}
	<br>
	<div></div>

	<div style="height: 300px; color: black;"></div>
	<div id="section1">
		<div class="calendar" id="calendar">
		<a href="javascript:prev()">이전</a>
			<p id="title_monthdate"></p><a href="javascript:next()">이후</a>
			<div class="calendar__header">
				<div>SUN</div>
				<div>MON</div>
				<div>TUE</div>
				<div>WED</div>
				<div>THU</div>
				<div>FRI</div>
				<div>SAT</div>
			</div>
			<div class="calendar__week"></div>
			<div class="calendar__week"></div>
			<div class="calendar__week"></div>
			<div class="calendar__week"></div>
			<div class="calendar__week"></div>
		</div>
		<div id="search" style="float: left; width: 20%"></div>
	</div>



</body>
</html>