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

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->



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
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>
	<div id="searchNav"
		style="float: left; height: 800px; background-color: blue; margin-left: 5%; width: 13%; margin-top: 25px; padding: 10px;">
		<h2 align="center">검색</h2>
		<form>


			주제 <select name="challengeCategory">
				<option value="" selected disabled>선택하세요</option>
				<option value="게임">게임</option>
				<option value="독서">독서</option>
				<option value="다이어트">다이어트</option>
				<option value="생활습관">생활습관</option>
			</select> <br> 작성자 <input type="text" name="memberNo"> <br>
			제목 <input type="text" name="challengeTitle" value=""> <br>
			<input type="button" name="search" style="width: 100%;" value="검색">
		</form>
		<hr>
		<hr>
		<h2 align="center">정렬</h2>
		<a>최신순</a> <a>응원순</a> <a>기간순</a>
		<hr>
		<hr>
		<ul>
			<li>리스트형 보기
			<li>카드형 보기
		</ul>
		<hr>
	</div>
	<div id="contents"
		style="float: left; width: 61%; margin-left: 2%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">
		<h2 align="center">Challenge List</h2>
		<div id="here" style="display: inline;">
			<c:set var="i" value="0" />
			<c:set var="j" value="3" />
			<table border="1" align="center">
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
										width="110" height="110" draggable="false" />
								</div>
								<!-- Name -->
								<h2 id="challengeTitle" class="card-face__name">
									<b>${item.challengeTitle}</b>
								</h2>
								<!-- Title -->
								<span class="card-face__title"><b>${item.memberNo}</b></span>
								<div class="challenge-content">
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