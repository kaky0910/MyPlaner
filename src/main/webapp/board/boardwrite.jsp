<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function content_submit(){
	var f=document.write_form;
	if(f.title.value==""){
		alert("제목을 입력하세요!");
		f.title.focus();
		return; 
	}	
	if(f.content.value==""){
		alert("내용을 입력하세요!");
		f.content.focus();
		return;
	}
	f.submit();
}
</script>
</head>
	<font face="HY나무L" size="5"><strong>게시판 글쓰기 <br><br></strong></font>
	<form action="${pageContext.request.contextPath}/write.do" method="post" name="write_form" enctype="multipart/form-data">
  			<!-- ${pageContext.request.contextPath} : 하면 '../' 안해도 자동으로 잡힌다. (저거 자체가 webapp로 기억..)-->
  
		<table>
			<tr>
				<td>제목<input type="text" name="title" maxlength="100" size="50"></td>
		    </tr>
		    
		    <tr>
				<td><textarea cols="75" rows="25" name="content"></textarea></td>
		    </tr> 
		    
		     <tr>
				<td><input type="file" name="uploadFile"></td>
		    </tr>
		    
		    <tr>
				<td colspan="2"><img src="../img/confirm.gif"  onclick="content_submit()"></td>  
		    </tr>
		    
		</table>
	</form>
</html>