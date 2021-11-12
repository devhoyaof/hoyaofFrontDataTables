<%--
  Created by IntelliJ IDEA.
  User: hoyao
  Date: 2021-11-05
  Time: 오후 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<%@include file="../include/head.jsp"%>

<!-- s : 메인 콘텐츠  -->
<div class="contents-body">
	<div class="contents-body-admin scrollbar-inner">
		<!-- 리스트 -->
		<table class="table table-striped dataTable mt-0" id="deviceTable">
			<thead class="bg-secondary">
				<tr>
					<th class="text-white">articleNo</th>
					<th class="text-white">title</th>
					<th class="text-white">content</th>
					<th class="text-white">writer</th>
					<th class="text-white">viewCnt</th>
					<th class="text-white">regDate</th>
				</tr>
			</thead>
		</table>

		<!-- 버튼 영역 -->
		<div class="board_btn_area">
			<div class="fL"><a href="javascript:;" class="btn mr10 removeBtn">삭제</a></div>
			<div class="fR">
				<a href="javascript:;" class="btn addEvaluationBtn">게시글 등록</a>
			</div>
		</div>
		<!-- //버튼 영역 -->

		<!-- //리스트 -->
	</div>
</div>

<script>
	$(document).ready(function() {
		$("#deviceTable").DataTable({
			// 표시 건수기능 숨기기 false
			lengthChange: true,
			// 검색 기능 숨기기 false
			searching: true,
			// 정렬 기능 숨기기 false
			ordering: true,
			// 정보 표시 숨기기 false
			info: true,
			// 페이징 기능 숨기기 false
			paging: true,
			autoWidth: false,
			// 가로 스크롤바
			// 설정 값은 true 또는 false
			scrollX: true,
			// 세로 스크롤바
			// 설정 값은 px단위
			scrollY: 500,
			// 열 넓이 설정 columnDefs 사용
			columnDefs: [
				// 1번째 항목 넓이를 30px로 설정
				{ targets: 0, width: 30 }
			],
			// 특정 sort 기능 비활성화
			aoColumnDefs: [
				{ 'bSortable': false, 'aTargets': [ 2 ] }
			],

			ajax: { url: "/bbs/dataTableList.do", dataSrc: '', type: "POST"},
			columns: [
				{data: "articleNo"},
				{
					className : "viewDetail",
					data : "title",
					createdCell: function (td, cellData, rowData, row, col) {
						$(td).attr('data-bno', rowData.articleNo);

					}
				},
				{data: "content"},
				{data: "writer"},
				{data: "viewCnt"},
				{data: "regDate"}
			]
		});
	});

	$('.addEvaluationBtn').on('click', function () {
		location.href = '/bbs/write.do';
	});

	$(document).on('click', '.viewDetail', function(){
		var idx = $(this).data('bno');
		location.href = '/bbs/view?articleNo=' + idx;
	});


</script>


</body>
</html>
