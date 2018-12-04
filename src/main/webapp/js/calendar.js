var colorArr = ['yellow','green','blue','pink','orange','red'];
function calendarInit(y,m){
   
   var curDay = moment().month(m).date();
   var curMonth = moment().month(m).month();
   var curYear = moment().year(y); 
   var dayOfWeek = moment().month(m).weekday(); // sun : 0 ~~ sat : 6
   var day1OfMonth;               // 현재 month의 1일의 요일
   
   //달력에 x월 x일 mark
   markym(y,m);
   
   var cha = curDay%7 - 1;
   if((dayOfWeek - cha)>=0) day1OfWeek = dayOfWeek - cha;
   else day1OfWeek = (dayOfWeek - cha)+7;
   
   var day31 = [1,3,5,7,8,10,12];
   var endOfMonth;
   
   
   // month의 일수를 계산. endOfMonth 에
   if(curMonth == 1) endOfMonth=28;
   else if(day31.filter(filter1)!=0){
      endOfMonth = 31;
      if(day1OfWeek>=5) {
         var arr = $('.calendar__week');
         if(arr.length==5)
            $('#calendar').append('<div class="calendar__week"></div>');
      }
   } else{
      endOfMonth = 30;
      if(day1OfWeek==6){
         var arr = $('.calendar__week');
         if(arr.length==5)
            $('#calendar').append('<div class="calendar__week"></div>');
      }
   }
   function filter1(value, index, array){
      return value === curMonth+1;
   }//
   
   
   //calendar div에 day추가
   var dayCount=1;
   var dayOfWeekCount=0;
   var arrCursor = 0;
   for(i=0;i<day1OfWeek;i++){
      $('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day"></div>');
      dayOfWeekCount++;
   }
   for(dayCount;dayCount<=endOfMonth;dayCount++){
      if(dayOfWeekCount==7) {
         arrCursor+=1;
         dayOfWeekCount=0;
      }
      $('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day" id="day'+dayCount+'"><span>'+dayCount+'</span></div>');
      dayOfWeekCount++;
   }
   if(dayOfWeekCount<7){
      while(dayOfWeekCount!=7){
         $('.calendar__week:eq('+arrCursor+')').append('<div class="calendar__day day"></div>');
         dayOfWeekCount++;
      }
   }
   
   
   
}

function markym(y,m){
   $('#title_monthdate').append(y+"년 "+(m+1)+"월");
}


function next(){
   monthCount++;
   if(monthCount == 12){
      monthCount=0;
      yearCount++;
   }

   $('#title_monthdate').html('');
   $('.calendar__week').each(function(){
      $(this).html('');
   });
   calendarInit(yearCount,monthCount);
   
}

function prev(){
   monthCount--;
   if(monthCount <0){
      monthCount=11;
      yearCount--;
   }

   $('#title_monthdate').html('');
   $('.calendar__week').each(function(){
      $(this).html('');
   });
   calendarInit(yearCount,monthCount);
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
   const length = arr.length;
   for(j=0;j<length;j++){
      var flag1 = false;
      var flag2 = false;
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