<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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

<script type="text/javascript">
	function content_submit() {
		var f = document.write_form;
		if (f.boardTitle.value == "") {
			alert("제목을 입력하세요!");
			f.title.focus();
			return;
		}
		if (f.boardContent.value == "") {
			alert("내용을 입력하세요!");
			f.content.focus();
			return;
		}
		f.submit();
	}
</script>
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
	<font face="HY나무L" size="5"><strong>글쓰기 <br>
		<br></strong></font>
	<form action="../boardwrite.do" method="post" name="write_form"
		enctype="multipart/form-data">
		<!-- ${pageContext.request.contextPath} : 하면 '../' 안해도 자동으로 잡힌다. (저거 자체가 webapp로 기억..)-->

		<table>
			<tr>
				<td>제목<input type="text" name="boardTitle" size="30"></td>
			</tr>

			<tr>
				<td colspan="2"><textarea cols="35" rows="20"
						name="boardContent"></textarea></td>
			</tr>

			<tr>
				<td><input type="file" name="uploadFile"></td>
			</tr>
			<tr>
				<td colspan="2"><img src="../img/confirm.gif"
					onclick="content_submit()" style="cursor: pointer;"></td>
			</tr>
		</table>
	</form>
</body>
</html>