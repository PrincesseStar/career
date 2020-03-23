<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="<c:url value="/resources/css/career.css" />" rel="stylesheet">
<title>Home</title>
<script>

</script>
</head>
<body>

<legend><p1>이력관리</p1></legend>	
<hr color="#01A7A1" size="2px" width="309px" align="left">
<div class="div_login">
	<form:form role="form" commandName="memberVO" action="${pageContext.request.contextPath}/member/loginChk.do" method="post">
		<fieldset>
			<div>
				<div>
					<label for="userId">아이디</label>
					<form:input type="text" class="input_login" placeholder="ID" path="userId"/><br>
					<form:errors path="userId" class="input_login"/>
				</div>
				<div>
					<label for="userPw">패스워드</label>
					<form:input type="password" class="input_login" placeholder="Passward" path="userPw"/><br>
					<form:errors path="userPw"/>
				</div>
			</div>
			<button type="submit" class="btn_login">로그인</button>
		</fieldset>	
	</form:form>
</div>
</body>
</html>