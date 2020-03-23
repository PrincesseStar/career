<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/career.css" />" rel="stylesheet">
<title>Main</title>
</head>
<body>

<table class="type11">
	<tr>
		<th width="3%"  scope="cols">SEQ</th>
		<th width="50%" scope="cols">프로젝트명</th>
		<th width="7%" scope="cols">상태</th>
		<th width="15%" scope="cols">키워드</th>
		<th width="10%" scope="cols">입력일시</th>
		<th width="10%" scope="cols">변경일시</th>
	</tr>
	<c:forEach var="row" items="${projectList}">
	<tr>
		<td align="center">${row.seq}</td>
		<td align="left"><a href="${pageContext.request.contextPath}/project/prjDtl.do?seq=${row.seq}">${row.prjName}</a></td>
		<td>${row.state}</td>
		<td align="left">${row.keyword}</td>
		<td>${row.createDt}</td>
		<td>${row.editDt}</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>
