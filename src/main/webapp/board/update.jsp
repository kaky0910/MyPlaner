<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function content_submit() {
		var f = document.write_form;
		if (f.title.value == "") {
			alert("제목을 입력하세요!");
			f.title.focus();
			return;
		}
		if (f.content.value == "") {
			alert("내용을 입력하세요!");
			f.content.focus();
			return;
		}
		f.submit();
	}
</script>
</head>
<font face="HY나무L" size="5"><strong>수정게시판 <br> <br></strong></font>
<form action="./updatego.do" method="get"
	name="write_form" enctype="multipart/form-data">

	<table cellpadding="5">
		<tr>
			<td>
				<table width="750">
					<tr>
						<td><b>글번호 : <input type="text" name="no"
								value="${requestScope.board.boardNo}" readonly="readonly"> |
								타이틀 : <input type="text" name="title"
								 value="${board.boardTitle}" >
								
						</b>
							<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<tr>
						<td>작성자 : <input type="text" name="name"
							value="${requestScope.board.memberNo}" readonly="readonly">
							| 작성일시 : <input type="text" name="writeDate"
							value="${requestScope.board.boardWriteDate}" readonly="readonly">
							Count : <input type="text" name="count"
							value="${requestScope.board.boardHits}" readonly="readonly"></b></td>
					</tr>
					<%-- <tr>
						<td><span id="uploadView"> <c:choose>
									<c:when test="${board.orgfilename!=null}">
										<b>${board.orefilename }</b>
									</c:when>
									<c:otherwise>
										<input type="file" name="uploadFile">
									</c:otherwise>
								</c:choose>
						</span></td>
					</tr> --%>
					<tr>
						<td><textarea cols="35" rows="30" width="50%" name="content">${board.boardContent}</textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2"><img src="./img/confirm.gif"
							onclick="content_submit()"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</html>