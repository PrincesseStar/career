<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
<title>Write</title>
</head>
<body>
	<div class="div_input">
		<p3>프로젝트 등록</p3>
	</div>
	<form:form name="content" modelAttribute="Content" action="${pageContext.request.contextPath}/content/save.do" method="post">
		<div class="div_input">
			<label for="" class="label_input">프로젝트명</label>
			<form:input type="text" path="title" class="input_content" />
		</div>
		<div class="div_input">
			<label for="" class="label_input">사용언어</label>
			<form:select path="language" class="select1">
				<form:options items="${language}" itemLabel="codeDtlNm" itemValue="codeDtlCd"/>
			</form:select>
		</div>	
		<div class="div_input">
			<label for="" class="label_input">위치</label>
			<form:input type="text" path="location" class="input_content" />
		</div>				
		<div class="div_input1">
			<!--<label for="" class="label_input1" height="1000">내용</label>-->
			<form:textarea path="content" id="content" class="textarea1"/>
			<script type="text/javascript">
				 CKEDITOR.replace('content',{
					 height: 150,
					 width: 700
				 });
			</script>
		</div>
		<div class=div_input2>
			<button type="submit" id="save" class="btn_save">저장하기</button>	
		</div>			
	</form:form>
</body>
</html>