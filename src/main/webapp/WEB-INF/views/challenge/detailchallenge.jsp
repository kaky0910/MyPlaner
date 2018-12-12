<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<c:set var="path" value="${pageContext.request.contextPath}" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/challengeCard.css">

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css" href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->

</head>
<body>
	<div id="titleArea"
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>
	<div id="contents"
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 40px; background-color: green; height: 760px">

		<div id="challengeCard" style="float:left; width: 40%">
			<div class="card" style="float:left; width: 335px; height: 500px; margin-top:25%; margin-left:22%;">
				<!-- Face 1 -->
				<div class="card-face face-1">
					<!-- Avatar -->
					<div class="card-face__avatar">
						<!-- User avatar -->
						<img src="https://image.flaticon.com/icons/svg/188/188241.svg"
							width="110" height="110" draggable="false" />
					</div>
					<!-- Name -->
					<h2 id="challengeTitle" class="card-face__name">
						<b>${challenge.challengeTitle}</b>
					</h2>
					<!-- Title -->
					<span class="card-face__title"><b>${challenge.memberNo}</b></span>
					<div class="challenge-content">
						<h4>
							<b> STARTDATE : </b> <span id="startDate">${challenge.challengeStartDate}</span>
							<br> <b> ENDDATE : </b> <span id="endDate">${challenge.challengeEndDate}</span>
						</h4>
						<b>Category : </b><label id="challengeCategory">
							${challenge.challengeCategory}</label><br> <b>Sharing : </b><label
							id="challengeSharing">${challenge.challengeSharing} </label>
						<hr>

						<hr>
						<em>${challenge.challengeLikes} 명</em>이 응원합니당.
					</div>
				</div>
			</div>
		</div>
		<div style="float:right; width: 56%; margin-left:4%;">
			<div id="userLog" style="height: 360px; margin-bottom:10px;background-color: pink;">

				<ul style="text-align: left">
					<li><b>dayCount</b> challengeLogContent
				</ul>

			</div>
			<div id="comment" style="height: 360px; margin-top:10px;background-color: pink;">
				<ul style="text-align: left">
					<li><b>comment 작성자 : </b> 코멘트 뾍
				</ul>
			</div>
		</div>
	</div>
	<%@include file="../nav.jsp" %>
</body>
</html>