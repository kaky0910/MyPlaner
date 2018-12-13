<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">

<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
</head>
<body>
	<div id="titleArea"
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>
	<div id="contents"
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">
		여기에 내용 넣어주세여 이 div는 왼쪽 마진 10%, 오른쪽 패딩 2퍼 포함 가로 전체 길이 75퍼면 됩니당. 높이는
		바꾸시면 네비게이터도 바꿔주세여</div>
	
	<div id="navigater" class="dropdown"
		style="position;float: right; width: 9%; margin-right: 5%; margin-top: 25px; background-color: blue; height: 800px">
		<h1>메뉴를 선택</h1>
		<ul>
			<li data-value="#5790E6"><b><a style="text-decoration: none;"
					href="${path}/loadingDaily.do?memberNo=${sessionScope.member.memberNo}">메인페이지</a></b></li>

			<li data-value="#E884B0"><b>챌린지게시판</b></li>
			<li data-value="#B27CD9"><b>게시판</b></li>
			<li data-value="#112F41"><b>마이페이지</b></li>

			<li data-value="#77C1F2"><b>쪽지</b></li>
			<li data-value="#068587"><b>내정보관리</b></li>
			<li data-value="#4FB99F"><b>챌린지</b></li>
		</ul>
	</div>
	
</body>
</html>