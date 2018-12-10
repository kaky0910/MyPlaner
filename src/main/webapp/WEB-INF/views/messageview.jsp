<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){
	$('#deleteBtn').click(function(){
		if(confirm("정말로 삭제하시겠습니까?")==true)
			location.href="deleteMessage.do?messageNo="+${requestScope.message.messageNo};
	});//click
});//ready
</script>
<body>
<a href="getMessageList.do">목록</a>
받은 쪽지함&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/messagewrite.jsp">쪽지쓰기</a>
<hr>
<a href="${pageContext.request.contextPath}/messagewrite.jsp?destinationMemberNo=${requestScope.message.senderMessageNo}">답장하기</a><br>
<a id="deleteBtn" href="#">삭제하기</a><br>
<a href="#">차단</a><br>
제목 : ${requestScope.message.messageTitle}
보낸 사람 : ${requestScope.message.senderMemberNo}
받은 시간 : ${requestScope.message.messageSendDate}
내용 : ${requestScope.message.messageContent}
</body>
</html>