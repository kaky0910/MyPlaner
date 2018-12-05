<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
	function deleteBoard() {
		if (confirm("정말 삭제하시겠습니까?")) {
			location.href = "delete.do?no=${board.board_no}&&filename=${board.orgfilename}";
		}
	}

	function updateBoard() {
		if (confirm("정말 수정 하시겠습니까?")) {
			location.href = "update.do?no=${board.board_no}";
		}
	}
</script>
</head>
<body>
	<table cellpadding="5">
		<tr>
			<td>
				<table width="550">
					<tr>
						<td><b>글번호 : ${requestScope.board.boardNo} | 타이틀 :
								${requestScope.board.boardTitle}</b>
							<hr style="color: #6691BC; border-style: dotted; margin: 0">
						</td>
					</tr>
					<tr>
						<td>작성자 : ${requestScope.board.Member.name} | 작성일시 :
							${requestScope.board.baordWriteDate} Count : ${requestScope.board.boardHits}</td>
					</tr>
					<c:if test="${board.orgfilename!=null}">
						<tr>
							<td>Upload File Name : <a
								href="fileDown.do?filename=${board.orgfilename}">${board.orgfilename}</a></td>
						</tr>
						<tr>
					</c:if>
					<td>
						<hr style="color: #6691BC; margin: 0"> <pre>${requestScope.board.boardContent}</pre>
					</td>
					</tr>
					<tr>
						<td valign="middle"><a href="list.do"><img alt="전체글목록"
								src="./img/list_btn.jpg"></a> <!-- 로그인한 사람과 글쓴사람의 id가 같은 경우에만 보여지도록 조건 -->
							<c:if test="${requestScope.board.Member.id==sessionScope.member.id}">
								<img alt="삭제" src="./img/delete_btn.jpg" onclick="deleteBoard()">
								<img alt="수정" src="./img/modify_btn.jpg" onclick="updateBoard()">
							</c:if></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>






























