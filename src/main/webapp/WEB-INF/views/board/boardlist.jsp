<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
		style="float: left; width: 73%; margin-left: 10%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">
		<b>목 록</b>
		<p>
		<table border="1" width="650" cellpadding="2">
			<tr>
				<th width="10%">번 호</th>
				<th width="50%">제 목</th>
				<th width="15%">작성자</th>
				<th width="15%">작성일</th>
				<th width="10%">조회수</th>
			</tr>
			<c:forEach items="${boardList.list}" var="board">
				<tr>
					<td>${board.boardNo}</td>
					<td><a href="show_content.do?boardNo=${board.boardNo}">${board.boardTitle}</a></td>
					<td>${board.memberNo}</td>
					<td>${board.boardWriteDate}</td>
					<td>${board.boardHits}</td>
				</tr>
			</c:forEach>
		</table>
		<!-- 페이징! -->
					<c:set var="pb" value="${requestScope.boardList.pb}"></c:set>

					<c:if test="${pb.previousPageGroup}">
						<a href="boardlist.do?bpageNo=${pb.startPageOfPageGroup-1}">
							← </a>
					</c:if>



					<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
						end="${pb.endPageOfPageGroup}">
						<c:choose>
							<c:when test="${pb.nowPage!=i}">
								<a href="boardlist.do?bpageNo=${i}">${i}</a>
							</c:when>
							<c:otherwise>${i}</c:otherwise>
						</c:choose>&nbsp;
					</c:forEach>

					<c:if test="${requestScope.boardList.pb.nextPageGroup}">
						<a
							href="boardlist.do?bpageNo=${requestScope.boardList.pb.endPageOfPageGroup+1}">
							> </a>
					</c:if>
					
		<p>
			<tr>

				<td colspan="5"><a href="${path}/board/boardwrite.jsp">글 작성</a>
			</tr>
		</p>
	</div>
	
	<%@include file="../nav.jsp" %>
</body>
</html>





















