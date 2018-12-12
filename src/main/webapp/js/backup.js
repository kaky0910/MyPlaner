   function renderChallenge(challArr){
		var str = new StringBuffer();
		for(i=0;i<challArr.length;i++){
			str.append(makeChallCard(challArr[i]));
		}
		str.append(newChallengeDiv());
		$('.glider').html(str.toString());
	}

	var StringBuffer = function(){
		this.buffer = new Array();
	};
	StringBuffer.prototype.append = function(str){
		this.buffer.push(str);
		return this;
	};
	StringBuffer.prototype.toString = function(){
		if(this.buffer.length>1) return this.buffer.join('');
		return;
		
	}


	function makeChallCard(challenge){
		var str = new StringBuffer();
		str.append('<div class="challengeSection"><div class="card"><div class="card-face face-1"><div class="card-face__avatar">'
					+'<img src="https://image.flaticon.com/icons/svg/188/188241.svg" width="110" height="110" draggable="false"/></div>'
					+'<h2 id="challengeTitle" class="card-face__name">');
		str.append('<b>'+challenge.challengeTitle+'</b></h2>');
		str.append('<span class="card-face__title"><b>'+challenge.memberNo+'</b></span>');
		str.append('<div class="challenge-content"><h4><b> STARTDATE : </b> <span id="startDate">'+challenge.challengeStartDate+'</span>');
		str.append('<br> <b> ENDDATE : </b> <span id="endDate">'+challenge.challengeEndDate+'</span></h4>');
		str.append('<b>Category : </b><label id="challengeCategory">'+challenge.challengeCategory+'</label><br>');
		str.append('<b>Sharing : </b><label id="challengeSharing">'+challenge.challengeSharing+'</label><hr><ul style="text-align: left">');
		/* for(i=0;i<challenge.challengeLogList.length;i++){
			str.append('<li><b>Day '+challenge.challengeLogList[i].dayCount+'</b>'+challenge.challengeLogList[i].challengeLogContent);
		} */
		str.append('</ul><hr><em>'+challenge.challengeLikes+'명</em>이 응원합니당.</div></div></div></div>');
		return str.toString();
	}

	function newChallengeDiv(){
		var str = new StringBuffer();
		str.append('<div id="newchallengeDiv" class="newchallengeDiv"  style="width: 290px; height: 500px"><div class="card">');
		str.append('<img src="${path}/img/writeChallenge.png" style="display: block; margin: auto; width: 50%; margin-top: 38%"><br><br>');
		str.append('<h3 align="center">새로운 도전을 해보세요!</h3><br><button id="newChallengeBtn" style="margin-left: 46%">GO</button></div></div>');
		return str.toString();
	}

	function addChallenge() {
	   var flag = $('input:checked').length;
	   $('.challengeSection .center:eq(0)').css('background-color','red');
	   $.ajax({
	            url : 'addChallenge.do',
	            method : 'post',
	            dataType : 'json',
	            data : {
	               "challengeTitle" : $(
	                     'input[name=challengeTitle]')
	                     .val(),
	               "challengeCategory" : $(
	                     'select option:selected').val(),
	               "challengeStartDate" : $(
	                     'input[name=challengeStartDate]')
	                     .val(),
	               "challengeEndDate" : $(
	                     'input[name=challengeEndDate]')
	                     .val(),
	               "challengeSharing" : flag,
	               "memberNo" : $(
	               'input[type=hidden]')
	               .val(),
	               "month" : moment().format('YYYYMM') 
	            },
	            success : function(result) {
	            	renderChallenge(result.json.challenge);
	            }
	         });//ajax
	}//addChallenge