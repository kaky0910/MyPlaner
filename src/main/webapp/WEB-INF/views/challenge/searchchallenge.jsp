<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('input[type=button]').click(function() {
			/* if (!memberNo)
				memberNo = "null";
			if (challengeTitle.equals == "")
				challengeTitle = "null"; */
		
			$.ajax({
				url : "searchChallenge.do",
				data : {
					"challengeCategory" : $('select[name=challengeCategory]').val(),
					"memberNo" : $('input[name=memberNo]').val(),
					"challengeTitle" : $('input[name=challengeTitle]').val()
				},
				success : function(data) {
					$('#here').html(data);
				}
			});
		});//click
	});//ready
</script>
</head>
<body>
	<div id="titleArea"
		style="height: 85px; background-color: gray; margin-top: 0px;">
		<p align="center" style="padding-top: 35px;">Title</p>
	</div>
	<div id="searchNav"
		style="float: left; height: 800px; background-color: blue; margin-left: 5%; width: 13%; margin-top: 25px; padding: 10px;">
		<h2 align="center">검색</h2>
		<form>
			주 제 <select name="challengeCategory">
				<option value="default">선택하세요</option>
				<option value="게임">게임</option>
				<option value="독서">독서</option>
				<option value="다이어트">다이어트</option>
				<option value="생활습관">생활습관</option>
			</select><br> 작성자 <input type="text" name="memberNo"> <br>
			제목 <input type="text" name="challengeTitle"> <br> <input
				type="button" name="search" style="width: 100%;" value="검색">
		</form>
		<hr>
		<hr>
		<h2 align="center">정렬</h2>
		<a>최신순</a> <a>응원순</a> <a>기간순</a>
		<hr>
		<hr>
		<ul>
			<li>리스트형 보기
			<li>카드형 보기
		</ul>
		<hr>
	</div>
	<div id="contents"
		style="float: left; width: 61%; margin-left: 2%; padding-right: 2%; margin-top: 25px; background-color: green; height: 800px">
		<h2 align="center">Challenge List</h2>
		<div id="here"></div>
		<hr>

	</div>
	<div id="navigater"
		style="float: right; width: 8%; margin-right: 5%; margin-top: 25px; margin-left: 2%; background-color: blue; height: 800px">
		여긴 네비게이터! 오른쪽 마진 5퍼 전체 길이 10퍼면 됩니다. navigator</div>
</body>
</html>