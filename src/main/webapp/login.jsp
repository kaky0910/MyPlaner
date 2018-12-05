<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>

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

</body>
</html>