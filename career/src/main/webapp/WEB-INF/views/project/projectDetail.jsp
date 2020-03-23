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

<form:form fole="form" commandName="projectDetail" method="Post">
	<div>
		<label for="prjName">프로젝트명</label>
		<form:input type="text" placeholder="ID" path="prjName"/>
		<form:errors path="prjName"/>
	</div>
	<div>
		<label for="keyword">키워드</label>
		<form:input type="text" placeholder="ID" path="keyword"/>
		<form:errors path="keyword"/>
	</div>	
	<div>
		<label for="state">상태</label>
		<form:input width="50" type="text" placeholder="ID" path="state"/>
		<form:errors path="state"/>
	</div>		
	<div>
		<label for="prjMemo">메모</label>
		<textarea name="prjMemo" id="prjMemo" cols="70" rows="17"/>${projectDetail.prjMemo}</textarea>
	</div>		
</form:form>
	
</body>
</html>
