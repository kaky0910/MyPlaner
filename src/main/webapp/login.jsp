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
		$('input [type=button]').click(function(){
			alert($('#id').val().length);
		});
	});
</script>
<style type="text/css">
span {
	width: 50px;
}

.form-control {
	background-color: transparent;
	border-top: 0;
	border-right: 0;
	border-left: 0;
	border-radius: 0; &:
	focus {border-color: #111;
}

</style>
</head>
<body>
	<h1 align="center">Login</h1><br><br>
	<div align="center">
		<form action="login.do" style="margin-left: auto; margin-right: auto;">
			<span>id</span> : <input type="text" name="id" id="id" class="form-control"><br>
			<span>password</span> : <input type="password" name="password" id="password" class="form-control"><br>
			<input type="button" value="로그인">
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
	</div>
</body>
</html>