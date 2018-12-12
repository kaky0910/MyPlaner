<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link href="${path}/css/messagedetail.css" rel="stylesheet">
<link rel="stylesheet" href="${path}/css/button.css">
<link href="https://fonts.googleapis.com/css?family=Yeon+Sung"
	rel="stylesheet">

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css" href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->

<title>Insert title here</title>
</head>
<script type="text/javascript">
	$(function() {
		$('#deleteBtn').click(function() {
			if (confirm("정말로 삭제하시겠습니까?") == true)
				location.href = "deleteMessage.do?messageNo=" + $
			{
				requestScope.message.messageNo
			}
			;
		});//click
	});//ready
</script>
<body style="font-family: 'Yeon Sung', cursive;">
	<div id="title"
		style="height: 15%; margin-top: 5%; margin-bottom: 5%;">
		<h1 align="center" style="font-weight: bold; font-size: 3.2em;">MESSAGE</h1>
	</div>
	<div id="content"
		style="padding-left: 25%; padding-right: 25%; height: 50%; margin:0 auto;">
		<div class="card">
			<div class="tr"></div>
			<h2>${requestScope.message.messageTitle}</h2>
			<div class="tl"></div>
			<h3>${requestScope.message.senderMemberNo}</h3>
			<div class="br"></div>
			<h4>${requestScope.message.messageSendDate}</h4>
			<hr>
			<div class="bl"></div>
			<h4>${requestScope.message.messageContent}</h4>
			<br>
		</div>
	</div>
	<div id="button" class="row" style="height: 25%; padding-right:30%; padding-left:30%;">
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a
				href="${pageContext.request.contextPath}/messagewrite.jsp?destinationMemberNo=${requestScope.message.senderMemberNo}"
				class="btn btn-sm animated-button sandy-two">답장</a>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a id="deleteBtn" href="#"
				class="btn btn-sm animated-button sandy-two">삭제</a>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a href="#" class="btn btn-sm animated-button sandy-two"> 차단</a>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a href="${pageContext.request.contextPath}/messagewrite.jsp"
				class="btn btn-sm animated-button sandy-two">쪽지쓰기</a>
		</div>
		<div class="col-md-3 col-sm-3 col-xs-6">
			<a class="btn btn-sm animated-button sandy-two"
				href="getMessageList.do"> 받은 쪽지함 </a>
		</div>
	</div>
	<%@include file="../nav.jsp"%>
</body>
</html>