<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>목 록</b><p>
<%-- <form action="boardlist.jsp" method="post">
	<table border="1" cellpadding="0" cellspacing="0" width="700">
	<tr>
		<td align="right">
			<select name="searchCondition">
			<c:forEach items="${conditionMap}" var="option">
				<option value="${option.value }">${option.key }</option>
			</c:forEach>
			</select>
			<input name="searchKeyword" type="text" />
			<input type="submit" value="검색" />
		</td>
	</tr>
	</table>
	
	</form>
	<!-- 검색 종료 --> --%>

<table border="1" width="650" cellpadding="2">
	<tr>
		<th width="10%">번 호</th>
		<th width="50%">제 목</th>
		<th width="15%">작성자</th>
		<th width="15%">작성일</th>
		<th width="10%">조회수</th>
	</tr>
	<!-- @@@@@이 부분 반드시 수정 @@@@-->
	<c:forEach items="${lb}" var="board">
		<tr>
			<td>${board.boardNo}</td>
			<td><a href="show_content.do?no=${board.boardNo}">${board.boardTitle}</a></td>
			<td>${board.memberNo}</td>
			<td>${board.boardWriteDate}</td>
			<td>${board.boardHits}</td>		
		</tr>
	</c:forEach>
</table><p>
	<tr>

		<td colspan="5"><a href="./board/boardwrite.jsp">글 작성</a>
	</tr>

 <%-- <!-- 비로그인 사용자는 아래 버튼을 보여주지 않는다. -->
<c:if test="${sessionScope.mvo!=null}">
<a href="board/write.jsp"><img src="./img/write_btn.jpg" border="0"></a>

</c:if>

<!--@@@@@ 페이징 처리@@@@@@ -->
<br><br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<!-- 페이징 처리 -->	
	이전 페이지 그룹이 있으면 이미지 보여준다.
		  이미지 링크는 현 페이지 그룹 시작페이지 번호 -1 =>
		   이전 페이지 그룹의 마지막 페이지 번호로 한다. 
	
	 <c:if test="${requestScope.lvo.pagingBean.previousPageGroup}">
	 <a href=
	 "list.do?pageNo=${requestScope.lvo.pagingBean.
	 startPageOfPageGroup-1}"><img src="./img/left_arrow_btn.gif"></a>
	 </c:if>
	 &nbsp;&nbsp;
	PagingBean 을 이용해서 현재 페이지에 해당되는 페이지그룹의
		   시작페이지~~마지막페이지까지 화면에 보여준다. 
		   이 때 현재 페이지를 제외한 나머지 페이지는 링크를 걸어
		   해당 페이지에 대한 게시물 리스트 조회가 가능하도록 한다. 
		
	<c:forEach var="i" 
	begin="${requestScope.lvo.pagingBean.startPageOfPageGroup}"
	 end="${requestScope.lvo.pagingBean.endPageOfPageGroup}">
	 <c:choose>
	 <c:when test="${requestScope.lvo.pagingBean.nowPage!=i}">
	 <a href="list.do?pageNo=${i}">${i}</a>
	 </c:when>
	 <c:otherwise>
	${i}
	</c:otherwise>
	</c:choose>
	</c:forEach>	 
	&nbsp;&nbsp;
	다음 페이지 그룹이 있으면 화살표 이미지를 보여준다.
			이미지 링크는 현재 페이지 그룹의 마지막 번호 + 1 => 
			다음 그룹의 시작 페이지로 링크한다. 
			right_arrow_btn.gif
	
	 <c:if test="${requestScope.lvo.pagingBean.nextPageGroup}">
	 <a href=
	 "list.do?pageNo=${requestScope.lvo.pagingBean.
	 endPageOfPageGroup+1}">
	 <img src="./img/right_arrow_btn.gif">
	 </a>
	 </c:if>	   --%>
</body>
</html>





















