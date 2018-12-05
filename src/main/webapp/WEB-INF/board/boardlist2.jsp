<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- 본문 시작 -->
<div id="content-categories">Eclipse &gt;자유 게시판</div>

<table class="bbs-table">
<!--  게시판 목록 머리말 -->
<tr>
    <th>NO</th>
    <th>TITLE</th>
    <th>DATE</th>
    <th>HIT</th>
</tr>
<!--  반복 구간 시작 -->
<tr>
    <td>11</td> <!--번호-->
    <td>
        <a href="#">제목</a>
        <!--첨부 파일이 있으면 표시-->
        <img src="images/attach.png" alt="첨부 파일" />
        <!--댓글 개수표시-->
        [5] 
        </td>
        <td>2011.11.15</td> <!--등록일-->
        <td>4555</td> <!--조회 수-->
</tr>
<!--  반복 구간 끝 -->             
</table>
<div id="paging">
    <a href="#">[이전]</a>
    <span class="bbs-strong">6</span> <!--현재 페이지-->
    <a href="#">[7]</a>
    <a href="#">[8]</a>
    <a href="#">[9]</a>
    <a href="#">[10]</a>
    <a href="#">[다음]</a>
</div>
<div id="list-menu">
    <input type="button" value="새 글쓰기" />
</div>
<div id="search">
    <form method="get">
    <p style="margin: 0;padding: 0;" >
        <input type="hidden" name="curPage" value="1" />
        <input type="hidden" name="boardCd" value="free" />
        <div>
            <input type="text" name="searchWord" size="15" maxlength="30" />
            <input type="submit" value="검색" />
        </div>
    </p>
    </form>
</div>
<!--  본문 끝 -->
</head>
<body>

</body>
</html>