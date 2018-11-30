<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

<script type="text/javascript">
	$(function(){
		$('img').click(function(){
			document.location.href= "https://kauth.kakao.com/oauth/authorize?client_id=08b70259b4cb9d20d263e23ccd2047bc&redirect_uri=http://localhost:8888/plan/kakaoLogin.do&response_type=code";
		});
	});
</script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('input[type=button]').click(function() {/* 
			$('div img:eq(0)').css('display', 'none');
			$('div img:eq(1)').css('display', 'block'); */
			$('div img').attr('src','${pageContext.request.contextPath}/img/unlock.gif');
			$('h2').css({
			      "display": "block",
			      "text-align": "center"
			    });
			$('h3').css('text-decoration', 'line-through');
		});
	});//ready
</script>
<style>
.center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	/* width: 50%; */
}
</style>
</head>
<body>
	<h1 align="center">Login</h1><br><br>
	<form action="">
		id : <input type="text" name="id"><br>
		password : <input type="password" name="password"><br>
		<input type="submit" value="로그인">
	</form>
	<br><br><br>
	<a id="kakao-login-btn"></a>
	<script type='text/javascript'>
		//<![CDATA[
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
		Kakao.init('2bc15dc5607c21592bdbfa1f2d3561a9');
		// 카카오 로그인 버튼을 생성합니다.
		Kakao.Auth.createLoginButton({
			container : '#kakao-login-btn',
			success : function(authObj) {
				// 로그인 성공시, API를 호출합니다.
				Kakao.API.request({
					url : '/v2/user/me',
					success : function(res) {
						document.location.href = "kakaoLogin.do?kakaoId="
								+ res.id + "&&mail=" + res.kakao_account.email
								+ "&&gender=" + res.kakao_account.gender
								+ "&&birth=" + res.kakao_account.birthday;
					},
					fail : function(error) {
						alert(JSON.stringify(error));
					}
				});
			},
			fail : function(err) {
				alert(JSON.stringify(err));
			}
		});
		//]]>
	</script>


<h1 style="margin-top: 150px;" align="center">MyPlan</h1>
	<div>
		<img class="center" style="left: 29.5%;" alt="lock"
			src="${pageContext.request.contextPath}/img/lock.jpg" height="180">
		
	</div>
	<div>
		<h2 style="display:none;">Login을 눌러주세요~</h2>
		<br><input type="button" value="button" style="margin-left:48%">
	</div>
	<div>
		<h3 align="center">TEST</h3>
	</div>
	
</body>
</html>