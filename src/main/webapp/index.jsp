<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	var geo = navigator.geolocation;
	var lon;
	var lat;
	geo.getCurrentPosition(function(position){
		lon = position.coords.longitude;
		lat = position.coords.latitude;
		alert('lon :: '+lon);
		alert('lat :: '+lat);
		$.ajax({
			method : "get",
			url: 'http://api.openweathermap.org/data/2.5/weather?lat='+lat+'&lon='+lon+'&&appid=8bc6e9cc3e1a41d04319bd97ea0e0214',
			success : function(data){
				alert(data.weather[0].main);
			}
		});
	});
</script>
</head>
<body>
	<h1>index</h1>
	${data}<br>
	<div></div>
</body>
</html>