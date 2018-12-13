<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Animated Content Tabs with CSS3</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/message.css" />
<link rel="stylesheet" type="text/css" href="css/messagetable.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript" src="js/message.js"></script>

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>
<!-- nav end-->


<link
	href='http://fonts.googleapis.com/css?family=Open+Sans+Condensed:700,300,300italic'
	rel='stylesheet' type='text/css'>
<script type="text/javascript">
	$(function() {
		$('#tab-1').click(function() {
			location.href = "${path}/getMessageList.do";
		});//click

		$('#tab-2').click(function() {
			$.ajax({
				url : "${path}/getSendMessageList.do",
				success : function(result) {
					$('.content').html(result);
				}
			});//ajax
		});//click

	}); //ready
</script>
</head>
<body>
	<div id="titleArea"
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>

	<div id="contents" class="container"
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">

		<section class="tabs">
			<input id="tab-1" type="radio" name="radio-set"
				class="tab-selector-1" checked="checked" /> <label for="tab-1"
				class="tab-label-1">Receive</label> <input id="tab-2" type="radio"
				name="radio-set" class="tab-selector-2" /> <label for="tab-2"
				class="tab-label-2">Send</label>

			<div class="clear-shadow"></div>

			<div class="content">
				<div class="content-1">
					<h2>About us</h2>
					<table border="1" id="recvTbl" style="left: 20%;">
						<thead>
							<tr>
								<td>글 번호</td>
								<td>보낸 사람</td>
								<td width="400px;">제&nbsp;&nbsp;목</td>
								<td>보낸 날짜</td>
								<td>읽음 여부</td>
							</tr>
						</thead>
						<c:forEach var="item" items="${recvList.list}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${item.senderMemberNo}</td>
								<td><a href="getMessage.do?messageNo=${item.messageNo}">${item.messageTitle}</a></td>
								<td>${item.messageSendDate}</td>
								<td>${item.check}</td>
							</tr>
						</c:forEach>
					</table>
					<!-- 페이징! -->
					<c:set var="pb" value="${requestScope.recvList.pb}"></c:set>

					<c:if test="${pb.previousPageGroup}">
						<a href="getMessageList.do?rpageNo=${pb.startPageOfPageGroup-1}">
							← </a>
					</c:if>



					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<a href="getMessageList.do?rpageNo=${i}">${i}</a>
							</c:when>
							<c:otherwise>${i}</c:otherwise>
						</c:choose>&nbsp;
							</c:forEach>

					<c:if test="${requestScope.recvList.pb.nextPageGroup}">
						<a
							href="getMessageList.do?rpageNo=${requestScope.recvList.pb.endPageOfPageGroup+1}">
							> </a>
					</c:if>
				</div>
			</div>
			<!-- content -->
		</section>
	</div>
	<%@include file="../nav.jsp"%>
</body>
</html>