<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
    <head>
        <title>게시판</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
       <!--  <script src="//cdn.ckeditor.com/4.7.1/standard/ckeditor.js"></script> -->
      
    
    </head>
    <font face="HY나무L" size="5"><strong>게시판 수정 페이지 <br><br></strong></font>
    <body>
    	<input type="hidden" id="board_id" name="board_id" value="${boardView.id}" />
    	<div align="center">
    		</br>
    		</br>
   			<table width="1200px">
   				<tr>
   					<td>
   						제목: <input type="text" id="subject" name="subject" style="width:300px;" placeholder="제목" value="${boardView.subject}"/>
   						(작성자이거는 자동으로찍히게해야겠지): <input type="text" id="writer" name="writer" style="width:130px;" maxlength="10" value="${boardView.writer}"/>
   						비밀번호: <input type="password" id="password" name="password" style="width:130px;" maxlength="10" placeholder="패스워드"/>						
   					</td>
   				</tr>
   				<tr>
   					<td>
   						<textarea name="content" id="content" rows="30" cols="110">${boardView.content}</textarea>
   						<tr>
				<td><input type="file" name="uploadFile"></td>
		    </tr>
		    
		    <tr>
				<td colspan="2"><img src="../img/confirm.gif"  onclick="content_submit()"></td>  
		    </tr>
		   <!--  <tr>
		    <td>
		    
   						<button id="list" name="list">목록</button>
   						<button id="save" name="save">저장</button><p>
   					</td>
   				</tr> -->
   				
   			</table>
    	</div>
    </body>
</html>