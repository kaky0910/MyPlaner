<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Planer</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/calendar.css">
<style type="text/css">
	
</style>
<script src="${pageContext.request.contextPath}/js/moment.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/calendar.js"></script>
<script type="text/javascript">
var monthCount = moment().month();
var yearCount = moment().year();

	$(function() {
		var arr = [ [ 1, 3 ], [ 3, 7 ], [ 3, 4 ], [ 6, 8 ], [ 10, 13 ],
				[ 20, 28 ] ]; //challenge (시작일, 마지막일) format으로 arr로 입력
		new Promise(function(resolve, reject) {
			calendarInit(yearCount, monthCount);
			resolve(arr);
		}).then(setChallenge1(arr)).then(setChallenge2(arr)).then(
				setChallenge3(arr));
		//alert(moment().format());

		var geo = navigator.geolocation;
		var lon;
		var lat;
		geo.getCurrentPosition(function(position) {
			lon = position.coords.longitude;
			lat = position.coords.latitude;
			$.ajax({
				method : "get",
				url : 'http://api.openweathermap.org/data/2.5/weather?lat='
						+ lat + '&lon=' + lon
						+ '&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
				success : function(data) {
					$('#weather').append(data.weather[0].main);
				}
			});
		});
		$.ajax({
			method : 'get',
			url : 'searchResult.do',
			data : {"word" : "메롱"},
			dataType : 'json',
			success : function(data){
				var d = JSON.parse(data.result);
				alert(d.items[0].title);
				$('#search div').each(function(index){
					$(this).html('<h4>'+d.items[index].title+'</h4><p>'+d.items[index].description+'</p>');
				});
			}
		})
	});
</script>

</head>
<body>

	<h1>index</h1>
	${data}
	<br>
	<div></div>

	<div id="section1">
		<div id="weather"></div>
		<div class="calendar" id="calendar" style="width:50%; display: inline-block;">
		<a href="javascript:prev()">이전</a>
			<p id="title_monthdate" style="display: inline-block;"></p><a href="javascript:next()">이후</a>
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
		<div style="width:20%; border: 1px black double; display: inline-block; margin-top:140px; margin-left: 60px;" id="search">
			<h2>Date</h2>
			<h4>tag</h4>
			<div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height:100px; overflow: hidden;"></div>
			<div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height:100px; overflow: hidden;"></div>
			<div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height:100px; overflow: hidden;"></div>
			<div style="border-bottom: 4px solid gray; border-top: 4px solid gray; height:100px; overflow: hidden;"></div>
		</div>
		<div id="search" style="float: left; width: 20%"></div>
	</div>



</body>
</html>