function evalboardWriteInit(){
	eventBind();
}

function eventBind(){
	$(document).on('click', '.cancelBtn', function(){
		location.href = '/jsp/cnboard/common1_list.jsp';
	});

	// 등록
	$(document).on('click', '.saveAddBtn', function(){
		var managerInfo = getManagerInfo();
		if(managerInfo){
			reqAddManager(managerInfo);
		}
	});
}

function getManagerInfo(){
	//oEditors.getById["bcontent"].exec("UPDATE_CONTENTS_FIELD", []);

	var resultObj = new Object();
	var title = $('#title').val();
	var write = $('#write').val();
	var content = $('#context').val();

	if(!title && title.length <= 0){
		alert('제목을 입력해 주세요.');
		$('#title').focus();
		return null;
	}else{
		resultObj.title = title;
	}

	if(!write && write.length <= 0){
		alert('작성자를 입력해 주세요.');
		$('#write').focus();
		return null;
	}else{
		resultObj.writer = write;
	}

	var content = $("#context").val();
	if(!content)  {
		alert("내용을 입력하세요.");
		//oEditors.getById["bcontent"].exec("FOCUS"); //포커싱
		return null;
	}else{
		resultObj.content = content;
	}
//	var fileId = G_FILE_IDS
//	if(fileId.length <= 0){
//		fileId = null;
//	}else{
//		resultObj.fileId = fileId;
//	}

	return resultObj;
}

function reqAddManager(result){
	// if(debugOption.network()){
	// 	console.log('[REQ][POST][reqAddManager] data : ', dataObj);
	// 	console.log(JSON.stringify(dataObj));
	// }
	$.ajax({
		type : "POST",
		url : "/bbs/save.do",
		data : JSON.stringify(result),
		async : true,
		headers : { // Http header
			"Content-Type" : "application/json"
		},
		dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
		success:function(result) {
			reqAddManagerCB(result);
		},
		error: function(error) {
			console.log(error + "실패...")
		}
	});
}

function reqAddManagerCB(object){
	// if(debugOption.network()){
	// 	console.log('[RES][POST][reqAddManagerCB] object : ', object);
	// }
	if(object){
		alert('등록되었습니다.');
		location.href = '/bbs/list.do';
	}else{
		if(object.message){
			alert(object.message);
		}
	}
}