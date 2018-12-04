<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<c:set var="path" value="${pageContext.request.contextPath}" />

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="${path}/css/message.css">
<script src="${path}/js/message.js"></script>
<!-- <script type="text/javascript">
	$(function() {
		var card = document.querySelector(".card");
		var playing = false;

		card.click(function() {
			if (playing)
				return;

			playing = true;
			anime({
				targets : card,
				scale : [ {
					value : 1
				}, {
					value : 1.4
				}, {
					value : 1,
					delay : 250
				} ],
				rotateY : {
					value : '+=180',
					delay : 200
				},
				easing : 'easeInOutSine',
				duration : 400,
				complete : function(anim) {
					playing = false;
				}
			});
		});

	});//ready
</script> -->
</head>
<body>
	<div class="card-container">
		<div class="card">
			<div class="front">A</div>
			<div class="back">B</div>
		</div>
	</div>
</body>
</html>