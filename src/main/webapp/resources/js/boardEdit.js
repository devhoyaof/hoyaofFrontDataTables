var articleNo = null;

function evalboardEditInit() {
	articleNo = MUtilComm_GetParam('articleNo');
	eventBind();
	evalboardEditView(articleNo);
}

function eventBind(){
	// 저장
	$(document).on('click', '.saveAddBtn', function(){
		var managerInfo = getManagerInfo();
		if(managerInfo){
			reqUdManager(managerInfo);
		}
	});

	// 목록
	$(document).on('click', '.listBtn', function() {
		location.href = '/bbs/list.do';
	});
}


// 유효성 검사
function getManagerInfo(){
	//oEditors.getById["bcontent"].exec("UPDATE_CONTENTS_FIELD", []);

	var resultObj = new Object();
	resultObj.articleNo = articleNo;


	var title = $('#title').val();
	if(!title && title.length <= 0){
		alert('제목을 입력해 주세요.');
		$('#title').focus();
		return null;
	}else{
		resultObj.title = title;
	}
	var writer = $('#writer').val();
	if(!title && title.length <= 0){
		alert('작성자 입력해 주세요.');
		$('#writer').focus();
		return null;
	}else{
		resultObj.writer = writer;
	}
	var content = $('#bcontent').val();
	if(!content && content.length <= 0){
		alert('내용을 입력해 주세요.');
		$('#bcontent').focus();
		return null;
	}else{
		resultObj.content = content;
	}

	/*var bcontent = $("#bcontent").val();
	if( bcontent == ""  || bcontent == null || bcontent == '&nbsp;' || bcontent == '<p>&nbsp;</p>')  {
		alert("내용을 입력하세요.");
		oEditors.getById["bcontent"].exec("FOCUS"); //포커싱
		return null;
	}else{
		resultObj.bcontent = bcontent;
	}
	var fileId = G_FILE_IDS
	if(fileId.length <= 0){
		fileId = null;
	}else{
		resultObj.fileId = fileId;
	}*/


	return resultObj;
}

function evalboardEditView(getArticleNo) {

	$.ajax({
		type : "GET",
		url : '/bbs/view.do?articleNo=' + articleNo,
		async : true,
		headers : { // Http header
			"Content-Type" : "application/json"
		},
		dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
		success:function(data) {
			boardEditCreate(data);
		},
		error: function(error) {
			console.log(error + "실패...")
		}
	});

}

function boardEditCreate(data) {
	if (data) {
		$('#title').val(data.title);
		$('#writer').val(data.writer);
		$('#bcontent').val(data.content);
		$('#regDttm').val(data.regDate);
	}
}






function boardEditUpdate(object){
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

function MUtilComm_GetParam(name) {
	var rtnval = '';
	var nowAddress = unescape(decodeURIComponent(location.href));
	var parameters = (nowAddress.slice(nowAddress.indexOf('?')+1,nowAddress.length)).split('&');
	for(var i = 0 ; i < parameters.length ; i++)
	{
		var varName = parameters[i].split('=')[0];
		if(varName.toUpperCase() == name.toUpperCase())
		{
			rtnval = parameters[i].split('=')[1];
			break;
		}
	}
	return rtnval;
}

