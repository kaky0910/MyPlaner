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

<!-- title -->
<script src="${path}/js/title.js"></script>
<link href="https://fonts.googleapis.com/css?family=Bangers"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/css/title.css">

<!-- title -->

<link href="https://fonts.googleapis.com/css?family=Cute+Font"
	rel="stylesheet">

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->


<style type="text/css">
hr {
	width: 100%;
}

body {
	background-color: #ECECEC;
	font-family: 'Cute Font', cursive;
}

a, h1, h2, label {
	color: #001E36;
}

h4 {
	color: #0F3347;
}
</style>
</head>
<body>
	<div id="titleArea"
		style="height: 70px; margin-top: 0px; margin-bottom: 0px;">
		<h1 class="row skew-title">
			<span>M</span><span class="last">Y</span> <span class="alt">P</span><span
				class="alt">L</span><span class="alt">A</span><span class="alt last">N</span><span
				class="alt">N</span><span class="alt">E</span><span class="alt">R</span>
		</h1>
	</div>
	<div id="contents"
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 40px; height: 760px">

		<div id="challengeCard" style="float: left; width: 40%">
			<div class="card"
				style="float: left; width: 335px; height: 500px; margin-top: 25%; margin-left: 22%;">
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
					<div class="challenge-content" style="font-size: 25px;">
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
		<div
			style="float: right; width: 56%; margin-left: 4%; margin-top: 4%;">
			<div id="userLog" style="height: 235px; margin-bottom: 10px;">
				<p style="font-size: 28px; text-align: left;">
					<b> <i>${challenge.memberNo} 님의 도전 로그입니다.</i></b>
				</p>
				<br>

				<c:forEach var="item" items="${challenge.challengeLogList}">
					<p style="text-align: left; font-size: 27px;">
						<b><i>${item.dayCount} 일차</i></b>
					</p>
					<p style="text-align: left; font-size: 22px;">${item.challengeLogContent}</p>
					<br>
				</c:forEach>

			</div>
			<hr>
			<div id="userContent" style="height: 235px; margin-bottom: 10px;">
				<p style="font-size: 28px; text-align: left;">
				<p style="font-size: 28px; text-align: left;">
					<b> <i>${challenge.memberNo} 님의 도전 세부사항입니다.</i></b>
				</p>
				<br>
				<ul style="text-align: left;">
					<c:forEach var="item" items="${challenge.challengeContentList}">
						<li><p style="font-size: 22px;">${item.challengeContent}
							</p></li>
						<br>
					</c:forEach>
				</ul>

			</div>
			<hr>
			<div id="comment" style="height: 235px; margin-top: 10px;">
				<p style="font-size: 28px; text-align: left;">
					<b> <i>댓글</i></b>
				</p>
				<br>
				<c:forEach var="item" items="${challenge.challengeCommentList}">
					<p style="float: left; font-size: 22px;">${item.challengeCommentMemberNo}
						: ${item.challengeComment}<p style="float: right">${item.challengeCommentWriteDate}</p></p>




					<br>
				</c:forEach>

			</div>
		</div>
	</div>
	<%@include file="../nav.jsp"%>
</body>
</html>