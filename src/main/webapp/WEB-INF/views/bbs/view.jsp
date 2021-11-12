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


<div id="container" class="is-admin">
	<!-- s : 메인 타이틀  -->
	<div class="contents-title clear">
		<h3 class="title fl">게시판 상세 및 수정</h3>
	</div>
	<!-- e : 메인 타이틀  -->

	<!-- s : 메인 콘텐츠  -->
	<div class="contents-body">
		<div class="contents-body-listfull scrollbar-inner">
			<div class="contents-top-eval clear">
				<section class="section">
					<table summary="" cellspacing="0" cellpadding="0" class="board_view">
						<colgroup>
							<col width="10%">
							<col width="*">
							<col width="10%">
							<col width="20%">
							<col width="10%">
							<col width="20%">
						</colgroup>
						<tbody>
						<tr>
							<th>제목</th>
							<td id="title"> </td>
							<th>작성일</th>
							<td id="regdate"> </td>
							<th>작성자</th>
							<td id="writer"> </td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="6">
								<div id="bcontent" style="height: auto; margin: 10px;"></div>
							</td>
						</tr>
						</tbody>
					</table>

					<!-- 버튼 영역 -->
					<div class="board_btn_area">
						<div class="fR">
							<a href="javascript:;" class="btn mr10 listBtn">목록</a>
							<a href="javascript:;" class="btn editBtn">수정</a></div>
					</div>
					<!-- //버튼 영역 -->
				</section>
			</div>
		</div>
	</div>
	<!-- s : 메인 콘텐츠  -->
</div>

<script src="/js/boardDetail.js"></script>


<script>
	$(function(){
		evalboardDetailInit();
	});
</script>
</body>
</html>
