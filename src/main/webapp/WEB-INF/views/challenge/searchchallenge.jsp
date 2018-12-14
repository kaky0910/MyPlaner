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

<link href="https://fonts.googleapis.com/css?family=Cute+Font" rel="stylesheet">

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->


<!-- title -->
<link href="https://fonts.googleapis.com/css?family=Bangers"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/css/title.css">
<script src="${path}/js/title.js"></script>
<!-- title -->

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


<script type="text/javascript">
	$(function() {
		$('input[type=button]').click(
				function() {
					$.ajax({
						url : "searchChallenge.do",
						cache : false,
						data : {
							"memberNo" : 100 + $('input[name=memberNo]').val(),
							"challengeCategory" : 100 + $(
									'select[name=challengeCategory]').val(),
							"challengeTitle" : 100 + $(
									'input[name=challengeTitle]').val()
						},
						success : function(data) {
							$('#here').html(data + "<br>");
							alert(data);
						}
					});
				});//click
	});//ready
</script>
</head>

<!-- challengeList로 getAllChallengeList() ... 바인딩 -->
<body>
	<div id="titleArea"
		style="height: 70px; margin-top: 0px; margin-bottom: 0px;">
		<h1 class="row skew-title">
			<span >M</span><span class="last">Y</span><span class="alt">P</span><span
				class="alt">L</span><span class="alt">A</span><span class="alt last">N</span><span
				class="alt">N</span><span class="alt">E</span><span class="alt">R</span>
		</h1>
	</div>
	<div id="searchNav"
		style="background-color: #BDD3DE; position: fixed; float: left; height: auto; margin-left: 10%; width: 13%; margin-top: 160px; padding: 10px; text-align: left;">
		<h2 align="center" style="font-size: 26px; color: #15317F;">검색</h2>
		<form>
			<strong style="font-size: 23px;">주제 </strong> <select
				name="challengeCategory" style="height: 25px;">
				<option value="" selected disabled>선택하세요</option>
				<option value="게임">게임</option>
				<option value="독서">독서</option>
				<option value="다이어트">다이어트</option>
				<option value="생활습관">생활습관</option>
			</select> <br> <br> <strong style="font-size: 23px;">작성자</strong> <input
				type="text" name="memberNo" style="height: 25px;"> <br>
			<br> <strong style="font-size: 23px;">제목 </strong><input
				type="text" name="challengeTitle" value="" style="height: 25px;">
			<br> <br> <input type="button" name="search"
				style="width: 100%; height: 25px;" value="검색">
		</form>
		<br> <br> <br>
		<h2 align="center">
			<strong style="font-size: 26px; color: #15317F;">정렬</strong>
		</h2>
		<p style="font-size: 20px;">
			<a>응원순</a> <a>기간순</a>
		</p>
		<br> <br>
		<h2 align="center">
			<strong style="font-size: 26px; color: #15317F;">보기</strong>
		</h2>
		<a href="#" style="text-decoration: none; font-size: 20px;">리스트형
			보기</a> <a href="#" style="text-decoration: none; font-size: 20px;">카드형
			보기</a>
		<hr>
	</div>
	<div id="contents"
		style="float: left; width: 61%; margin-left: 25%; padding-right: 2%; margin-top: 105px; height: 800px">
		<h2 align="center" style="font-size: 60px;">
			<i><b>Challenge List</b></i>
		</h2>

		<div id="here" style="display: inline; margin-top: 35px;">
			<c:set var="i" value="0" />
			<c:set var="j" value="3" />
			<table border="1" style="margin-left: 10%; margin-top: 35px;">

				<c:forEach var="item" items="${challengeList}">
					<c:if test="${i%j == 0 }">
						<tr>
					</c:if>
					<td style="margin-left: 30%; margin-top: 20%;">
						<div class="card"
							style="width: 300px; height: 370px; text-align: center;">
							<!-- Face 1 -->
							<div class="card-face face-1">
								<!-- Avatar -->
								<div class="card-face__avatar">
									<!-- User avatar -->
									<img src="https://image.flaticon.com/icons/svg/188/188241.svg"
										width="80" height="80" draggable="false" />
								</div>
								<!-- Name -->
								<h2 id="challengeTitle" class="card-face__name">
									<b>${item.challengeTitle}</b>
								</h2>
								<!-- Title -->
								<span class="card-face__title"><b>${item.memberNo}</b></span>
								<div class="challenge-content" style="font-size: 16px;">
									<h4>
										<b> STARTDATE : </b> <span id="startDate">${item.challengeStartDate}</span>
										<br> <b> ENDDATE : </b> <span id="endDate">${item.challengeEndDate}</span>
									</h4>
									<b>Category : </b><label id="challengeCategory">
										${item.challengeCategory}</label><br> <b>Sharing : </b><label
										id="challengeSharing"> ${item.challengeSharing}</label>
									<hr>
									<ul style="text-align: left">
										<c:forEach var="challengeLogList"
											items="${item.challengeLogList}">
											<li><b>Day ${item.dayCount}</b>
												${item.challengeLogContent}
										</c:forEach>
									</ul>
									<em>${item.challengeLikes}명</em>이 응원합니당.
								</div>
							</div>
						</div>
					</td>
					<c:if test="${i%j == j-1 }">
						</tr>
					</c:if>
					<c:set var="i" value="${i+1 }" />
				</c:forEach>
			</table>
		</div>
		<hr>
	</div>
	<%@include file="../nav.jsp"%>
</body>
</html>