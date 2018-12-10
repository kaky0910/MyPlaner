<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#recvtn').click(function() {
			$('#recvTbl').css('display', 'inline');
			$('#sendTbl').css('display', 'none');
		});//click

		$('#sendBtn').click(function() {
			$('#recvTbl').css('display', 'none');
			$('#sendTbl').css('display', 'inline');
		});//click
	});//ready
</script>
</head>
<body>
	<button id="recvBtn">받은 쪽지함</button>
	<button id="sendBtn">보낸 쪽지함</button>
	<a href="messagewrite.jsp">작성하기</a>
	<button>삭&nbsp;&nbsp;제</button>
	
	<div>
		<table border="1" id="recvTbl">
			<thead>
				<tr>
					<td>글 번호</td>
					<td>보낸 사람</td>
					<td>제&nbsp;&nbsp;목</td>
					<td>보낸 날짜</td>
					<td>읽음 여부</td>
				</tr>
			</thead>
			<c:forEach var="item" items="${recvList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${item.senderMemberNo}</td>
					<td><a href="getMessage.do?messageNo=${item.messageNo}">${item.messageTitle}</a></td>
					<td>${item.messageSendDate}</td>
					<td>${item.check}</td>
				</tr>
			</c:forEach>
		</table>

		<table border="1" id="sendTbl" style="display:none">
			<thead>
				<tr>
					<td>글 번호</td>
					<td>받는 사람</td>
					<td>제&nbsp;&nbsp;목</td>
					<td>보낸 날짜</td>
				</tr>
			</thead>
			<c:forEach var="item" items="${sendList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${item.destinationMemberNo}</td>
					<td><a href="getMessage.do?messageNo=${item.messageNo}">${item.messageTitle}</a></td>
					<td>${item.messageSendDate}</td>
				</tr>
			</c:forEach>
		</table>
	</div>


</body>
</html>