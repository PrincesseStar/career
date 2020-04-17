<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<title>Main</title>
<script>
	$(document).ready(function(){
		$("#write").click(function(){
			location.href = "${pageContext.request.contextPath}/person/write.do";
		});
	});
</script>
</head>
<body>
<div class="div_input">
	<p3>[서칭요약]</p3>
	<button type="button" id="write" class="btn_menu">추가</button>
</div>
<!-- 조회부분 -->
<div class="div_select">
	<table class="type11">
		<tr>
			<th width="5%"  scope="cols">공고상태</th>
			<th width="7%"  scope="cols">공고명</th>
			<th width="15%" scope="cols">키워드 및 요약</th>
		</tr>
	</table>
</div>

</body>
</html>
