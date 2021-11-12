
var articleNo = null;

function evalboardDetailInit() {
	articleNo = MUtilComm_GetParam('articleNo');

	eventBind();
	evalboardList();

}


function eventBind() {
	var articleNo = MUtilComm_GetParam('articleNo');
	if (!articleNo) {
		alert('잘못된 접근입니다.');
		location.href = '/bbs/list.do';
		return;
	}
	// 목록
	$(document).on('click', '.listBtn', function() {
		location.href = '/bbs/list.do';
	});
	// 수정
	$(document).on('click', '.editBtn', function() {
		location.href = '/bbs/edit?articleNo=' + articleNo;
	});
}

function evalboardList() {
	//var params = '';
	/*if(articleNo) {
		params = params.addParam('bno', articleNo);
	}*/
	$.ajax({
		type : "GET",
		url : '/bbs/view.do?articleNo=' + articleNo,
		async : true,
		headers : { // Http header
			"Content-Type" : "application/json"
		},
		dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
		success:function(data) {
			reqManagerListCB(data);
		},
		error: function(error) {
			console.log(error + "실패...")
		}
	});
}

function reqManagerListCB(result) {
	if (result) {
		createManagerTable(result);
	} else {
		$('.contents-body table tbody').html('<tr><td colspan="7" class="noResult"> </td></tr>');
	}
}

function createManagerTable(data) {
	if (data) {
		$('#title').html(data.title);
		$('#writer').html(data.writer);
		$('#regdate').html(data.regDate);
		$('#bcontent').html(data.content);

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

