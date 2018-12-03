<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>상세보기</title>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
    <table class="board_view">
        <caption>상세보기</caption>
        <colgroup>
            <col width="15%">
            <col width="35%">
            <col width="15%">
            <col width="*">
        </colgroup>
         
        <tbody>
            <tr>
                <th>제목</th>
                <td>${board.boardTitle}</td>
                <th>조회수</th>
                <td>${board.boardHits}</td>
            </tr>
            <tr>
                <th>작성자</th>
                <td>${board.nickname}</td>
                <th>작성일</th>
                <td>${board.boardWriteDate}</td>
            </tr>
            <tr>
                <th>내용</th>
                <td colspan="3">
                    ${board.boardContent}
                </td>
            </tr>
        </tbody>
    </table>
    <a href="#this" id="list" class="btn">목록으로</a>
    <a href="#this" id="update" class="btn">수정하기</a>
    <a href="#this" id="delete" class="btn" >삭제하기</a> 
    <%@ include file="/WEB-INF/include/include-body.jspf" %>
     
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click",function(e){
                e.preventDefault();
                fn_openBoardList();
            })
            $("#modify").on("click",function(e){
                e.preventDefault();
                fn_openBoardModify();
            })
        })
         
        function fn_boardlist(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/boardlist.do'/>");
            comSubmit.submit();
        }
        function fn_boardupdate(){
            var idx = "${board.nickname}";
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/board/boardupdate.do'/>");
            comSubmit.addParam("nickname",nickname);
            comSubmit.submit();
        }
    </script> 
</body>
</html>