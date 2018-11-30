<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
	href="${path}/css/calendar.css">
<link rel="stylesheet"
	href="${path}/css/emoticon.css">
<link rel="stylesheet"
	href="${path}/css/checkbox.css">
<link rel="stylesheet"
	href="${path}/css/memo.css">
<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo" rel="stylesheet">

<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
	
<script src="${path}/js/moment.js"></script>
<script type="text/javascript">
	
	
	$(function(){
		//1. 현재 위치를 받고 그 위치의 날씨를 받아오는 기능
		var geo = navigator.geolocation;
		var lon;
		var lat;
		geo.getCurrentPosition(function(position){
			lon = position.coords.longitude;
			lat = position.coords.latitude;
		
			var weather;
			
			$.ajax({
				method : "get",
				url: 'http://api.openweathermap.org/data/2.5/weather?lat='+lat+'&lon='+lon+'&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
				success : function(data){
					weather = data.weather[0].main;
					//alert(weather);
					$('#weatherTest>h2').append(weather);
				}//callback
			});//ajax
		});//geo.getCurrentPosition
		//1
		
		//2. Section2(Daily)에 오늘 날짜를 출력하는 기능
		var date = moment().date();
		var month = moment().month()+1;
		var year = moment().year();
		$('#Date ').html(year +"년 " + month + "월 " + date +"일");
		//$('#Date ').html(year +"/ " + month + "/ " + date);
		$('#Date ').css('font-size', '2.8em');
		//2
	
		
		//3. emotion 가져오기, 보내기
		$('#emotion_tbl td').click(function(){
			var emotion = $(this).children().attr('id');
		 	$.ajax({
				type:"get",
				url:"",
				data:"emotion="+emotion,
				
				success:function(data){
					$('#emotion_tbl td').addClass('clicked');
					$('#'+data.emotion).parent().removeClass('clicked');
				}//callback
			});//ajax 
		});//click
		//3
		
	});//ready
</script>

</head>
<body>


	<div id="titleArea" style="height: 85px; background-color: gray; margin-top:0px;">
	<p align="center" style="padding-top:35px;">Title</p>
</div>
	<div id="contents" style="float: left; width:73%; margin-left:10%; padding-right:2%; margin-top:25px; background-color: green; height: 1600px">

	<div>${data}</div>
	<div id="weatherTest"><h2>weather : </h2></div>
	
	<!-- START section1 -->
		<div id="section1" style="height: 650px;">
			<div class="calendar" id="calendar">
				<p id="title_monthdate">
					<a href="#" style="text-decoration: none; color: #A8B2B9">↓</a>11월<a
						href="#" style="text-decoration: none; color: #A8B2B9">↑</a> <a
						href="#" style="text-decoration: none; color: #A8B2B9">↓</a>28일<a
						href="#" style="text-decoration: none; color: #A8B2B9">↑</a>
				</p>
				<div class="calendar__header">
					<div>mon</div>
					<div>tue</div>
					<div>wed</div>
					<div>thu</div>
					<div>fri</div>
					<div>sat</div>
					<div>sun</div>
				</div>
				<div class="calendar__week">
					<div class="calendar__day day">1</div>
					<div class="calendar__day day">2</div>
					<div class="calendar__day day">3</div>
					<div class="calendar__day day">4</div>
					<div class="calendar__day day">5</div>
					<div class="calendar__day day">6</div>
					<div class="calendar__day day">7</div>
				</div>
				<div class="calendar__week">
					<div class="calendar__day day">8</div>
					<div class="calendar__day day">9</div>
					<div class="calendar__day day">10</div>
					<div class="calendar__day day">11</div>
					<div class="calendar__day day">12</div>
					<div class="calendar__day day">13</div>
					<div class="calendar__day day">14</div>
				</div>
				<div class="calendar__week">
					<div class="calendar__day day">15</div>
					<div class="calendar__day day">16</div>
					<div class="calendar__day day">17</div>
					<div class="calendar__day day">18</div>
					<div class="calendar__day day">19</div>
					<div class="calendar__day day">20</div>
					<div class="calendar__day day">21</div>
				</div>
				<div class="calendar__week">
					<div class="calendar__day day">22</div>
					<div class="calendar__day day">23</div>
					<div class="calendar__day day">24</div>
					<div class="calendar__day day">25</div>
					<div class="calendar__day day">26</div>
					<div class="calendar__day day">27</div>
					<div class="calendar__day day">28</div>
				</div>
				<div class="calendar__week">
					<div class="calendar__day day">29</div>
					<div class="calendar__day day">30</div>
					<div class="calendar__day day">31</div>
					<div class="calendar__day day">1</div>
					<div class="calendar__day day">2</div>
					<div class="calendar__day day">3</div>
					<div class="calendar__day day">4</div>
				</div>
			</div>
			<div id="search" style="float: left; width: 20%; color: black;">
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
				ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ</div>
		</div>
		<!-- END section1 -->
		
		
		
		
		
		
		
		<!-- START section2 -->
		<div id="section2" style="height: 650px; background-color:pink;">
			<div>
				<h1 id="Date" align="left" style="display:inline; margin-left:35px; margin-bottom: 5px;"></h1>
				<table id="emotion_tbl" style="float:right; margin-top :22px; margin-right:22px; height:30px;">
					<tr>
					<td><img id="happy" src="${path}/img/emotion/happy.png"></a></td>
					<td><img id="love" src="${path}/img/emotion/love.png"></td>
					<td><img id="shocked" src="${path}/img/emotion/shocked.png"></td>
					<td><img id="shy" src="${path}/img/emotion/shy.png"></td>
					<td><img id="tired" src="${path}/img/emotion/tired.png"></td>
					<td><img id="upset" src="${path}/img/emotion/upset.png"></td>
					<td><img id="verysad" src="${path}/img/emotion/verysad.png"></td></tr>
				</table>
			</div>
			
			<div style="float:left; width:26%; padding-left:2%; padding-right:2%; background-color:red; height:400px;">
				 <div id="wrapper">
					    <h2>Today's Schedule <i class="fa fa-check"></i> </h2>
					  	<div>
					        <input type="checkbox" id="scheduleCheck1"/>
					        <label for="check1">
					          <div><i class="fa fa-check"></i></div> 11월 가스비 내기
					        </label>
					    </div>
					    
					    <div>
					        <input type="checkbox" id="scheduleCheck1"/>
					        <label for="check2">
					          <div><i class="fa fa-check"></i></div> FinalProject Query 작성하기
					        </label>
					    </div>
				</div>
			</div>
			
			<div style="float:left; width:26%; padding-left:2%; padding-right:2%; margin-left:5%; margin-right:5%; background-color:yellow; height:400px;">
				<div id="wrapper">
				    <h2>Your Challenge <i class="fa fa-check"></i> </h2>
				  	<div>
				        <input type="checkbox" id="checkChallenge1"/>
				        <label for="check1">
				          <div><i class="fa fa-check"></i></div> 11월 가스비 내기
				        </label>
				    </div>
				    
				    <div>
				        <input type="checkbox" id="checkChallenge2"/>
				        <label for="check2">
				          <div><i class="fa fa-check"></i></div> FinalProject Query 작성하기
				        </label>
				    </div>
				    
				    <div>
				        <input type="checkbox" id="checkChallenge2"/>
				        <label for="check2">
				          <div><i class="fa fa-check"></i></div> FinalProject Query 작성하기
				        </label>
				    </div>
				</div>
			</div>
			<div style="float:right; width:26%;padding-left:2%; padding-right:2%;  background-color:red; height:400px;">
				<div id="wrapper">
					    <h2>Memo<i class="fa fa-check"></i> </h2>
					  	<a href="javascript:;" class="button" id="add_new">Add New Note</a>
						 으아아아아
						<div id="board">
			
						</div>
				</div>
			</div>
		</div>
		<!-- END section2 -->
	</div>
		
		
	<div id="navigater" style="float: right; width:8%; margin-right:5%; margin-top:25px; margin-left:2%; background-color:blue; height: 1600px">
		★★★★★★★★★<br>
		★★★★★★★★★<br>
		★★★★★★★★★<br>
		★★★★★★★★★<br>
		★★★★★★★★★<br>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>

