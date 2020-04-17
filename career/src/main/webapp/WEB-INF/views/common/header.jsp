<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="true" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/smartEditor/js/service/HuskyEZCreator.js"></script>
<link href="<c:url value="/resources/css/career.css" />" rel="stylesheet">

<title>Header</title>
</head>
<body>
<div class="div_header">
	<p3>${sessionScope.userName}</p3>님 
	<button onclick="location.href='${pageContext.request.contextPath}/member/logOut.do'" type="submit" class="btn_logout">로그아웃</button>
</div>
<div class="div_menu">
	<button onclick="location.href='${pageContext.request.contextPath}/temp/list.do'" type="submit" class="btn_menu">임시저장</button>
	<button onclick="location.href='${pageContext.request.contextPath}/search/list.do'" type="submit" class="btn_menu">서칭요약</button>	
	<button onclick="location.href='${pageContext.request.contextPath}/person/list.do'" type="submit" class="btn_menu">인력관리</button>
</div>
<div class="div_hr">
	<hr color="#01A7A1" size="2px" width="700px" align="left">
</div>
</body>
</html>