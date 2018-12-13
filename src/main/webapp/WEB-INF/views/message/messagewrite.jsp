<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<c:set var="path" value="${pageContext.request.contextPath}" />

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->

<title>Insert title here</title>

</head>
<body>
	<form action="${pageContext.request.contextPath}/sendMessage.do"
		method="post">
		<button>취소</button>
		<input type="submit" name="submit" value="보내기">
		<hr>
		받는 사람 : <input type="number" name="destinationMemberNo"> 제목 :
		<input type="text" name="messageTitle"> 내용 :
		<textarea name="messageContent" rows="4" cols="5"></textarea>
		<input type="hidden" name="senderMemberNo"
			value="${sessionScope.member.memberNo}">
	</form>
	<%@include file="../nav.jsp"%>
</body>
</html>