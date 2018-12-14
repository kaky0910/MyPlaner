<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<c:set var="path" value="${pageContext.request.contextPath}" />
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


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function deleteBoard() {
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/delete.do?boardNo=${board.boardNo}";// 중복 ??
		}
	}

	function updateBoard() {
		if (confirm("정말 수정 하시겠습니까?")) {
			location.href = "${pageContext.request.contextPath}/update.do?boardNo=${board.boardNo}";
		}
	}
</script>
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
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 4%; background-color: green; height: 800px">
		<table cellpadding="5">
			<tr>
				<td>
					<table width="550" style="font-size: 16px;">

						<tr>
							<td valign="left"><a href="boardlist.do"><img
									alt="전체글목록" src="./img/list_btn.jpg"></a> <!-- 로그인한 사람과 글쓴사람의 id가 같은 경우에만 보여지도록 조건 -->
								<%-- <c:if test="${requestScope.board.memberVO.id==sessionScope.mvo.id}"> --%>
								<img alt="삭제" src="./img/delete_btn.jpg" onclick="deleteBoard()">
								<img alt="수정" src="./img/modify_btn.jpg" onclick="updateBoard()">
								<%-- </c:if> --%></td>
						</tr>

						<tr></tr>
						<tr>
							<td><b>글번호 : ${requestScope.board.boardNo} | 타이틀 :
									${requestScope.board.boardTitle}</b>
								<hr style="color: #6691BC; border-style: dotted; margin: 0">
							</td>
						</tr>
						<tr>
							<td>작성자 : ${requestScope.board.memberNo} | 작성일시 :
								${requestScope.board.boardWriteDate} 조회수 :
								${requestScope.board.boardHits}</td>
						</tr>

						<tr>
							<td>
								<hr style="color: #6691BC; margin: 20"> <pre> 내용 : ${requestScope.board.boardContent}</pre>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<br><br>
		<div style="height: 2px; background-color: black; width: 800px;"></div>
<br><br>
		<div id="boardComment"
			style="width: 650px; margin-left: 15px; font-size: 20px;">
			<c:forEach var="item" items="${board.boardCommentList}">
				<b>${item.boardCommentMemberNo}</b> ${item.boardComment} &nbsp;&nbsp; ${item.boardCommentWriteDate} <br>
			</c:forEach>
		</div>

		<div style="width: 650px; text-align: center;">
			<br>
			<!-- 로그인 한 놈만 댓글작성보이게 -->
			<%-- <c:if test="${requestScope.memberNo !=null}"> --%>
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해라"></textarea>
			<br>
			<!-- 비밀댓글??? -->
			<!-- <input type="checkbox" id="secretReply">비밀 댓글 -->
			<button type="button" id="btnReply" onclick="">댓글 작성</button>
			<%-- </c:if> --%>
			<hr>
		</div>
		<div id="listReply"></div>
	</div>

	<%@include file="../nav.jsp"%>

</body>
</html>






