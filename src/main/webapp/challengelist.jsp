<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/challengeCard.css">

<script src="${path}/js/challengeCard.js"></script>
<script type="text/javascript">
	$(function() {
		var d = new Date();
		var data = d.getFullYear() + "-" + (d.getMonth() + 1) + "-"
				+ d.getDate();
		$('#startDate').html(data);
		$('#endDate').html(data);
	});
</script>
</head>
<body>
	<div class="card">
		<!-- Face 2 -->
		<div class="card-face face-2">
			<!-- Back trigger -->
			<button class="card-face__back-button"
				data-card-back="data-card-back">
				<img src="http://imgh.us/arrow_1.svg" width="19" height="19"
					draggable="false" />
			</button>
			<img class="card-face__stats" src="http://imgh.us/Likes.png"
				width="100" height="100" draggable="false" /><img
				class="card-face__stats" src="http://imgh.us/Followers.png"
				width="100" height="100" draggable="false" /><img
				class="card-face__stats" src="http://imgh.us/Views.png" width="100"
				height="100" draggable="false" />
			<!-- Settings Button -->
			<img class="card-face__settings-button" src="http://imgh.us/cog.svg"
				width="17" height="17" draggable="false" />
		</div>
		<!-- Face 1 -->
		<div class="card-face face-1">
			<!-- Menu trigger -->
			<button class="card-face__menu-button"
				data-card-menu="data-card-menu">
				<img src="http://imgh.us/dots_1.svg" width="5" height="23"
					draggable="false" />
			</button>
			<!-- Avatar -->
			<div class="card-face__avatar">
				<!-- User avatar -->
				<img
					src="https://s3.amazonaws.com/uifaces/faces/twitter/csswizardry/128.jpg"
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
					<b> STARTDATE : </b> <span id="startDate"></span> <br> <b>
						ENDDATE : </b> <span id="endDate"></span>
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



	<!-- <form>


		<aside class="profile-card">
			<header>
				here’s the avatar <a target="_blank" href="#"> <img
					src="http://lorempixel.com/150/150/people/" class="hoverZoomLink">
				</a> the Title
				<h1>
					<b>물 여덟잔 마시기</b>
				</h1>
				<b>핫브레이커</b>님 START-END DATE
				<h2>
					<b> STARTDATE : </b> <span id="startDate"></span> <br> <b>
						ENDDATE : </b> <span id="endDate"></span>
				</h2>
			</header>
			challenge-content
			<div class="challenge-content">
				profile-bio <b>Category : </b> 독서<br> <b>Sharing : </b> ON
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
	</form> -->
</body>
</html>