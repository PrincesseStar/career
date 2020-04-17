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
<!-- 검색부분 -->
<div class="div_search">
	<form name="form" action="${pageContext.request.contextPath}/person/list.do" method="post">
		<select name="searchOption">
			<!--<options items="${searchCd}" itemLabel="codeDtlNm" itemValue="codeDtlCd"/>-->
			<c:forEach items="${searchCd}" var="search">
				<option value="${search.codeDtlCd}" <c:out value="${searchOption == search.codeDtlCd?'selected':''}"/>>${search.codeDtlNm}</option>
			</c:forEach>
		</select>
		<input type="text" name="keyward" class="input_search" value="${keyward}"/>
		<button type="submit" id="search" class="btn_menu">조회</button>
		<button type="button" id="write" class="btn_menu">인력추가</button>		
	</form>
</div>
<!-- 조회부분 -->
<div class="div_select">
	<table class="type11">
		<tr>
			<th width="5%"  scope="cols">순번</th>
			<th width="7%" scope="cols">성명</th>
			<th width="15%" scope="cols">전화번호</th>
			<th width="20%" scope="cols">현상태</th>
			<th width="50%" scope="cols">메모</th>
		</tr>
		<c:forEach var="row" items="${list}">
		<tr>
			<td><a href="${pageContext.request.contextPath}/person/detail.do?seq=${row.seq}">${row.seq}</a></td>
			<td align="left">${row.name}</td>
			<td>${row.telno}</td>
			<td align="left">${row.nowStatus}</td>
			<td align="left">${row.memo}</td>
		</tr>
		</c:forEach>
	</table>
</div>

</body>
</html>
