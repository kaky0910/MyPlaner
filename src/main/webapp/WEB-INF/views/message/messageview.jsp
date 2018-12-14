<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<!-- title -->
<link href="https://fonts.googleapis.com/css?family=Bangers"
	rel="stylesheet">
<link rel="stylesheet" href="${path}/css/title.css">
<script src="${path}/js/title.js"></script>
<!-- title -->

<!-- nav start-->
<link rel="stylesheet" href="${path}/css/nav.css">
<link rel="stylesheet/less" type="text/css"
	href="${path}/less/style.less">
<script src="//cdnjs.cloudflare.com/ajax/libs/less.js/3.9.0/less.min.js"></script>
<script src="${path}/js/nav.js"></script>

<!-- nav end-->

<link href="https://fonts.googleapis.com/css?family=Cute+Font"
	rel="stylesheet">

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
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">

		<a href="getMessageList.do">목록</a> 받은 쪽지함&nbsp;&nbsp;&nbsp;<a
			href="${pageContext.request.contextPath}/messagewrite.jsp">쪽지쓰기</a>
		<hr>
		<a
			href="${pageContext.request.contextPath}/messagewrite.jsp?destinationMemberNo=${requestScope.message.senderMessageNo}">답장하기</a><br>
		<a id="deleteBtn" href="#">삭제하기</a><br> <a href="#">차단</a><br>
		제목 : ${requestScope.message.messageTitle} 보낸 사람 :
		${requestScope.message.senderMemberNo} 받은 시간 :
		${requestScope.message.messageSendDate} 내용 :
		${requestScope.message.messageContent}
	</div>
	<%@include file="../nav.jsp"%>

</body>
</html>