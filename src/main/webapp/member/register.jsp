<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	// Remy function
@function remy($value) {
  @return ($value / 16px) * 1rem;
}

body {
  font: 100% / 1.414 "Open Sans", "Roboto", arial, sans-serif;
  background: #e9e9e9;
}
a,
[type="submit"] {transition: all .25s ease-in;}
.signup__container {
  position: absolute;
  top: 50%;
  right: 0;
  left: 0;
  margin-right: auto;
  margin-left: auto;
  transform: translateY(-50%);
  overflow: hidden;
  display: flex;
  align-items: center;
  justify-content: center;
  width: remy(800px);
  height: remy(480px);
  border-radius: remy(3px);
  box-shadow: 0px remy(3px) remy(7px) rgba(0,0,0,.25);
}
.signup__overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,.76);
}
.container__child {
  width: 50%;
	height:800px;
  color: #fff;
}
.signup__thumbnail {
	position: relative;
	padding: 2rem;
	display: flex;
	flex-wrap: wrap;
	align-items: center;
	background-repeat: no-repeat;
	background-position: top center;
	background-size: cover;
}
.thumbnail__logo,
.thumbnail__content,
.thumbnail__links {
  position: relative;
  z-index: 2;  
}
.thumbnail__logo {align-self: flex-start;}
.logo__shape {fill: #fff;}
.logo__text {
  display: inline-block;
  font-size: .8rem;
  font-weight: 700;
  vertical-align: bottom;
}
.thumbnail__content {align-self: center;}
h1,
h2 {
  font-weight: 300;
  color: rgba(255,255,255,1);
}
.heading--primary {font-size: 1.999rem;}
.heading--secondary {font-size: 1.414rem;}
.thumbnail__links {
  align-self: flex-end;
  width: 100%;
}
.thumbnail__links a {
  font-size: 1rem;
  color: #fff;
  &:focus,
  &:hover {color: rgba(255,255,255,.5);}
}
.signup__form {
  padding: 2.5rem;
  background: #fafafa;
}
label {
  font-size: .85rem;
  text-transform: uppercase;
  color: #ccc;
}
.form-control {
  background-color: transparent;
  border-top: 0;
  border-right: 0;
  border-left: 0;
  border-radius: 0;
  &:focus {border-color: #111;}
}
[type="text"] {color: #111;}
[type="password"] {color: #111;}
.btn--form {
  padding: .5rem 2.5rem;
  font-size: .95rem;
  font-weight: 600;
  text-transform: uppercase;
  color: #fff;
  background: #111;
  border-radius: remy(35px);
  &:focus,
  &:hover {background: lighten(#111, 13%);}
}
.signup__link {
  font-size: .8rem;
  font-weight: 600;
  text-decoration: underline;
  color: #999;
  &:focus,
  &:hover {color: darken(#999, 13%);}
}
.form-group{
	padding-left:20%;
	width:100%;
	height:50px;
}
.form-group span{
	width:130px;
	color: black;
	display: inline-block;
}
</style>
<c:set var="path" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<script type="text/javascript">
var idCheckFlag = false;			// 아이디 체크해서 없는 아이디면 true
	$(function(){
		$('#idCheck').click(function(){
			$.ajax({
				method : 'get',
				url : '${path}/idCheck.do',
				data : {"id" : $('#id').val()},
				success : function(data){
					if(!data.flag) {
						idCheckFlag = true;
						alert('사용 가능합니다.')
					}
					else {
						idCheckFlag = false;
						alert('이미 존재하는 id 입니다.');
					}
				}
			});
		});
		
		$('#password').keyup(function(){
			var p = $('#password').val();
			var flag = false;
			if(p.length<8) {
				$('#pass').css('color','red').html('unavailable');
				return;
				}
			for(i=0;i<10;i++){
				if(p.includes(i)) flag = true;
			}
			if(!flag) {
				return;
				$('#pass').css('color','red').html('unavailable');
			}
			if(flag && (p.toLowerCase()!=p || p.toUpperCase()!=p)){
				$('#pass').css('color','green').html('available');
			} else{
				$('#pass').css('color','red').html('unavailable');
			}
		});
		
		$('#passwordRepeat').keyup(function(){
			var p = $('#passwordRepeat').val();
			if(p==$('#password').val()){
				$('#passCheck').css('color','green').html('correct');
			}else{
				$('#passCheck').css('color','red').html('incorrect');
			}
		});
	});
</script>
</head>
<body>
	<div class="signup__container row">
		<div class="container__child signup__thumbnail col-6">
			<div id="demo" class="carousel slide" data-ride="carousel" style="width: 100%">

				<!-- Indicators -->
				<ul class="carousel-indicators">
					<li data-target="#demo" data-slide-to="0" class="active"></li>
					<li data-target="#demo" data-slide-to="1"></li>
					<li data-target="#demo" data-slide-to="2"></li>
				</ul>

				<!-- The slideshow -->
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="${path}/img/unlock.gif" alt="Los Angeles" width="100%">
					</div>
					<div class="carousel-item">
						<img src="${path}/img/set.png" alt="Chicago" width="100%">
					</div>
					<div class="carousel-item">
						<img src="${path}/img/blank.jpg" alt="New York" width="100%">
					</div>
				</div>

				<!-- Left and right controls -->
				<a class="carousel-control-prev" href="#demo" data-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</a> <a class="carousel-control-next" href="#demo" data-slide="next">
					<span class="carousel-control-next-icon"></span>
				</a>
			</div>
		</div>
		<div class="container__child signup__form col-6">
			<form action="${path}/memberRegist.do"
				style="margin-top: 15%; margin-left:0">
				<div class="form-group">
					<span>ID</span> <input class="form-control" type="text" name="id" style="width: 50%; display: inline-block;"
						id="id" placeholder="james.bond" required /> <input type="button"
						value="check" id="idCheck">
				</div>
				<div class="form-group">
					<span>Password</span> <input class="form-control" type="password" style="width: 50%; display: inline-block;"
						name="password" id="password" placeholder="최소 8자리 영어,숫자혼합"
						required /> <span style="color: red; margin-left: 10px; width: auto;" id="pass">unavailable</span>
				</div>
				<div class="form-group">
					<span>Password Check</span> <input class="form-control" style="width: 50%; display: inline-block;"
						type="password" name="passwordRepeat" id="passwordRepeat"
						placeholder="********" required /><span style="color: red; margin-left: 10px; width: auto;"
						id="passCheck">incorrect</span>
				</div>
				<div class="form-group">
					<span>Email</span> <input class="form-control" type="text" style="width: 50%; display: inline-block;"
						name="mail" id="email" placeholder="james.bond@spectre.com"
						required />
				</div>
				<div class="form-group">
					<span>BirthDay</span><input class="form-control" type="date" style="width: 50%; display: inline-block;"
						name="birth" id="birth" required>
				</div>
				<div class="form-group">
					<span>Gender</span> <select name="gender" style="height: 25px">
						<option value="m">남자</option>
						<option value="f">여자</option>
					</select>
				</div>
				<div class="m-t-lg" style="margin-left: 40%;">
					<ul class="list-inline">
						<li><input class="btn btn--form" type="submit"
							value="Register" /><a class="signup__link" href="#" style="margin-left:20px ">I am already a
								member</a>
						<li>
					</ul>
				</div>
			</form>
		</div>
	</div>
</body>
</html>