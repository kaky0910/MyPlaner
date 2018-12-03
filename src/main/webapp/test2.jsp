<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<link rel="stylesheet"
   href="${pageContext.request.contextPath}/css/calendar.css">

<script src="${pageContext.request.contextPath}/js/moment.js"></script>
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
   
   <div style="height: 300px; color: black;"></div>
   <div id="section1">
      <div class="calendar" id="calendar">
      <p id="title_monthdate"><a href="#" style="text-decoration: none; color:#A8B2B9">↓</a>11월<a href="#" style="text-decoration: none; color:#A8B2B9">↑</a>
      <a href="#" style="text-decoration: none; color:#A8B2B9">↓</a>28일<a href="#" style="text-decoration: none; color:#A8B2B9">↑</a></p>
         <div class="calendar__header">
            <div>mon</div>
            <div>tue</div>
            <div>wed</div>
            <div>thu</div>
            <div>fri</div>
            <div>sat</div>
            <div>sun</div>
         </div>
         <div class="calendar__week">
            <div class="calendar__day day">1
            <hr style="border:solid 1px red;"><hr style="margin-top: 20px"><hr style="margin-top: 20px"></div>
            <div class="calendar__day day">2
            <hr style="border:solid 1px red;"></div>
            <div class="calendar__day day">3
            <hr style="border:solid 1px red;"></div>
            <div class="calendar__day day">4</div>
            <div class="calendar__day day">5</div>
            <div class="calendar__day day">6</div>
            <div class="calendar__day day">7</div>
            <div>asdasdasdasd</div>
         </div>
         <div class="calendar__week">
            <div class="calendar__day day">8</div>
            <div class="calendar__day day">9</div>
            <div class="calendar__day day">10</div>
            <div class="calendar__day day">11</div>
            <div class="calendar__day day">12</div>
            <div class="calendar__day day">13</div>
            <div class="calendar__day day">14</div>
         </div>
         <div class="calendar__week">
            <div class="calendar__day day">15</div>
            <div class="calendar__day day">16</div>
            <div class="calendar__day day">17</div>
            <div class="calendar__day day">18</div>
            <div class="calendar__day day">19</div>
            <div class="calendar__day day">20</div>
            <div class="calendar__day day">21</div>
         </div>
         <div class="calendar__week">
            <div class="calendar__day day">22</div>
            <div class="calendar__day day">23</div>
            <div class="calendar__day day">24</div>
            <div class="calendar__day day">25</div>
            <div class="calendar__day day">26</div>
            <div class="calendar__day day">27</div>
            <div class="calendar__day day">28</div>
         </div>
         <div class="calendar__week">
            <div class="calendar__day day">29</div>
            <div class="calendar__day day">30</div>
            <div class="calendar__day day">31</div>
            <div class="calendar__day day">1</div>
            <div class="calendar__day day">2</div>
            <div class="calendar__day day">3</div>
            <div class="calendar__day day">4</div>
         </div>
      </div>
      <div id="search" style="float: left; width: 20%"></div>
   </div>
   
   
   <div id="section1">
</body>
</html>