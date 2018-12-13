<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

		<div class="content-2" style="left:5%;">
			<h2>About us</h2>
			<table border="1" id="sendTbl" style="left: 20%;">
				<thead>
					<tr>
						<td>글 번호</td>
						<td>받는 사람</td>
						<td width="400px;">제&nbsp;&nbsp;목</td>
						<td>보낸 날짜</td>
					</tr>
				</thead>
				<c:forEach var="item" items="${sendList.list}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${item.destinationMemberNo}</td>
						<td><a href="getMessage.do?messageNo=${item.messageNo}">${item.messageTitle}</a></td>
						<td>${item.messageSendDate}</td>
					</tr>
				</c:forEach>
			</table>
			<c:set var="pb" value="${requestScope.sendList.pb}"></c:set>

			<c:if test="${pb.previousPageGroup}">
				<a href="getSendMessageList.do?spageNo=${pb.startPageOfPageGroup-1}">
					← </a>
			</c:if>



			<c:forEach var="i" begin="${pb.startPageOfPageGroup}"
				end="${pb.endPageOfPageGroup}">
				<c:choose>
					<c:when test="${pb.nowPage!=i}">
						<a href="getSendMessageList.do?spageNo=${i}">${i}</a>
					</c:when>
					<c:otherwise>${i}</c:otherwise>
				</c:choose>&nbsp;
							</c:forEach>


			<c:if test="${requestScope.sendList.pb.nextPageGroup}">
				<a
					href="getSendMessageList.do?spageNo=${requestScope.sendList.pb.endPageOfPageGroup+1}">
					> </a>
			</c:if>
		</div>
		<!-- content2 -->
		