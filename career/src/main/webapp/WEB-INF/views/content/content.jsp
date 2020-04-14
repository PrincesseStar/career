<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<title>Main</title>
<script>
	$(document).ready(function(){
		$("#write").click(function(){
			location.href = "${pageContext.request.contextPath}/content/write.do";
		});
	});
</script>
</head>
<body>
<!-- 검색부분 -->
<div class="div_search">
	<form name="form" action="${pageContext.request.contextPath}/content/list.do" method="post">
		<select name="searchOption">
			<!--<options items="${searchCd}" itemLabel="codeDtlNm" itemValue="codeDtlCd"/>-->
			<c:forEach items="${searchCd}" var="search">
				<option value="${search.codeDtlCd}" <c:out value="${searchOption == search.codeDtlCd?'selected':''}"/>>${search.codeDtlNm}</option>
			</c:forEach>
		</select>
		<input type="text" name="keyward" class="input_search" value="${keyward}"/>
		<button type="submit" id="search" class="btn_menu">조회</button>
		<button type="button" id="write" class="btn_menu">글쓰기</button>
	</form>
</div>
<!-- 조회부분 -->
<div class="div_select">
	<table class="type11">
		<tr>
			<th width="5%"  scope="cols">순번</th>
			<th width="70%" scope="cols">제목</th>
			<th width="10%" scope="cols">등록자</th>
			<th width="20%" scope="cols">등록일시</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td>${row.seq}</td>
			<td align="left">${row.title}</td>
			<td>${row.regId}</td>
			<td>${row.regDate}</td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
