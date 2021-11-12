<%--
  Created by IntelliJ IDEA.
  User: hoyao
  Date: 2021-11-05
  Time: 오후 3:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>

<%@include file="include/head.jsp"%>

<!-- s : 메인 콘텐츠  -->
<div class="contents-body">
	<div class="contents-body-admin scrollbar-inner">
		<!-- 리스트 -->
		<table summary="" cellspacing="0" cellpadding="0" class="board_list">
			<colgroup>
				<col style="width: 30px;" />
				<col style="*" />
				<col style="width: 200px;" />
				<col style="width: 70px;" />
			</colgroup>
			<thead>
			<tr>
				<th scope="col" align="center"><input type="checkbox" name="chk-all" id="chk-all" class="chk-all"><label for="chk-all"></label>	</th>
				<th scope="col" align="center">제목</th>
				<th scope="col" align="center">작성일</th>
				<th scope="col" align="center">조회수</th>
			</tr>
			</thead>
			<tbody>
			<tr><td colspan="6" class="noResult">리스트가 없습니다..</td></tr>
			</tbody>
		</table>
		<!-- //리스트 -->

		<!-- 버튼 영역 -->
		<div class="board_btn_area">
			<div class="fL"><a href="javascript:;" class="btn mr10 removeBtn">삭제</a></div>
			<div class="fR">
				<a href="javascript:;" class="btn addEvaluationBtn">게시글 등록</a>
			</div>
		</div>
		<!-- //버튼 영역 -->

		<!-- 페이징 -->
		<div class="pagination-wrap">
			<nav class="pagination is-centered" role="navigation" aria-label="pagination" id="pageZone">
				<!-- 							<a href="javascript:;" class="pagination-previous"><i class="icon-arrow-left-s"></i><span class="sr-only">이전 페이지 목록</span></a> -->
				<!-- 							<ul class="pagination-list"> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link is-current" aria-label="현재" aria-current="페이지">1</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="2 페이지로 가기">2</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="3 페이지로 가기">3</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="4 페이지로 가기">4</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="5 페이지로 가기">5</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="6 페이지로 가기">6</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="7 페이지로 가기">7</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="8 페이지로 가기">8</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="9 페이지로 가기">9</a></li> -->
				<!-- 								<li><a href="javascript:;" class="pagination-link" aria-label="10 페이지로 가기">10</a></li> -->
				<!-- 							</ul> -->
				<!-- 							<a href="javascript:;" class="pagination-next"><i class="icon-arrow-right-s"></i><span class="sr-only">다음 페이지 목록</span></a> -->
			</nav>
		</div>
		<!-- //페이징 -->
	</div>
</div>

<script src="/js/boardList.js"></script>


<script>
	$(function(){
		boardInit();
	});

	// 글쓰기 버튼
	$(document).on('click', '#write_bt', function(){
		location.href = '/bbs/write.do';
	});
</script>
</body>
</html>
