<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<SCRIPT LANGUAGE="JavaScript"> $(document).ready(function(){ 
	/* update 클릭 */ $('#update').on('click',function(){ 
		
	});
	/* 삭제 클릭 */ $('#delete').on('click',function(){ }); 
	}); 
	</script> 
	</head> 
	<body> 
	<table class="board_view"> 
	<colgroup> 
		<col width="15%"/> 
		<col width="35%"/> 
		<col width="15%"/> 
		<col width="35%"/> 
	</colgroup> 
	<caption style="background-color: #ccc">게시글 상세</caption> 
	<tbody> 
	<tr> 
	<th scope="row">글 번호</th> 
	<td>${list[0].boardNo }</td> 
	<th scope="row">조회수</th> 
	<td>${list[0].boardHits }</td> 
	</tr> 
	
	<tr> 
	<th scope="row">작성자</th> 
	<td>${list[0].nickname }</td> 
	<th scope="row">작성일</th> 
	<td>${board.boardWirteDate}</td> 
	</tr> 
	
	<tr> 
	<th scope="row">제목</th>
	<td colspan="3">${list[0].boardTitle }</td>
	</tr> 
	<tr> 
		<td colspan="4" style="border: 1px solid #ccc; height : 100px;">${listp[0].boardContent }</td>
		 </tr> 
		 </tbody> 
		 </table> 
		 <a href="#this" class="btn" id="update">수정하기</a> 
		 <a href="#this" class="btn" id="delete">삭제하기</a> 
		 </body> 
		 </html>
