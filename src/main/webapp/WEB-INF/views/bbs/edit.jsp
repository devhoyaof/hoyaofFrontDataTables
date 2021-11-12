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
					<table class="table is-bordered-title-s">
						<colgroup>
							<col width="10%">
							<col width=";">
						</colgroup>
						<tbody>
						<tr>
							<th>제목 *</th>
							<td><input type="text" name="title" id="title" maxlength="30" style="width: 100%"></td>
							<td><input type="hidden" name="bno" id="bno"></td>
						</tr>
						<tr>
							<th>작성자 *</th>
							<td><input type="text" name="writer" id="writer" maxlength="30" style="width: 100%"></td>
						</tr>

						<tr>
							<th>작성된 시간</th>
							<td><input type="text" id="regDttm" readOnly></td>
						</tr>
						<tr>
							<th>내용</th>
							<td><textarea id="bcontent" name="bcontent" cols="100" rows="30" style="width: 100%"></textarea></td>
						</tr>
						</tbody>
					</table>

					<!-- 버튼 영역 -->
					<div class="board_btn_area pt20">
						<div class="fL"><a href="javascript:;" class="cancelBtn btn">목록으로</a></div>
						<div class="fR"><a href="javascript:;" class="saveAddBtn btn">저장</a></div>
					</div>
					<!-- //버튼 영역 -->
				</section>
			</div>
		</div>
	</div>
	<!-- s : 메인 콘텐츠  -->
</div>

<script src="/js/boardEdit.js"></script>


<script>
	$(function(){
		evalboardEditInit();
	});
</script>
</body>
</html>
