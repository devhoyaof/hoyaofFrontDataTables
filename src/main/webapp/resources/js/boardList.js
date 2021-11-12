function boardInit(){
	boardList();
	eventBind();
}

function eventBind() {

	$('.addEvaluationBtn').on('click', function () {
		location.href = '/bbs/write.do';
	});

	$(document).on('click', '.detailView', function(){
		var idx = $(this).data('bno');
		location.href = '/bbs/view?articleNo=' + idx;
	});

	$(document).on('click', '.chk-all', function(){
		if($(this).prop('checked')){
			$(this).closest('table').find('tbody [name=chk]').prop('checked', true);
		}else{
			$(this).closest('table').find('tbody [name=chk]').prop('checked', false);
		}
	});

	$(document).on('click', '.removeBtn', function(){
		var checkList = $('.contents-body table [name=chk]:checked');
		var ids = [];
		if(checkList && checkList.length > 0){
			checkList.map(function(idx, row){
				var articleNo = $(row).data('bno');
				if(articleNo != undefined){
					ids.push(articleNo);
				}
			});
		}else{
			alert('삭제 항목을 체크해주세요.');
			return;
		}

		if(ids && ids.length > 0){
			var obj = {
				ids : ids
			};

			if(confirm('정말 삭제하시겠습니까?')){
				cnDelAccount(obj);
			}
		}
	});
}


function boardList() {

	$.ajax({
		type : "GET",
		url : "/bbs/boardList1.do",
		async : true,
		headers : { // Http header
			"Content-Type" : "application/json"
		},
		dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
		success:function(result) {
			boardListCB(result);
		},
		error: function(error) {
			console.log(error + "실패...")
		}
	});
}


function boardListCB(result) {

	/*var CODE_HTML = '';

	for(var i=0; i < result.length; i++) {
		var viewCode = result[i];

		CODE_HTML += '<tr>';
		CODE_HTML += '	<td>'+ viewCode.articleNo +'</td>';
		CODE_HTML += '	<td><a href="javascript:;" class="detailView" data-bno="'+ viewCode.articleNo +'">' + viewCode.title + '</a></td>';
		CODE_HTML += '	<td>'+ viewCode.content +'</td>';
		CODE_HTML += '	<td>'+ viewCode.writer +'</td>';
		CODE_HTML += '	<td>'+ viewCode.regDate + '</td>';
		CODE_HTML += '	<td>'+ viewCode.viewCnt +'</td>';

		CODE_HTML += '</tr>';
		if(CODE_HTML){
			$('.list_div table tbody').html(CODE_HTML);
		}
	}*/

	var TABLE_HTML = '';
	result.map(function(row, idx){
		TABLE_HTML += '<tr>';
		TABLE_HTML += '	<td class="text-center"><input type="checkbox" name="chk" id="chk-'+ idx +'" data-bno="'+ row.articleNo +'"><label for="chk-'+ idx +'"></label></td>';
		TABLE_HTML += '	<td><a href="javascript:;" class="link detailView" data-bno="'+ row.articleNo +'">'+ row.title +'</a></td>';;
		TABLE_HTML += '	<td>'+ row.regDate + '</td>';
		TABLE_HTML += '	<td>'+ (row.viewCnt == undefined ? '0' : row.viewCnt ) +'</td>';
		TABLE_HTML += '</tr>';
	});

	if(TABLE_HTML){
		$('.contents-body table tbody').html(TABLE_HTML);
	}
}



/**
 * 게시글 삭제 요청
 * @returns
 */

function cnDelAccount(dataObj){
	$.ajax({
		type : "POST",
		url : "/bbs/bnoDelEval.do",
		data : JSON.stringify(dataObj),
		async : true,
		headers : { // Http header
			"Content-Type" : "application/json"
		},
		dataType : 'json', // 데이터 타입 (html, xml, json, text 등등)
		success:function(result) {
			bnoDelEvalCB(result);
		},
		error: function(error) {
			console.log(error + "실패...")
		}
	});
}

function bnoDelEvalCB(object){
	if(object){
		alert('삭제되었습니다.');
		boardList();
	}else{
		if(object.message){
			alert(object.message);
		}
	}
}