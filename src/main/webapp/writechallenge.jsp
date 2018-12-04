<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$('#challengeWriteOK').click(function(){
						$.ajax({
							url : "addChallenge.do",
							success:function(result){
								alert(result.json.challenge);
								
							}//success
						});//ajax
					});//click 
					</script>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/challengeCard.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/switch.css">
</head>
<body>
	<form action="addChallenge.do">
		<div class="card">
			<!-- Face 1 -->
			<div class="card-face face-1">
				<div class="challenge-content">
					<input type="text" name="challengeTitle" value="도전 제목을 입력해주세요"
						style="display: inline; margin-top: 25px; height: 25px; font-weight: 100%; font: bold;"><br>
					<b>Category</b> &nbsp;&nbsp;&nbsp;  
					<select name="challengeCategory">
						<option value="readBook">독서</option>
						
						<option value="life">생활 습관</option>
						<option value="diet">식이요법</option>
					</select><br> <br>
					<hr>
					<br> <b>STARTDATE : </b><input type="date" name="challengeStartDate"
						id="startDate" style="display: inline"><br> <b>ENDDATE
						: </b><input type="date" name="challengeEndDate" id="endDate"
						style="display: inline"> <b></b>
					<hr>
					<p style="font-size: 13px;">다른 사람들과 수행률을 비교해보세요</p>
					<b style="vertical-align: middle;">Sharing </b> <label
						class="switch"> <input name="challengeSharing" type="checkbox" checked> <span
						class="slider round"></span>
					</label><br>
					<hr>
					<p style="font-size: 13px;">도전의 상세내용을 작성해보세요</p>
					<button id="addItemBtn">+</button>
					<table id="contentTable" border="1px"
						style="width: 100%; margin: 0;">
						<tr class="item1">
							<td><input name="challengeContent" style="display: inline" type="text" />
							
								<button class="addBtn">항목추가</button></td>
							<td><button class="delBtn">삭제</button></td>
						</tr>
					</table>
					<!-- <input id="challengeWriteOK" type="submit" style="display:inline"> -->
					<button id="challengeWriteOK">확인</button>

				</div>
			</div>
		</div>

	</form>
</body>
</html>