<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>	
<title>Write</title>
<script>
	$(document).ready(function(){
		$("#write").click(function(){
			location.href = "${pageContext.request.contextPath}/temp/write.do";
		});
	});
</script>
</head>
<body>
<div class="div_input">
	<p3>[임시저장]</p3>
	<button type="button" id="write" class="btn_menu">글쓰기</button>
</div>

<!-- 조회부분 -->
<div class="div_select">
	<br>
	<c:forEach var="row" items="${list}">
	<table class="type12">
		<th width="70%" scope="cols" align="left">${row.gubun}</th>
		<th width="5%" scope="cols"><a href="${pageContext.request.contextPath}/temp/detail.do?seq=${row.seq}">수정</a></button>
		</th>	
		<tr>
			<td colspan="2" align="left">${row.memo}</td>
		</tr>
	</table>
	</c:forEach>
</div>
	
</body>
</html>