var colorArr = ['red','yellow','green','blue','pink','orange'];
function calendarInit(y,m){
	
	var curDay = moment().month(m).date();
	var curMonth = moment().month(m).month();
	var curYear = moment().year(y); 
	var dayOfWeek = moment().month(m).weekday(); // sun : 0 ~~ sat : 6
	var day1OfMonth;					// 현재 month의 1일의 요일
	
	//달력에 x월 x일 mark
	markym(y,m);
	
	var cha = curDay%7 - 1;
	if((dayOfWeek - cha)>=0) day1OfWeek = dayOfWeek - cha;
	else day1OfWeek = (dayOfWeek - cha)+7;
	
	var day31 = [1,3,5,7,8,10,12];
	var endOfMonth = moment(y+""+m,"yyyymm").daysInMonth();
	
	
	// month의 일수를 계산. endOfMonth 에
	if(endOfMonth == 31){
		if(day1OfWeek>=5) {
			var arr = $('.calendar__week');
			if(arr.length==5)
				$('#calendar').append('<div class="calendar__week"></div>');
		}
	} else if(endOfMonth == 30){
		if(day1OfWeek==6){
			var arr = $('.calendar__week');
			if(arr.length==5)
				$('#calendar').append('<div class="calendar__week"></div>');
		}
	}
	
	
	//calendar div에 day추가
	var dayCount=1;
	var dayOfWeekCount=0;
	var arrCursor = 0;
	for(i=0;i<day1OfWeek;i++){
		$('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day" style="background-color:white;"></div>');
		dayOfWeekCount++;
	}
	for(dayCount;dayCount<=endOfMonth;dayCount++){
		if(dayOfWeekCount==7) {
			arrCursor+=1;
			dayOfWeekCount=0;
		}
		$('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day" style="background-color:white;" id="day'+dayCount+'"><span>'+dayCount+'</span></div>');
		dayOfWeekCount++;
	}
	if(dayOfWeekCount<7){
		while(dayOfWeekCount!=7){
			$('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day" style="background-color:white;"></div>');
			dayOfWeekCount++;
		}
	}
	
	
	
}

function markym(y,m){
	$('#title_monthdate').append(y+"년 "+(m+1)+"월");
}


function next(){
	var arr;
	new Promise(function(resolve, reject) { 
		monthCount++;
		if(monthCount == 12){
			monthCount=0;
			yearCount++;
		}	
		resolve(monthCount,yearCount);
	}).then(function(monthCount,yearCount){

		$('#title_monthdate').html('');
		$('.calendar__week').each(function(){
			$(this).html('');
		});
		var str = yearCount+""+monthCount;
		return ;
	}).then(function(){
		var month = monthCount+1;
		if(month<10) month="0"+month;
		$.ajax({
			url : "getScheduleByMonth.do",
			data : {
				"month" : yearCount+""+month
			},
			success : function(data){
				new Promise(function(resolve, reject) { 
					calendarInit(yearCount,monthCount);
					arr = data.daily.scheduleFormattedArray;
					resolve();
				}).then(function(){
					setChallenge1(arr);
				}).then(function(){
					setChallenge2(arr);
				}).then(function(){
					setChallenge3(arr);
				}).then(function(){
					$(function(){
						$('.calendar__day').hover(function() {
					    	if($(this).attr('id')!=null && ($(this).hasClass('c1')||$(this).hasClass('c2')||$(this).hasClass('c3'))){
								$.ajax({
									url : "getScheduleByDay.do",
									data : {
										month : yearCount + "" + month,
										d : $(this).attr('id')
									},
									success : function(data) {
										if(data.json!= ""){}
									}
								});
								TweenMax.to(this, 0.5, {
									scale : 3
								});
								$(this).css('z-index', '100');
								$(this).find('hr').css('display', 'none');
							}
						}, function() {
							if ($(this).attr('id') != null) {
								TweenMax.to(this, 0.5, {
									scale : 1
								});
								$(this).css('z-index', '0');
								$(this).find('hr').css('display', 'block');
							}
						});
					});
				});
			}
		});
	});
	
	

}

function prev(){
	var arr;
	new Promise(function(resolve, reject) { 
		monthCount--;
		if(monthCount <0){
			monthCount=11;
			yearCount--;
		}	
		resolve(monthCount,yearCount);
	}).then(function(monthCount,yearCount){

		$('#title_monthdate').html('');
		$('.calendar__week').each(function(){
			$(this).html('');
		});
		var str = yearCount+""+monthCount;
		return ;
	}).then(function(){
		var month = monthCount+1;
		if(month<10) month="0"+month;
		$.ajax({
			url : "getScheduleByMonth.do",
			data : {
				"month" : yearCount+""+month
			},
			success : function(data){
				new Promise(function(resolve, reject) { 
					calendarInit(yearCount,monthCount);
					arr = data.daily.scheduleFormattedArray;
					resolve();
				},function(e){
					alert(e);
				}).then(function(){
					setChallenge1(arr);
				}).then(function(){
					setChallenge2(arr);
				}).then(function(){
					setChallenge3(arr);
				}).then(function(){
					$(function(){
						$('.calendar__day').hover(function(){
					    	if($(this).attr('id')!=null && ($(this).hasClass('c1')||$(this).hasClass('c2')||$(this).hasClass('c3'))){
								$.ajax({
									url : "getScheduleByDay.do",
									data : {
										month : yearCount + "" + m,
										d : $(this).attr('id')
									},
									success : function(data) {
										if(data.json!= ""){}
									}
								});
								TweenMax.to(this, 0.5, {
									scale : 3
								});
								$(this).css('z-index', '100');
								$(this).find('hr').css('display', 'none');
							}
						}, function() {
							if ($(this).attr('id') != null) {
								TweenMax.to(this, 0.5, {
									scale : 1
								});
								$(this).css('z-index', '0');
								$(this).find('hr').css('display', 'block');
							}
						});
					});
				});
			}
		});
	});
}

function markSchedule(schedule,m){
	var startDate = moment(schedule.scheduleStartDate);
	var endDate = moment(schedule.scheduleEndDate);
	var startMonth = startDate.month()+1;
	var endMonth = endDate.month()+1;
	if(startMonth!=m) {
		
	}else if(endMonth!=m){
		
	}else{
		
	}
}

function setChallenge1(arr){
	if(arr==null) return;
	const length = arr.length;
	if(length==0 || arr ==null){
		return null;
	}
	for(j=0;j<length;j++){
		var flag1 = false;					//기간내에 겹치는 일정있나
		var flag2 = false;					//일정 표시했나
		for(x=arr[length-j-1][0];x<=arr[length-j-1][1];x++){
			if($('#day'+x).hasClass('c1')) {
				flag1=true;
			}
		}
		var color = colorArr.shift();
		for(i=arr[length-j-1][0] ; i<=arr[length-j-1][1] ; i++){
			if(!flag1){
				$('#day'+i).append('<hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c1');
				flag2 = true;
			}
		}
		colorArr.push(color);

		if(flag2) arr.splice(length-j-1,1);
		flag = false;
	}
	return arr;
}

function setChallenge2(arr){
	if(arr==null) return;
	const length = arr.length;
	for(j=0;j<length;j++){
		if(arr.length==0) return;
		var flag1 = false;
		var flag2 = false;
		for(x=arr[length-j-1][0];x<=arr[length-j-1][1];x++){
			if($('#day'+x).hasClass('c2')) {
				flag1=true;
			}
		}
		
		var color = colorArr.shift();
		for(i=arr[length-j-1][0] ; i<=arr[length-j-1][1] ; i++){
			if(!flag1){
				if($('#day'+i).hasClass('c1')){
					$('#day'+i).append('<hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c2');
				}
				else{
					$('#day'+i).append('<hr style="border:white solid 1px;background-color:white;"><hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c2');
				}
				flag2 = true;
			}
		}
		colorArr.push(color);
		if(flag2) arr.splice(length-j-1,1);
		flag2 = false;
	}
	return arr;
}

function setChallenge3(arr){
	if(arr==null) return;
	const length = arr.length;
	for(j=0;j<length;j++){
		if(arr.length==0) return;
		var flag2 = false;
		
		var color = colorArr.shift();
		for(i=arr[length-j-1][0] ; i<=arr[length-j-1][1] ; i++){
			if($('#day'+i).hasClass('c2')){
				$('#day'+i).append('<hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c3');
			} else if($('#day'+i).hasClass('c1')){
				$('#day'+i).append('<hr style="border:white solid 1px;background-color:white;"><hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c3');
			} else{
				$('#day'+i).append('<hr style="border:white solid 1px;background-color:white;"><hr style="border:white solid 1px;background-color:white; "><hr style="border:'+color+' solid 1px; background-color:'+color+'">').addClass('c3');
			}
		}
		colorArr.push(color);
		if(flag2) arr.splice(length-j-1,1);
		flag2 = false;
	}
}

function getDateByTrackerId(id){
	var curDay = moment().day();
	var curDate = moment().date();
	var targetDate = curDate + (id.charAt(1)-curDay);
	var month = moment().month()+1;
	if(month<10) month = "0"+month;
	if(targetDate<10) targetDate = "0"+targetDate;
	return moment().year()+""+month+""+targetDate;
}

function getScheduleInCal(data,str){
	var arr = '${daily}';
	var s = str.substring(3);
	var result = [];
	for(var i=0; i<arr.length;i++){
		if(arr[i].startDay>arr[i].endDay && arr[i].endDay>s){
			result.push(arr[i]);
		}else if(arr[i].startDay===arr[i].endDay && arr[i].startDay==s){
			result.push(arr[i]);
		}else if(arr[i].startDay<arr[i].endDay && arr[i].startDay<s && s<arr[i].endDay){
			result.push(arr[i]);
		}
	}
	return result;
}