<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="here" style="display: inline; margin-top: 35px;">
			<c:set var="i" value="0" />
			<c:set var="j" value="3" />
			<table border="1" style="margin-left: 10%; margin-top: 35px;">

				<c:forEach var="item" items="${challengeList}">
					<c:if test="${i%j == 0 }">
						<tr>
					</c:if>
					<td style="margin-left: 30%; margin-top: 20%;">
						<div class="card"
							style="width: 300px; height: 370px; text-align: center;">
							<!-- Face 1 -->
							<div class="card-face face-1">
								<!-- Avatar -->
								<div class="card-face__avatar">
									<!-- User avatar -->
									<img src="https://image.flaticon.com/icons/svg/188/188241.svg"
										width="80" height="80" draggable="false" />
								</div>
								<!-- Name -->
								<h2 id="challengeTitle" class="card-face__name">
									<b>${item.challengeTitle}</b>
								</h2>
								<!-- Title -->
								<span class="card-face__title"><b>${item.memberNo}</b></span>
								<div class="challenge-content" style="font-size: 16px;">
									<h4>
										<b> STARTDATE : </b> <span id="startDate">${item.challengeStartDate}</span>
										<br> <b> ENDDATE : </b> <span id="endDate">${item.challengeEndDate}</span>
									</h4>
									<b>Category : </b><label id="challengeCategory">
										${item.challengeCategory}</label><br> <b>Sharing : </b><label
										id="challengeSharing"> ${item.challengeSharing}</label>
									<hr>
									<ul style="text-align: left">
										<c:forEach var="challengeLogList"
											items="${item.challengeLogList}">
											<li><b>Day ${item.dayCount}</b>
												${item.challengeLogContent}
										</c:forEach>
									</ul>
									<em>${item.challengeLikes}명</em>이 응원합니당.
								</div>
							</div>
						</div>
					</td>
					<c:if test="${i%j == j-1 }">
						</tr>
					</c:if>
					<c:set var="i" value="${i+1 }" />
				</c:forEach>
			</table>
		</div>