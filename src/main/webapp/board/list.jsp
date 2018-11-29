<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="board" items="${boardList}" varStatus="loop">
			<tr>
				<td>${board.seq}</td>
				<td><a href="<c:url value="/board/read/${ board.seq }" />">
				${board.boardTitle}</a></td>
				<td>${board.writer}</td>
				<td>${board.boardWriteDate}</td>
				<td>${board.Hits}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="<c:url value="/board/write" />">새글</a>
</body>
</html>