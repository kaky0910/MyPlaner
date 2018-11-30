<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/challengeCard.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/switch.css">
<script type="text/javascript">

<!-- 오늘 날짜 받아오기 -->
$(function(){
		var d = new Date();
		var data = d.getFullYear() + "-" +(d.getMonth() + 1) + "-"+ d.getDate();
		$('#startDate').attr('value',data);		
		$('#endDate').attr('value',data);
	
});<!-- 오늘 날짜 받아오기 -->





<!-- 항목추가 -->
<script type="text/javascript">
$(document).ready(function(){
    // 옵션추가 버튼 클릭시
    $("#addItemBtn").click(function(){
        // item 의 최대번호 구하기
        var lastItemNo = $("#example tr:last").attr("class").replace("item", "");

        var newitem = $("#example tr:eq(1)").clone();
        newitem.removeClass();
        newitem.find("td:eq(0)").attr("rowspan", "1");
        newitem.addClass("item"+(parseInt(lastItemNo)+1));

        $("#example").append(newitem);
    });

    // 항목추가 버튼 클릭시
    $(".addBtn").live("click", function(){
        var clickedRow = $(this).parent().parent();
        var cls = clickedRow.attr("class");

        // tr 복사해서 마지막에 추가
        var newrow = clickedRow.clone();
        newrow.find("td:eq(0)").remove();
        newrow.insertAfter($("#example ."+cls+":last"));

        // rowspan 조정
        resizeRowspan(cls);
    });
     
    // 삭제버튼 클릭시
    $(".delBtn").live("click", function(){
        var clickedRow = $(this).parent().parent();
        var cls = clickedRow.attr("class");
         
        // 각 항목의 첫번째 row를 삭제한 경우 다음 row에 td 하나를 추가해 준다.
        if( clickedRow.find("td:eq(0)").attr("rowspan") ){
            if( clickedRow.next().hasClass(cls) ){
                clickedRow.next().prepend(clickedRow.find("td:eq(0)"));
            }
        }

        clickedRow.remove();

        // rowspan 조정
        resizeRowspan(cls);
    });

    // cls : rowspan 을 조정할 class ex) item1, item2, ...
    function resizeRowspan(cls){
        var rowspan = $("."+cls).length;
        $("."+cls+":first td:eq(0)").attr("rowspan", rowspan);
    }
});
</script><!-- 항목추가 -->

</head>
<body >
<form>
	<aside class="profile-card">
		<header style="padding-top: 60px; padding-bottom: 20px;">
			<input type="text" name="title" value="도전 제목을 입력해주세요" style="height: 25px; font-weight: 150; font: bold;">
		</header>
			<!-- and role or location -->
		
		<!-- bit of a bio; who are you? -->
		<div class="challenge-content">
			<!-- profile-bio -->
			<b>Category</b> &nbsp;&nbsp;&nbsp;
			<select>
					<option value="readBook">독서</option>
					<option value="life">생활 습관</option>
					<option value="diet">식이요법</option>
				 </select><br><br><hr><br>
			<b>STARTDATE : </b><input type="date" name="startDate" id="startDate"><br>
			<b>ENDDATE : </b><input type="date" name="endDate" id="endDate"> <b></b>
			<hr>
			<p>다른 사람들과 수행률을 비교해보세요</p>
			<b>Sharing </b>
			<label class="switch">
			  <input type="checkbox" checked>
			  <span class="slider round"></span>
			</label><br><hr>
			<p>도전의 상세내용을 작성해보세요</p>
			<button id="addItemBtn">+</button>
			<table id="example" border="1px">
        <tr>
            <th>옵션명</th>
            <th>항목명</th>
            <th>필수항목</th>
            <th>가격</th>
            <th>재고</th>
            <th>옵션추가</th>
        </tr>
        <tr class="item1">
            <td><input type="text" /><button class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
        </tr>
        <tr class="item2">
            <td><input type="text" /><button class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
        </tr>
        <tr class="item3">
            <td><input type="text" /><button class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
        </tr>
        <tr class="item4">
            <td><input type="text" /><button class="addBtn">항목추가</button></td>
            <td><button class="delBtn">삭제</button></td>
        </tr>
</table>

		</div>
	</aside>
</form>
</body>
</html>