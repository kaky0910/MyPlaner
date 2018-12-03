<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}" />


<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/challengeCard.css">
<link rel="stylesheet" href="${path}/css/calendar.css">
<link rel="stylesheet" href="${path}/css/emoticon.css">
<link rel="stylesheet" href="${path}/css/checkbox.css">
<link rel="stylesheet" href="${path}/css/memo.css">
<link rel="stylesheet" href="${path}/css/carousel.css">
<link href="https://fonts.googleapis.com/css?family=East+Sea+Dokdo"
	rel="stylesheet">

<link href="https://fonts.googleapis.com/css?family=Yeon+Sung"
	rel="stylesheet">

<script src="${path}/js/moment.js"></script>
<script src="${path}/js/glider.js"></script>

<script type="text/javascript">
	$(function() {

		/* //0. 오늘 날짜 받아오기 
		(function() {
			var d = new Date();
			var data = d.getFullYear() + "-" + (d.getMonth() + 1) + "-"
					+ d.getDate();
			$('#startDate').attr('value', data);
			$('#endDate').attr('value', data);

		});//0 */

		//1. 현재 위치를 받고 그 위치의 날씨를 받아오는 기능
		var geo = navigator.geolocation;
		var lon;
		var lat;
		geo.getCurrentPosition(function(position) {
			lon = position.coords.longitude;
			lat = position.coords.latitude;

			var weather;

			$.ajax({
				method : "get",
				url : 'http://api.openweathermap.org/data/2.5/weather?lat='
						+ lat + '&lon=' + lon
						+ '&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
				success : function(data) {
					weather = data.weather[0].main;
					//alert(weather);
					$('#weatherTest>h2').append(weather);
				}//callback
			});//ajax
		});//geo.getCurrentPosition
		//1

		//2. Section2(Daily)에 오늘 날짜를 출력하는 기능
		var date = moment().date();
		var month = moment().month() + 1;
		var year = moment().year();
		$('#Date ').html(year + "년 " + month + "월 " + date + "일");
		//$('#Date ').html(year +"/ " + month + "/ " + date);
		$('#Date ').css('font-size', '2.8em');
		//2

		//3. emotion 가져오기, 보내기
		$('#emotion_tbl td').click(function() {
			var emotion = $(this).children().attr('id');
			$.ajax({
				type : "get",
				url : "",
				data : "emotion=" + emotion,

				success : function(data) {
					$('#emotion_tbl td').addClass('clicked');
					$('#' + data.emotion).parent().removeClass('clicked');
				}//callback
			});//ajax 
		});//click
		//3

		//4. newChallengeBtn을 누르면 writechallenge.jsp를 캐러셀에 포함한다.
		$('#newChallengeBtn').click(function() {
			$.ajax({
				url : "writechallenge.jsp",

				success : function(result) {

					$("#newchallengeDiv").html(result);
					$("#newchallengeDiv").css({
					});
				}//susccess
			});//ajax
			
		});//click
		//4
		
	});//ready
</script>

</head>
<body>
	<div id="titleArea"
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>

	<div id="contents"
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; background-color: green; height: 1600px">

		<div>${data}</div>
		<div id="weatherTest">
			<h2 style="margin-left: 10%">weather :</h2>
		</div>

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






		<hr>
		<!-- START section2 -->
		<div id="section2" style="height: 450px; background-color: pink;">
			<table style="width: 100%; margin: auto">
				<tr>
					<td colspan="2">
						<h1 id="Date" align="left"
							style="display: inline; margin-left: 35px; margin-bottom: 5px;"></h1>
					</td>
					<td><img src="${path}/img/weather/rainy.png" width="70px"
						height="70px" style="float: left">
					<td>
					<td align="right">
						<table id="emotion_tbl"
							style="float: right; margin-top: 22px; margin-right: 22px; height: 30px;">
							<td><img id="happy" src="${path}/img/emotion/happy.png"></a></td>
							<td><img id="love" src="${path}/img/emotion/love.png"></td>
							<td><img id="shocked" src="${path}/img/emotion/shocked.png"></td>
							<td><img id="shy" src="${path}/img/emotion/shy.png"></td>
							<td><img id="tired" src="${path}/img/emotion/tired.png"></td>
							<td><img id="upset" src="${path}/img/emotion/upset.png"></td>
							<td><img id="verysad" src="${path}/img/emotion/verysad.png"></td>
						</table>
					</td>
				</tr>
				<tr>
					<td colspan="2"><div
							style="float: left; width: 100%; padding-left: 4%; padding-right: 2%; height: 400px;">
							<div id="wrapper">
								<hr>
								<h2>
									Today's Schedule <i class="fa fa-check"></i>
								</h2>
								<hr>
								<div>
									<input type="checkbox" id="scheduleCheck1" /> <label
										for="scheduleCheck1">
										<div>
											<i class="fa fa-check"></i>
										</div> 11월 가스비 내기
									</label>
								</div>

								<div>
									<input type="checkbox" id="scheduleCheck2" /> <label
										for="scheduleCheck2">
										<div>
											<i class="fa fa-check"></i>
										</div> FinalProject Query 작성하기
									</label>
								</div>
							</div>
						</div></td>
					<td colspan="2">
						<div
							style="float: left; width: 100%; margin-left: 5%; margin-right: 1%; height: 400px;">
							<div id="wrapper">
								<hr>
								<h2>
									Your Challenge <i class="fa fa-check"></i>
								</h2>
								<hr>
								<div>
									<input type="checkbox" id="checkChallenge1" /> <label
										for="checkChallenge1">
										<div>
											<i class="fa fa-check"></i>
										</div> 11월 가스비 내기
									</label>
								</div>

								<div>
									<input type="checkbox" id="checkChallenge2" /> <label
										for="checkChallenge2">
										<div>
											<i class="fa fa-check"></i>
										</div> FinalProject Query 작성하기
									</label>
								</div>

								<div>
									<input type="checkbox" id="checkChallenge3" /> <label
										for="checkChallenge3">
										<div>
											<i class="fa fa-check"></i>
										</div> FinalProject Query 작성하기
									</label>
								</div>
							</div>
						</div>
					</td>
					<td colspan="2" align="right">
						<div
							style="float: right; width: 100%; height: 400px; margin-top: 20px; margin-right: 0;">
							<div id="wrapper">
								<form id="paper" method="get" action="" style="margin-right: 2%">
									<textarea placeholder="Enter something." id="text" name="text"
										rows="4"
										style="overflow: hidden; word-wrap: break-word; resize: none; width: 50%; height: 180px;"></textarea>
									<br> <input id="button" type="submit" value="Create">

								</form>
							</div>
						</div>
					</td>
			</table>
		</div>
		<!-- END section2 -->
		<div id="section4"
			style="height: 450px; background-color: blue; margin-top: 20px;">

			<div class="demo">
				<div id="add">
					<h1></h1>
				</div>
				<div align="right">
					<p class="buttons">
						<a class="button" id="addSlide">Add</a> <a class="button"
							id="removeSlide">Remove</a>
					</p>
				</div>
				<div data-name="Add/Remove Items" class="glider-contain multiple">
					<div class="gradient-border-bottom">
						<div class="gradient-border">
							<div class="glider" id="glider-add" style="">
								<%-- <c:forEach var="item" items="challengeList">
									<div>
										<form>
											<aside class="profile-card">
												<header>
													<!-- here’s the avatar -->
													<!-- <a target="_blank" href="#">  -->
													<img src="http://lorempixel.com/150/150/people/"
														class="hoverZoomLink">
													<!-- </a> -->
													<!-- the Title -->
													<h1>
														<b>물 여덟잔 마시기</b>
													</h1>
													<b>핫브레이커</b>님
													<!-- START-END DATE  -->
													<h2>
														<b> STARTDATE : </b> <span id="startDate"></span> <br>
														<b> ENDDATE : </b> <span id="endDate"></span>
													</h2>
												</header>
												<!-- challenge-content -->
												<div class="challenge-content">
													<!-- profile-bio -->
													<b>Category : </b> 독서<br> <b>Sharing : </b> ON
													<hr>
													<ul style="text-align: left">
														<li><b>Day 1</b> 첫 날
														<li><b>Day 2</b> 두번째 날
													</ul>
													<hr>
													<p>
														<em>124명</em>이 응원합니당.
													</p>
												</div>
											</aside>
										</form>
									</div>
								</c:forEach> --%>

								<div>
									<div class="card">
										<!-- Face 1 -->
										<div class="card-face face-1">
											<!-- Avatar -->
											<div class="card-face__avatar">
												<!-- User avatar -->
												<img
													src="https://image.flaticon.com/icons/svg/188/188241.svg"
													width="110" height="110" draggable="false" />
											</div>
											<!-- Name -->
											<h2 class="card-face__name">
												<b>물 여덟잔 마시기</b>
											</h2>
											<!-- Title -->
											<span class="card-face__title"><b>핫브레이커</b></span>
											<div class="challenge-content">
												<h4>
													<b> STARTDATE : </b> <span id="startDate"></span> <br>
													<b> ENDDATE : </b> <span id="endDate"></span>
												</h4>
												<b>Category : </b> 독서<br> <b>Sharing : </b> ON
												<hr>
												<ul style="text-align: left">
													<li><b>Day 1</b> 첫 날
													<li><b>Day 2</b> 두번째 날
												</ul>
												<hr>
												<em>124명</em>이 응원합니당.
											</div>
										</div>
									</div>
								</div>


								<div>
									<div class="card">
										<!-- Face 1 -->
										<div class="card-face face-1">
											<!-- Avatar -->
											<div class="card-face__avatar">
												<!-- User avatar -->
												<img
													src="https://image.flaticon.com/icons/svg/188/188243.svg"
													width="110" height="110" draggable="false" />
											</div>
											<!-- Name -->
											<h2 class="card-face__name">
												<b>머리 마사지 30분 하기</b>
											</h2>
											<!-- Title -->
											<span class="card-face__title"><b>연성</b></span>
											<div class="challenge-content">
												<h4>
													<b> STARTDATE : </b> <span style="display: inline"
														id="startDate"></span> <br> <b> ENDDATE : </b> <span
														style="display: inline" id="endDate"></span>
												</h4>
												<b>Category : </b> 자기관리<br> <b>Sharing : </b> ON
												<hr>
												<ul style="text-align: left">
													<li><b>Day 1</b> 첫 날 : 관자놀이 쪽을 주물주물
													<li><b>Day 2</b> 두번째 날 : M자 방지 휴..
												</ul>
												<hr>
												<em>85명</em>이 응원합니당.
											</div>
										</div>
									</div>
								</div>

								<div  id="newchallengeDiv" style="width: 290px; height: 500px">
									<div class="card" >
										<img src="${path}/img/writeChallenge.png"
											style="display: block; margin: auto; width: 50%; margin-top: 38%">
										<br> <br>
										<h3 align="center">새로운 도전을 해보세요!</h3>
										<br>
										<button id="newChallengeBtn" style="margin-left: 46%">GO</button>
									</div>
								</div>
							</div>
						</div>
						<button role="button" aria-label="Previous" class="glider-prev"
							id="glider-prev-add">
							<i class="fa fa-chevron-left"></i>prev</i>
						</button>
						<button role="button" aria-label="Next" class="glider-next"
							id="glider-next-add">
							<i class="fa fa-chevron-right"></i>next</i>
						</button>
						<div id="add-dots"></div>
					</div>

					<script>
						window
								.addEventListener(
										'load',
										function() {
											var glider = new Glider(
													document
															.getElementById('glider-add'),
													{
														slidesToShow : 3,
														duration : .6,
														dots : '#add-dots',
														arrows : {
															prev : '#glider-prev-add',
															next : '#glider-next-add'
														}
													});
											document
													.getElementById('addSlide')
													.addEventListener(
															'click',
															function() {
																var ele = document
																		.getElementById(
																				'add')
																		.cloneNode(
																				true);
																ele.id = '';
																ele
																		.querySelector('h1').textContent = glider.slides.length + 1;
																glider
																		.addItem(ele);
																try {
																	ga(
																			'send',
																			'event',
																			'Add/Remove Item',
																			'Add')
																} catch (ex) {
																}
															});
											document
													.getElementById(
															'removeSlide')
													.addEventListener(
															'click',
															function() {
																glider
																		.removeItem(glider.slides.length - 1);
																try {
																	ga(
																			'send',
																			'event',
																			'Add/Remove Item',
																			'Remove')
																} catch (ex) {
																}
															});
										})
					</script>


				</div>
			</div>
			<!-- section4 -->
		</div>
		<!-- contents -->


		<div id="navigater"
			style="float: right; width: 8%; margin-right: 5%; margin-top: 25px; margin-left: 2%; background-color: blue; height: 1600px">
			★★★★★★★★★<br> ★★★★★★★★★<br> ★★★★★★★★★<br> ★★★★★★★★★<br>
			★★★★★★★★★<br>
		</div>
</body>
<script type="text/javascript">
	
</script>
</html>

