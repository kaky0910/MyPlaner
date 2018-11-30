<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/challengeCard.css">
<script type="text/javascript">
$(function(){
		var d = new Date();
		var data = d.getFullYear() + "-" +(d.getMonth() + 1) + "-"+ d.getDate();
		$('#startDate').html(data);		
		$('#endDate').html(data);
});
</script>
</head>
<body>
<form>
	<aside class="profile-card">
		<header>
			<!-- here’s the avatar -->
			<!-- <a target="_blank" href="#">  -->
			<img src="http://lorempixel.com/150/150/people/"
				class="hoverZoomLink">
			<!-- </a> -->
			<!-- the Title -->
			<h1><b>물 여덟잔 마시기</b></h1>
<b>핫브레이커</b>님
			<!-- START-END DATE  -->
			<h2><b> STARTDATE : </b> <span id="startDate"></span> <br>
				<b> ENDDATE : </b>  <span id="endDate"></span></h2>
		</header>
		<!-- challenge-content -->
		<div class="challenge-content">
			<!-- profile-bio -->
			<b>Category : </b> 독서<br>
			<b>Sharing : </b> ON
			<hr>
				<ul style="text-align: left">
					<li> <b>Day 1</b> 첫 날
					<li> <b>Day 2</b> 두번째 날
				</ul>
				<hr>
				<p><em>124명</em>이 응원합니당. </p>
		</div>
	</aside>
</form>
</body>
</html>