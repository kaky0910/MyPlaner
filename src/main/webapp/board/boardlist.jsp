<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
    <head>
        <title>게시판목록</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.js"></script>
    
        <style>
        	.mouseOverHighlight {
				   border-bottom: 1px solid blue;
				   cursor: pointer !important;
				   color: blue;
				   pointer-events: auto;
				}
        </style>
    </head>
    <body>
    	<form class="form-inline" id="frmSearch" action="/board/list">
	   <!--  	<input type="hidden" id="startPage" name="startPage" value="">페이징을 위한 hidden타입 추가
	        <input type="hidden" id="visiblePages" name="visiblePages" value="">페이징을 위한 hidden타입 추가 -->
	    	<div align="center"><h3>게시판목록</h3>
	    	
	    		<table border="1" width="1200px">
	    			<tr>
	    				<th width="50px">
	    					번호
	    				</th>
	    				<th width="850px">
	    					제목<!--  a태그로 떄려넣기 -->
	    				</th>
	    				<th width="100px">
	    					작성자
	    				</th>
	    				<th width="200px">
	    					작성일
	    				</th>
	    				<th width="200px">
	    					조회수
	    				</th>
	    			</tr>
	    			<c:choose>
			        	<c:when test="${fn:length(boardList) == 0}">
			            	<tr>
			            		<td colspan="5" align="center">
			            			아직 없지롱 
			            		</td>
			            	</tr>
			            		<table width="1200px">
	    			<tr>
	    				<td align="right">
	    					<button type="button" id="write" name="write">글 작성</button>
	    				</td>
	    			</tr>
	    		</table>			            	
			           	</c:when>			           	
			           	<c:otherwise>
			            	<c:forEach var="boardList" items="${boardList}" varStatus="status">
								<tr>
						    		<td align="center">${boardList.nickname}</td>
						    		<td>
						    			<a name="nickname" class="mouseOverHighlight" content_id="${boardList.nickname}">${boardList.boardTitle}</a>
						    		</td>
						    		<td align="center">${boardList.nickname}</td>
						    		<td align="center">${boardList.boardWriterDate}</td>
						    	</tr>
						    </c:forEach>
			           	</c:otherwise> 
			    	</c:choose>
	    		</table>
	    		<br>
	    	</div>
    	</form>
    </body>
</html>