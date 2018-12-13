<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}" />

<div id="navigater" class="dropdown"
	style="float: right; position: fixed; right:0; width: 9%; margin-right: 5%; margin-top: 25px; height: 800px">
	<h1>메뉴</h1>
	<ul>
		<li data-value="#5790E6"><b><a style="text-decoration: none;"
				href="${path}/loadingDaily.do?memberNo=${sessionScope.member.memberNo}">메인페이지</a></b></li>

		<li data-value="#E884B0"><a href="getAllChallengeList.do"><b>챌린지게시판</b></a></li>
		<li data-value="#B27CD9"><a href="board.jsp"><b>게시판</b></a></li>
		<li data-value="#112F41"><b>마이페이지</b></li>

		<li data-value="#77C1F2"><a href="getMessageList.do?rpageNo=${requestScope.rpageNo }"><b>쪽지</b></a></li>
		<li data-value="#068587"><a href=""><b>내정보관리</b></a></li>
		<li data-value="#4FB99F"><b>챌린지</b></li>
	</ul>
</div>